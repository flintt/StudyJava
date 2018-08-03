package study.studyjava2;

import study.studyjava.*;

public class test extends testAccess{
//    public class tester extends testAccess{
//        public tester(){
//            super();
//        }
    public test(){
        super();
    }
//    测试使用其他package的method
    public static void main(String[] args){
        test t03 = new test();  // 新建一个subclass实例
        t03.publicMember();
        t03.protectedMember();  // 在package外的subclass可以访问class的protected的成员

        testAccess t02 = new testAccess();  // 新建一个class实例
        t02.publicMember();
//        t02.protectedMember();    // 在package外的class不可以访问class的protected的成员？ todo
    }
}
