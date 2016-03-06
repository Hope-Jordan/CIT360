package Threads;

/**
 * Created by JordanHope on 3/3/2016.
 */
public class ThreadSandbox extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread name " + Thread.currentThread().getName());
            System.out.println(i);

            try {
                Thread.currentThread().sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int threadCnt = 0; threadCnt < 2; threadCnt++) {
            ThreadSandbox aThread = new ThreadSandbox();
            aThread.start();
        }
    }
}