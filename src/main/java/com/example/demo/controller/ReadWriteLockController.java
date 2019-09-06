package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 *  此Controller为了理解读写锁的应用场景而实现的Demo，其中知识点可查看
 *  https://blog.csdn.net/training2007/article/details/78837096
 * */
@RestController
@Slf4j
public class ReadWriteLockController {

    ReadWriteLock lock = new ReentrantReadWriteLock();

    @GetMapping(value = "testReadLock")
    void testReadLock(@RequestParam("flag") boolean flag) throws InterruptedException {

        if (flag) {
            System.out.println(Thread.currentThread() + "开始了读锁");
            lock.readLock().lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + "读锁 = " + i);
                Thread.sleep(1000);
            }
            System.out.println(Thread.currentThread() + "释放了读锁");
            lock.readLock().unlock();
        } else {
            System.out.println(Thread.currentThread() + "start write lock");

            lock.writeLock().lock();

            System.out.println(Thread.currentThread() + "write lock");

            Thread.sleep(5000);

            lock.writeLock().unlock();
            System.out.println(Thread.currentThread() + "write unlock");

        }

    }
}
