package com.Laliev.javacore;

public class main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Runnable r1 = () -> {};

        Thread t1 = new Thread(() -> {
            foo.first(r1);
        });
        Thread t2 = new Thread(() -> {
            try {
                foo.second(r1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                foo.third(r1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t3.start();
        t2.start();
        t1.start();
    }
}
