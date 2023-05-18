package com.Laliev.javacore;
import java.util.concurrent.CountDownLatch;

public class Foo {
    private CountDownLatch latch1;
    private CountDownLatch latch2;

    public Foo() {
        latch1 = new CountDownLatch(1);
        latch2 = new CountDownLatch(1);
    }

    public void first(Runnable r) {
        System.out.print("first ");
        latch1.countDown();
    }

    public void second(Runnable r) throws InterruptedException {
        latch1.await();
        System.out.print("second ");
        latch2.countDown();
    }

    public void third(Runnable r) throws InterruptedException {
        latch2.await();
        System.out.print("third");
    }
}



