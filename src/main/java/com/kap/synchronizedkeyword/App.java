package com.kap.synchronizedkeyword;

/**
 * @author Konstantinos Antoniou
 */
public class App {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] main) {

        App app = new App();
        try {
            app.doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            public void run() {

                for(int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {

                for(int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count is: " + count);

    }

}
