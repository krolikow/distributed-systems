import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Agency {

    public static void main(String[] args) throws Exception {
        int ID = new Random().nextInt(100);
        System.out.println("AGENCY [ID: " + ID + "]");

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // exchange
        String exchange = "exchange";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT);

        // queue
        String queueName = "queue" + ID;
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName, exchange, Integer.toString(ID));
        System.out.println("Created queue: " + queueName + " with key " + ID);

        // exchange admin
        String adminExchange = "exchange_admin";
        channel.exchangeDeclare(adminExchange, BuiltinExchangeType.TOPIC);

        // queue admin
        String adminQueue = "Agency" + ID;
        String adminKey = "space.agency";
        channel.queueDeclare(adminQueue, false, false, false, null);
        channel.queueBind(adminQueue, adminExchange, adminKey);
        System.out.println("Created queue: " + adminQueue + " with routing key " + adminKey);


        MessageHandler.handleMessages(queueName,channel);
        MessageHandler.handleMessages(adminQueue,channel);

        while(true) {
            System.out.println("Enter service type\n- 1 - people carrier;\n- 2 - cargo carrier;\n- 3 - satellite placement");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int type = Integer.parseInt(br.readLine());
            if(type == 0) {
                break;
            }
            int orderID = new Random().nextInt(100000) % 10000;
            String message ="[orderID: " + orderID + "]";
            String wrapper = ID + "#"+message;

            String key = getKey(type);

            channel.basicPublish(exchange, key, null, wrapper.getBytes(StandardCharsets.UTF_8));
            System.out.println("Sent to " + key + " carrier: " + message);

            wrapper = "##Agency" + ID + ": " + message;
            channel.basicPublish(exchange, "admin", null, wrapper.getBytes(StandardCharsets.UTF_8));
            System.out.println("Sent to Admin: " + message);
        }
        channel.close();
        connection.close();
    }

    private static String getKey(int orderType) {
        return switch (orderType) {
            case 1 -> "people_carry";
            case 2 -> "cargo_carry";
            case 3 -> "satellite_placement";
            default -> "wrong input";
        };
    }



}