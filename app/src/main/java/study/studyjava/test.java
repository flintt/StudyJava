package study.studyjava;
import study.studyjava.Inheritance.*;

import static study.studyjava.localclasses.validatePhoneNumber;

class test {
    private nested.inner inner2;

    public static void main(String[] args){
        MountainBike mountain01;
        MountainBike mountain02;
//        mountain01 = new MountainBike(1,23,0,5);
        mountain01 = new MountainBike(1,3,4,15); // 需要MountainBike和Bicycle类都为MountainBike才行？
        mountain02 = new MountainBike(2,4,14,13); // 需要MountainBike和Bicycle类都为MountainBike才行？

        mountain01.setGear(1);
        System.out.println(mountain01.getGear());
        System.out.println(mountain02.getGear());
//测试何时被清理
        String[] students = new String[10];
        String studentName = "Peter Smith";
        students[1] = studentName;
        studentName = null;
        students[1] = null;
//测试nested class
        nested nest1 = new nested();
        nested.staticInner inner1 = new nested.staticInner();   // 可以生成static inner class的实例。 static nested class有啥用？  todo
//        nested.inner inner2 = new nested.inner();   // 但是不能生成inner class的？
        nested.inner inner2 = new nested().new inner();   // 这样又和那个outer class关联？
        nested.inner inner3 = nest1.new inner(); // inner class的实例化需要和outer的class的实例关联？有什么作用？ todo

        System.out.println(nest1.outerInt); // 打印出来的是10
//        inner2.dumb(); // inner class 为什么不能访问outer class 的method？
//        nested.inner2.dumb(); // inner class 为什么不能访问outer class 的method？
//        nested.inner.dumb(); // inner class 为什么不能访问outer class 的method？
        nest1.dumb(); // 需要这样访问。但是这样和inner class有啥关系？

//        测试local class
        validatePhoneNumber("123-456-7890", "456-7890");
    }
}
