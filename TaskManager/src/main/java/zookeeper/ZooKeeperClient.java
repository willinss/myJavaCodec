package zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by williamguan on 2018/7/17.
 */
public class ZooKeeperClient {

    public enum ZKWatcherSingleton implements Watcher{
        ZOOKEEPERWATCHER {
            public void process(WatchedEvent event) {

            }
        };
        public static Watcher getInstance() {
            return ZKWatcherSingleton.ZOOKEEPERWATCHER;
        }
    }

    private String connectString;
    private int sessionTimeoutMs;
    private int connectionTimeoutMs;
    private int maxInFlightRequests;
    private ZooKeeper zkClient;
    ReadWriteLock rwlock = new ReentrantReadWriteLock();
    ZooKeeperClient(String connectString, int sessionTimeoutMs, int connectionTimeoutMs, int maxInFlightRequests) {
        this.connectString = connectString;
        this.connectionTimeoutMs = connectionTimeoutMs;
        this.sessionTimeoutMs = sessionTimeoutMs;
        this.maxInFlightRequests = maxInFlightRequests;
    }

}
