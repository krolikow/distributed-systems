import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public record TopicListener(Channel channel, String queueName, String exchangeName, int ID, String keyAdmin,
                            String service) implements Runnable {
    public TopicListener(Channel channel, String queueName, String exchangeName, int ID, String keyAdmin, String service) {
        this.channel = channel;
        this.queueName = queueName;
        this.exchangeName = exchangeName;
        this.ID = ID;
        this.keyAdmin = keyAdmin;
        this.service = String.valueOf(service);
    }

    @Override
    public void run() {
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String wrapper = new String(body, StandardCharsets.UTF_8);
                String[] types = wrapper.split("#");
                String agencyID = types[0];
                String message = types[1];
                System.out.println("Received: " + message);

                System.out.println("New " + service + " order");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String replay = "Carrier" + "#" + ID + "#" + message + " - processed";

                channel.basicPublish(exchangeName, agencyID, null, replay.getBytes(StandardCharsets.UTF_8));
                System.out.println("Sent to Agency" + agencyID + ": " + message);

                replay = "##Carrier" + ID + ": " + message;
                channel.basicPublish(exchangeName, "admin", null, replay.getBytes(StandardCharsets.UTF_8));
                System.out.println("Sent to Admin: " + message);
            }
        };

        // start listening
        System.out.println("Waiting for messages...");
        try {
            channel.basicConsume(queueName, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}