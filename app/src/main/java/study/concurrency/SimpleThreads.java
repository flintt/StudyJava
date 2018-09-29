package study.concurrency;

public class SimpleThreads {

    // Display a message, preceded by
    // the name of the current thread
    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    } // 在线程中打印线程名称和消息

    private static class MessageLoop
            implements Runnable {
        public void run() {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };
            try {
                for (int i = 0;
                     i < importantInfo.length;
                     i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done! I will lag you 10ms...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    } // 构建一个可运行类，在线程里面执行的时候就运行run里面的代码

    public static void main(String args[])
            throws InterruptedException {

        // Delay, in milliseconds before
        // we interrupt MessageLoop
        // thread (default one hour).
        long patience = 1000 * 6;//0 * 60;

        // If command line argument
        // present, gives patience
        // in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) { // 线程还存在的话
            threadMessage("Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            t.join(1000); // 暂停当前运行一段时间，等t结束
            if (((System.currentTimeMillis() - startTime) > patience) // 判断是否超时，超时了发中断给那个线程。那个线程会catch并处理。
                    && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt(); // 给t线程发送中断
                // Shouldn't be long now
                // -- wait indefinitely
                long t1 = System.currentTimeMillis();
                t.join(); // 等待t线程结束，由于t线程catch后会sleep 10ms所以这里也就暂停了10ms
                threadMessage("Waited " + String.valueOf(System.currentTimeMillis() - t1) + " ms");
            }
        } //
        threadMessage("Finally!");
    }
}

 // 上面的join函数
// private final Object lock = new Object();
//
//    public final void join(long millis) throws InterruptedException {
//        synchronized(lock) {
//            long base = System.currentTimeMillis();
//            long now = 0;
//
//            if (millis < 0) {
//                throw new IllegalArgumentException("timeout value is negative");
//            }
//
//            if (millis == 0) {
//                while (isAlive()) {
//                    lock.wait(0);
//                }
//            } else {
//                while (isAlive()) {
//                    long delay = millis - now;
//                    if (delay <= 0) {
//                        break;
//                    }
//                    lock.wait(delay);
//                    now = System.currentTimeMillis() - base;
//                }
//            }
//        }
//    }