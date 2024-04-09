import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

import static org.apache.zookeeper.Watcher.Event.EventType.NodeChildrenChanged;

public class ChildWatcher implements Watcher {
    private final String watchedPath;
    private final ZooWatcher watcher;
    private final ZooKeeper zooKeeper;
    private int childrenNumber;

    public ChildWatcher(ZooWatcher watcher, ZooKeeper zooKeeper) throws InterruptedException, KeeperException {
        this.watcher = watcher;
        this.zooKeeper = zooKeeper;
        this.watchedPath = watcher.watchedPath;

        try{
            this.childrenNumber = watcher.countNodesChildren(this.watcher.getWatchedPath());
        }
        catch(Exception e){
            this.childrenNumber = 0;
        }
    }

    public void addWatcherToChildren(String nodePath) throws KeeperException, InterruptedException {
        if (zooKeeper.exists(nodePath, null) != null) {
            List<String> children = zooKeeper.getChildren(nodePath, this);
            for (String child : children){
                addWatcherToChildren(nodePath + "/" + child);}
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        try {
            addWatcherToChildren(watchedPath);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        if (watchedEvent.getType().equals(NodeChildrenChanged)) {
            try {
                String text = childrenNumber < watcher.countNodesChildren(this.watchedPath) ? "increased" : "decreased";
                childrenNumber = watcher.countNodesChildren(this.watchedPath);
                System.out.println("Children number " + text +" to: " + childrenNumber);
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}