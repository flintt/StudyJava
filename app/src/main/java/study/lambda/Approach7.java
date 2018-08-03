package study.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//Approach 6: Use Standard Functional Interfaces with Lambda Expressions
public class Approach7 {
    public static void main(String[] args){
        int age = 10;
//        List<Person> lp1 = new List<Person>() ;
        List<Person> lp1 = new ArrayList<Person>();
        Approach7 a1 = new Approach7();

        processPersonsWithFunction(
                lp1,
                p1 -> p1.getGender() == Person.Sex.MALE
                        && p1.getAge() >= 18
                        && p1.getAge() <= 25,
                p -> p.getEmailAddress(), // 由于省掉了return看起来没有返回
                email -> System.out.println(email)  // 没有明白这个email变量是哪里来的（和前面的对比后发现，这里其实只是匿名函数的parameter而已用啥名字都行）
        );
    }


    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,   // Predicate,Function, Consumer都是functional interface
            Function<Person, String> mapper, //
            Consumer<String> block) { //
        for (Person p : roster) {
            if (tester.test(p)) {   // 函数里面实现的逻辑都很抽象，用Predicate类型测试p
                String data = mapper.apply(p);  // 使用Function类型，输入p输出data
                block.accept(data); // 使用Consumer类型，接收输入data
            }
        }
    }
}
