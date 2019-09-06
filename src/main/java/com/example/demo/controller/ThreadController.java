package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/5/14 18:09
 */
@RestController
public class ThreadController {

    private static int count = 2;

    static ExecutorService threadPool = Executors.newFixedThreadPool(count);

    @GetMapping("/threadTest")
    String home() {
        return "Hello World!";
    }

    /**
     * 测试execute
     */
    private void startThreadExeDemo() {
        // 实例化一个model，model实现Callable接口
        Runnable r = new ThreadExeDemo();

        // 调用多线程的utils
        startExeThread(r, count);
    }

    public static void main(String[] args) {
        new ThreadController().startThreadExeDemo();
    }

    /**
     *
     */
    public static void startExeThread(Runnable model, int count) {

        // 循环创建线程进行处理数据，将线程的返回数据按顺序放入list中
        for (int x = 0; x < 10; x++) {
            System.out.println("开启线程" + x);
            threadPool.execute(model);
        }

        // 关闭线程池
        threadPool.shutdown();

        System.out.println("主线程结束了");
    }

    /**
     * 实现Runnable接口的model
     */
    class ThreadExeDemo implements Runnable {

        /**
         * 开启count个线程同时进行getNum()。
         */
        private void dealData() {
            System.out.println(Thread.currentThread().getName() + "------------开始等待------------");
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "------------处理数据------------");
        }

        /**
         * 线程开始的方法
         */
        @Override
        public void run() {
            dealData();
        }
    }
}
