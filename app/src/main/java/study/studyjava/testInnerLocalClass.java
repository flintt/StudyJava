package study.studyjava;

public class testInnerLocalClass {
    static int staticInt1;
    static int staticInt2 = 2;
    int int1;

//    静态方法
    static void staticMethod(){
//        static class staticMethodStaticClass{ // local class不能是static的
        class staticMethodStaticClass{
//            测试inner class里面的声明变量类型
//            static int staticInt2;  // local class里面的变量不能是static的
            int staticInt3;
            final static int staticInt4 = 3; //  local class里面的变量不能是static的，但是可以是final static的
            staticMethodStaticClass(){

            }

//            private static void innerStatic(){
//                int innerNonStatic1 = 1;
//                static int innerNonStatic2 = 1;
//
////            测试inner class对外面的访问
//                staticInt1 = 1;
//                int1 = 1;
//                System.out.println(staticInt2);
//            }  // inner class里面的method不能是static的

            private void innerNonStatic(){
                int innerNonStatic1 = 1;
//                static int innerNonStatic2 = 1; // local class里面的method里面的变量不能是static的
//                final static int innerNonStatic2 = 1; // local class里面的method里面的变量不能是final static的
//            测试inner class对外面的访问
                staticInt1 = 1;
                staticInt3 = 2;
//                int1 = 1; // local class里面的method里面不能访问outer class的
                System.out.println(staticInt2);
                System.out.println(staticInt4);
            }
//            测试inner class对外面的访问
//            staticInt1 = 1;
//            int1 = 1;
//            System.out.println(staticInt2);
        }
    }

//    非静态方法
    void method(){

    }
}
