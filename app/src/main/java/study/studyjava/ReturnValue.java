package study.studyjava;

public class ReturnValue {
    public static void main(String[] args){
        ReturnValue r01 = new ReturnValue();
        r01.returnValue();
    }
    class A{

    }
    class B extends A{

    }
    class C extends A{

    }
    public A returnValue(){
        A a01 = new A();
        B b01 = new B();
        C c01 = new C();
        if (1>2){
            return b01; // 可以返回不同subclass
        }
        else return c01;    // 可以返回不同subclass
    }
}
