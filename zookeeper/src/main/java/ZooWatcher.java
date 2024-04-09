import lombok.Data;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Data
public class ZooWatcher implements Watcher {
    private final ZooKeeper zooKeeper;
    public final String watchedPath;
    private final String appExecPath;
    private Process process;
    private final ChildWatcher childrenWatcher;
    private boolean isAlive;

    public ZooWatcher(final String watchedPath, final String appExecPath, final ZooKeeper zooKeeper) throws InterruptedException, KeeperException {
        this.watchedPath = watchedPath;
        this.appExecPath = appExecPath;
        this.zooKeeper = zooKeeper;
        this.childrenWatcher = new ChildWatcher(this, zooKeeper);
        this.isAlive = true;
        checkIfNodeExists();
    }

    public void checkIfNodeExists() {
        try {
            if (this.zooKeeper.exists(this.watchedPath, false) != null)
                this.handleNodeCreation();
        } catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
    }

    public void handleNodeCreation() throws KeeperException, InterruptedException {
        if (!this.isAlive) return;
        System.out.println("ZNode " + watchedPath + " created - graphical app launching...");
        this.childrenWatcher.addWatcherToChildren(this.watchedPath);
        launchApp();
        System.out.println("Graphical app launched.");
    }

    public void handleNodeDeletion() {
        if (!this.isAlive) return;
        System.out.println("ZNode " + watchedPath + " deleted - graphical app closing...");
        closeApp();
        System.out.println("Graphical app closed.");
    }

    public void printChildrenTree(String path) throws KeeperException, InterruptedException {
        try{
            List<String> children = zooKeeper.getChildren(path, false);
            for (String child : children) {
                String childNode = path + "/" + child;
                System.out.println(childNode);
                if (zooKeeper.exists(childNode, false) != null) {
                    printChildrenTree(childNode);
                }
            }
        } catch (KeeperException | InterruptedException e) {
            System.out.println("Children tree empty.");
        }
    }

    public void printTree() throws InterruptedException, KeeperException {
        if(this.zooKeeper.exists(this.watchedPath, false) != null) {
            System.out.println(this.watchedPath);
            printChildrenTree(this.watchedPath);
        }
        else{
            System.out.println("Node " + this.watchedPath +" doesn't exist");
        }
    }
    public int countNodesChildren(String path) throws KeeperException, InterruptedException {
        int sum = 0;
        for (String child : this.zooKeeper.getChildren(path, false)) {
            String childNodePath = path + "/" + child;
            sum += countNodesChildren(childNodePath) + 1;
        }
        return sum;
    }


    public void launchApp() {
        if (this.process != null)
            return;
        try {
            this.process = Runtime.getRuntime().exec(this.appExecPath);
        } catch (IOException e) {
            System.out.println("Failed to launch app.");
        }
    }

    public void closeApp() {
        if (this.process == null)
            return;
        this.process.destroy();

        try {
            this.process.waitFor(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Closing app retrying.");
        }

        if (this.process.isAlive())
            this.process.destroyForcibly();
        this.process = null;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        try {
            switch (watchedEvent.getType()) {
                case NodeCreated:
                    try {
                        handleNodeCreation();
                    } catch (InterruptedException | KeeperException e) {
                        e.printStackTrace();
                    }
                    break;
                case NodeDeleted:
                    handleNodeDeletion();
                    break;
            }
            zooKeeper.exists(this.watchedPath, this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException ignored) {
        }
    }
}