import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MessageHandler {
    public static void handleMessages(String queue, Channel channel){
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                String wrapper = new String(body, StandardCharsets.UTF_8);
                String message;
                String[] types = wrapper.split("#");
                if(types.length >1){
                    message = types[2];
                }
                else{
                    message = types[0];
                }
                System.out.println("Received: " + message);
            }
        };
        System.out.println("Waiting for messages...");
        try {
            channel.basicConsume(queue, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
