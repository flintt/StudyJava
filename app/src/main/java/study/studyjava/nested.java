package study.studyjava;
//class OuterClass {
//    ...
//    class NestedClass {
//        ...
//    }
//}
public class nested {
    static int staticInt1;
    int int1;
    int outerInt = 10;
    public static void main(String args) {
        nested.staticInner inner01 = new nested.staticInner();
//        nested.staticInner inner04 = new nested.inner();
    }
    public void dumb(){
        nested.inner inner02 = new nested.inner();
        nested.inner inner03 = this.new inner();
    }
    static class staticInner{
        public void innerTest(){
            staticInt1 = 1; // 可以直接使用outer的static variable
//            int1 = 2;   //不可以直接使用outer的non-static variable
            nested nest1 = new nested();    // 需要实例化一个对象
            nest1.int1 = 1;
        }
    }
    class inner{

    }
    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);     // 直接打印method的parameter值
            System.out.println("this.x = " + this.x);   // this指的Object是FirstLevel，所以输出1
            System.out.println("nested.this.x = " + nested.this.x); // 这是inner class的method使用outer class的field了，输出0
        }
    }

    /**
     *
     * @param args 。。。
     */
    public static void main(String... args) {
        nested st = new nested();
        nested.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
