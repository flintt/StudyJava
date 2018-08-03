package study.studyjava;

import java.util.Scanner;

public class anonymous {

    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }

    public void sayHello() {

//        使用非anonymous class的话需要先有class，再实例化出一个对象
        class EnglishGreeting implements HelloWorld {
            String name = "world";
            public void greet() {
                greetSomeone("world");
                System.out.println("In the EnglishGreeting class:greet()  ");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
                System.out.println("In the EnglishGreeting class:greetSomeone(String someone)  ");
            }
            EnglishGreeting(){
                System.out.println("In the EnglishGreeting class:contructor??  ");
            }
        }
        HelloWorld englishGreeting = new EnglishGreeting();

//        直接实例化出一个实例了
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
                System.out.println("In the frenchGreeting anonymous class:greet()  ");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
                System.out.println("In the frenchGreeting anonymous class:greetSomeone(String someone)  ");
            }
            public void newMethod(){

            }// 除了接口定义过的外，新加的method用不上？  todo
            {
                System.out.println("Input a name:");
                name = new Scanner(System.in).next();
                System.out.println("In the frenchGreeting anonymous class:contructor??  ");
            }// 这里算是constructor吧？
        };

        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
                System.out.println("In the spanishGreeting anonymous class:greet() ");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
                System.out.println("In the spanishGreeting anonymous class:greetSomeone(String someone) ");
            }
            {
                System.out.println("In the spanishGreeting anonymous class:contructor?? ");
            }

        };
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }

    public void playSTH(PlayType play){
            int i;
    }

//    public interface PlayType{
//        public void playSTH();
//    }
    class PlayType {
        public void doingNothing() {

        }
    }

    public static void main(String... args) {
        anonymous myApp = new anonymous();
        myApp.sayHello();
//        myApp.playSTH(new PlayType() {
//            @Override
//            public void playSTH() {
//
//            }
//        }); // 不知道为啥不能override todo
    }
}
