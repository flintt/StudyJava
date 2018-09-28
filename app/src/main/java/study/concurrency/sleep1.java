package study.concurrency;

public class sleep1 {
    public static void main(String args[])
            throws InterruptedException { // 这里抛出的异常是这个sleep在运行时候被中断的时候抛出的
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            //Pause for 4 seconds
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }


}
