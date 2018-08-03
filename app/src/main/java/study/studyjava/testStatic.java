package study.studyjava;

public class testStatic {
    static int int01;
    private int int02;
    public static void main(String[] args) {
        testStatic ts1 = new testStatic();
        testStatic ts2 = new testStatic();
        ts1.int01 = 1;
        System.out.println(ts2.int01);  // 由于int01是static的，所以ts2的也变化了
        ts2.int01 = 2;
        System.out.println(ts1.int01);  // 类似
        testStatic.int01 = 3;
        System.out.println(ts2.int01);
        System.out.println(ts1.int01);

        try {
            staticMethod(); // 直接使用了，没有通过实例调用
        }catch (StackOverflowError e){
            System.out.println("StackOverflowError happened !!");
        }
    }
    testStatic(){
        this(1,3);
        this.int01 = 1;
        int01 = 2;
        this.int02 = 1;
        int02 = 2;

    }
    testStatic(int a, int b){
        a = 1;
        b = 2;
    }
    public static void staticMethod(){
//        this.int01 = 2;     // 不能在static method里使用this
//        this.int02 = 2;
        int01 = 3;
//        staticMethod();
        staticMethod2();
    }
    public static void staticMethod2(){
//        this.int01 = 2;     // 不能在static method里使用this
//        this.int02 = 2;
        int01 = 3;
        staticMethod();
    }
    public void otherMethod(){
        this.int01 = 2;
        this.int02 = 2;
        int01 = 3;
        staticMethod();
    }
}
