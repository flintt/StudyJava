package study.concurrency;

public class Deadlock {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + "  has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this); // 为什么根本就没有进入执行这个语句？【因为bower对象被另外一个线程锁定了】
            System.out.format("after bowBack");
        } // 同步的方法在t1执行的时候，t2不能访问，但是为什么可以打印出两条bow的输出？【锁定的是instance，有两个instance所以可以打印两个输出】
        public synchronized void bowBack(Friend bower) {
            System.out.format("begin bowBack");
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        Thread t1 = new Thread(() -> alphonse.bow(gaston));
        t1.start(); // t1锁死的原因是？在等待t2释放什么lock？【执行bow后锁定了alphonse对象，在bow中要执行gaston.bowBack时需要获取gaston对象，但是这个对象在下面的t2里面bow就被锁定了。类似的t2也是一样的锁定了】
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } // 中间加上50ms的延时后，很大可能可以避免锁死
//        t1.join(); // 加上这句话可以解决锁死的问题，也就是等待前面一个线程结束再进行。这样t1和t2线程没有交织？ todo
        Thread t2 = new Thread(() -> gaston.bow(alphonse));
        t2.start(); // 这个线程执行bow的时候要等前面一个线程的bow执行完成？但是为什么可以输出两个bow的内容？这样不是两个bow都执行了？【因为锁定的是不同的instance】
    }
}