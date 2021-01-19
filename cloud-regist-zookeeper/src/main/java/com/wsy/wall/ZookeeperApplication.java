package com.wsy.wall;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ZookeeperApplication {
    private static String zookeeperHost = "140.143.153.238:2181";
    private static int sessionTimeout = 2000;
    public static void main(String[] args) throws IOException {
        SpringApplication.run(ZookeeperApplication.class,args);
       new ZooKeeper(zookeeperHost, sessionTimeout, watchedEvent -> {

       });
    }
}
