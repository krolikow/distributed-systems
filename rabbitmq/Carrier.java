import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Carrier {

    public static void main(String[] args) throws Exception {

//        String service1 = "people_carry";
        String service1 = "satellite_placement";
        String service2 = "cargo_carry";
        int ID = new Random().nextInt(100);

        System.out.println("Carrier " + ID );
        System.out.println("Service types:\n-"+service1+"\n-"+service2);

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);
        Channel channelAdmin = connection.createChannel();

        // exchange
        String exchange = "exchange";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT);

        // queue
        String queue1 = "queue_" + service1;
        channel.queueDeclare(queue1, false, false, false, null);
        channel.queueBind(queue1, exchange, service1);
        System.out.println("Created queue: " + queue1);

        String queue2 = "queue_" + service2;
        channel.queueDeclare(queue2, false, false, false, null);
        channel.queueBind(queue2, exchange, service2);
        System.out.println("Created queue: " + queue2);

        // exchange admin
        String exchangeAdmin = "exchange_admin";
        channelAdmin.exchangeDeclare(exchangeAdmin, BuiltinExchangeType.TOPIC);

        // queue admin
        String adminQueue = "Carrier" + ID;
        String ROUTING_KEY_ADMIN = "space.carrier";
        channelAdmin.queueDeclare(adminQueue, false, false, false, null);
        channelAdmin.queueBind(adminQueue, exchangeAdmin, ROUTING_KEY_ADMIN);
        System.out.println("Created admin queue: " + adminQueue + " with key " + ROUTING_KEY_ADMIN);

        // consumer
        TopicListener topicListener1 = new TopicListener(channel, queue1, exchange, ID, ROUTING_KEY_ADMIN, service1);
        Thread rec = new Thread(topicListener1);
        rec.start();

        TopicListener topicListener2 = new TopicListener(channel, queue2, exchange, ID, ROUTING_KEY_ADMIN, service2);
        Thread rec1 = new Thread(topicListener2);
        rec1.start();

        MessageHandler.handleMessages(adminQueue,channel);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int type = Integer.parseInt(br.readLine());

        if(type == 0) {
            channel.close();
            connection.close();
        }

    }
}
