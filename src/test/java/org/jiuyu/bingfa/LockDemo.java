package org.jiuyu.bingfa;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class LockDemo {
    class UserLock implements Lock{

        @Override
        public void lock() {
            System.out.println("上锁成功！");
        }

        @Override
        public void lockInterruptibly() throws InterruptedException {

        }

        @Override
        public boolean tryLock() {
            return false;
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public void unlock() {
            System.out.println("解锁成功！");
        }

        @Override
        public Condition newCondition() {
            return null;
        }
    }

    @Test
    public void test(){
        UserLock userLock = new UserLock();
        System.out.println("测试锁方法");
        userLock.lock();
        try {
            System.out.println("Do Somethings...");
            System.out.println("Do Otherthings...");
        }finally {
            userLock.unlock();
        }

    }

}
