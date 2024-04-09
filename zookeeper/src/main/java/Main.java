import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private final ZooWatcher watcher;
    private final ZooKeeper zooKeeper;
    private final Scanner scanner;
    public static final String defaultAppExecPath = "D:\\Program Files\\GIMP 2\\bin\\gimp.exe";
    public static final String zNode = "/z";


    public Main(String nodePath, String execPath, String hostPath) throws IOException, KeeperException, InterruptedException {
        this.zooKeeper = new ZooKeeper(hostPath, 2000, null);
        this.watcher = new ZooWatcher(zNode, execPath, this.zooKeeper);
        this.zooKeeper.exists(nodePath, this.watcher);
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        String host = "127.0.0.1:2181";
        String appExecPath = defaultAppExecPath;

        if (args.length == 2) {
            host = args[0];
            appExecPath = args[1];
        } else if (args.length != 0) {
            System.out.println("Wrong args number - args format should be: [host] [app_exec_path]");
            System.exit(0);
        }
        try {
            Main mainApp = new Main(zNode, appExecPath, host);
            System.out.println("Starting app");
            mainApp.handleCommands();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            System.out.println("Possible connection error.");
            System.exit(1);
        }
    }

    public void handleCommands() {
        while (this.watcher.isAlive()) {
            String command = this.scanner.nextLine();
            try {
                switch (command) {
                    case "p" -> this.watcher.printTree();
                    case "q" -> this.closeAll();
                    case "h" -> printCommands();
                    default -> {
                        System.out.println("Unknown command: " + command);
                        printCommands();
                    }
                }
            } catch (InterruptedException | KeeperException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printCommands() {
        System.out.println("""
                Commands:
                p - print /z tree
                q - exit
                h - print commands
                """);
    }

    public void closeAll() throws InterruptedException {
        if (this.zooKeeper != null)
            this.zooKeeper.close();
        if (this.watcher != null) {
            this.watcher.setAlive(false);
            this.watcher.closeApp();
        }
    }
}