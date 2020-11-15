package org.jiuyu.bingfa;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private AtomicInteger nextId = new AtomicInteger(1);

    UserThreadFactory(String whatFeaturOfGroup){
        namePrefix = "From UserThreadFactory's" + whatFeaturOfGroup + "-worker-";

    }
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
        System.out.println(thread.getName());
        return thread;
    }

    public static void main(String[] args) {
        new UserThreadFactory("555").newThread(new Runnable() {
            public void run() {
                System.out.println("This is main function");
            }
        }).start();
    }
}
