import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import static java.lang.System.exit;

public class TCPListener implements Runnable {
    private final Socket clientSocket;
    private final ConcurrentLinkedQueue<PrintWriter> clientWriters;
    private final BufferedReader output;
    private final PrintWriter input;
    private final String clientName;

    public TCPListener(Socket clientSocket, BufferedReader output, PrintWriter input, ConcurrentLinkedQueue<PrintWriter> clientWriters, String clientName) {
        this.clientSocket = clientSocket;
        this.clientWriters = clientWriters;
        this.output = output;
        this.input = input;
        this.clientName = clientName;
    }

    @Override
    public void run() {
        String newMessage;
        while (true) {
            try {
                if(!this.output.ready()) continue;
                newMessage = this.output.readLine();
                if (newMessage == null || clientSocket.isClosed()) continue;
                System.out.println("TCP message: " + newMessage);

                for (PrintWriter userWriter : this.clientWriters) {
                    if (userWriter != this.input && !clientSocket.isClosed()) {
                        userWriter.println(this.clientName + ": " + newMessage);
                    }
                }
            } catch (IOException e) {
                try {
                    clientSocket.close();
                } catch (IOException ignored) {
                }
                System.out.println("Client lost connection.");
                break;
            }




        }

    }
}
