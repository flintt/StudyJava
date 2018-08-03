package study.lambda;

public interface testInterface {
    int i = 1; // 可以定义和声明变量
    static int j = 1; // static是多余的
    public void add(int a, int b); // 对于interface里面的method, interface, class public都是多余的
    static int add(int a){
        return a;
    }; // 静态的方法需要有body
    public interface innerInterface{
        interface iinnerInterface{

        }

    } // 可以有内部interface，一环套一环
    public class classInInterface{
        class classInInnnterface{

        }
    }// 可以有内部class，也能一环套一环
}
