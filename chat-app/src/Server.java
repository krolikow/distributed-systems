import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final int portNumber;
    private final int MAX_CLIENTS = 10;
    private ServerSocket serverSocket;
    private final ConcurrentLinkedQueue<PrintWriter> printWriterConcurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(MAX_CLIENTS);

    public Server(int portNumber) {
        this.portNumber = portNumber;
    }

    public void runServer() throws IOException {
        initTCP();
    }

    public void initTCP() throws IOException {
        try {
            this.serverSocket = new ServerSocket(this.portNumber);
        } catch (IOException e) {
            System.out.println("Error while TCP initialization");
            e.printStackTrace();
        }

        System.out.println("TCP starting");


        while (true) {
            try{
                Socket clientSocket = this.serverSocket.accept();
                PrintWriter input = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader output = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                this.printWriterConcurrentLinkedQueue.add(input);
                String clientName = output.readLine();

                System.out.println("New client added: " + clientName);
                executorService.execute(new TCPListener(clientSocket, output, input, this.printWriterConcurrentLinkedQueue, clientName));

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void stopServer() {
        if (this.serverSocket != null) {
            try {
                this.serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Chat server started...");
        Server server = new Server(12345);
        try {
            server.runServer();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while server running");
        } finally {
            server.stopServer();
        }
    }
}
