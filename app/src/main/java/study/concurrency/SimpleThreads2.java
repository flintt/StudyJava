package study.concurrency;

public class SimpleThreads2 {

    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    } // 在线程中打印线程名称和消息

    private static class Adder
            implements Runnable {
        public void run() {
            Counter counter = new Counter();
            counter.increment();
            threadMessage(String.valueOf(counter.value()));
        }
    }

    private static class Miner
            implements Runnable {
        public void run() {
            Counter counter = new Counter();
            counter.decrement();
            threadMessage(String.valueOf(counter.value()));
        }
    }

    private static class Counter {
        private int c = 0;

        public void increment() {
            c++;
        }

        public void decrement() {
            c--;
        }

        public int value() {
            return c;
        }
    }

    public static void main(String args[]){
        Thread t1 = new Thread(new Adder());
        Thread t2 = new Thread(new Miner());
        t1.start();
        t2.start();
    }
}
