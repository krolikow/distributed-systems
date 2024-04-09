import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Admin {

    public static void main(String[] args) throws Exception {
        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // exchange
        String exchange = "exchange";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT);

        // queue
        String queueAdmin = "queue_admin";
        String adminKey = "admin";
        channel.queueDeclare(queueAdmin, false, false, false, null);
        channel.queueBind(queueAdmin, exchange, adminKey);
        System.out.println("Created queue: " + queueAdmin + " with key " + adminKey);

        // exchange admin
        String exchangeAdmin = "exchange_admin";
        channel.exchangeDeclare(exchangeAdmin, BuiltinExchangeType.TOPIC);

        // consumer (handle msg)
        MessageHandler.handleMessages(queueAdmin,channel);

        while(true) {
            System.out.println("Enter where you want to write\n- 1 - carrier;\n- 2 - agency;\n- 3 - both");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int type = Integer.parseInt(br.readLine());

            if(type == 0) {
                break;
            }
            String msg = "Message from admin!";
            String wrapper = "#admin#"+msg;
            String key;

            switch (type) {
                case 1 -> key = getKey(1);
                case 2 -> key = getKey(2);
                case 3 -> {
                    for (int i = 1; i < 3; i++) {
                        key = getKey(i);

                        // publish
                        channel.basicPublish(exchangeAdmin, key, null, wrapper.getBytes(StandardCharsets.UTF_8));
                        System.out.println("Sent: " + msg + " to " + key);
                    }
                    continue;
                }
                default -> {
                    System.out.println("Wrong input");
                    continue;
                }
            }

            // publish
            channel.basicPublish(exchangeAdmin, key, null, wrapper.getBytes(StandardCharsets.UTF_8));
            System.out.println("Sent: " + msg + " to " + key);
        }

        channel.close();
        connection.close();
    }

    private static String getKey(int orderType) {
        return switch (orderType) {
            case 1 -> "space.carrier";
            case 2 -> "space.agency";
            case 3 -> "space.#";
            default -> "wrong input";
        };
    }

}