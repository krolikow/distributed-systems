import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.exit;

public class Client {
    private final int serverPort;
    private int clientPort;
    private final int MAX_CLIENTS = 10;
    private InetAddress serverAddress;
    private final ExecutorService executorService = Executors.newFixedThreadPool(MAX_CLIENTS);
    private final String hostName = "localhost";
    private Socket TCPSocket;
    private PrintWriter output;
    private BufferedReader input;

    public Client(InetAddress serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public int getClientPort() {
        return clientPort;
    }

    private void clientSetup() {
        try {
            this.TCPSocket = new Socket(this.hostName, this.serverPort);
            this.input = new BufferedReader(new InputStreamReader(this.TCPSocket.getInputStream()));
            this.output = new PrintWriter(this.TCPSocket.getOutputStream(), true);

            System.out.println("Enter your name: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            this.output.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void TCPListen() {
        this.executorService.execute(() -> {
            while (true) {
                try {
                    String receivedMessage = this.input.readLine();
                    System.out.println(receivedMessage);
                } catch (IOException e) {
                    System.out.println("Error while receiving message.");
                    break;
                }
            }
            try {
                TCPSocket.close();
                exit(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    public void run() throws IOException {
        this.clientSetup();
        this.TCPListen();
        this.userInputListen();
    }

    public static void main(String[] args) throws IOException {
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
        int serverPort = 12345;

        Client client = new Client(serverAddress, serverPort);
        System.out.println("Hello Client!");
        try {
            client.run();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while client running");
        }
    }


    private void userInputListen() {
        Scanner scanner = new Scanner(System.in);
        String messageToSend;
        while (true) {
            messageToSend = scanner.nextLine();
            try {
                this.output.println(messageToSend);
            } catch (Exception e) {
                this.stop();
                break;
            }

        }
    }


    public void stop() {
        try {
            if (this.TCPSocket != null) {
                this.TCPSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
