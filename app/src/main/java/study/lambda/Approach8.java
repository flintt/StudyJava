package study.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//Approach 8: Use Generics More Extensively
public class Approach8 {
    public static void main(String[] args){
        int age = 10;
//        List<Person> lp1 = new List<Person>() ;
        List<Person> lp1 = new ArrayList<Person>();
        Approach8 a1 = new Approach8();

//        processPersonsWithFunction(
//                lp1,
//                p1 -> p1.getGender() == Person.Sex.MALE
//                        && p1.getAge() >= 18
//                        && p1.getAge() <= 25,
//                p -> p.getEmailAddress(), // 由于省掉了return看起来没有返回
//                email -> System.out.println(email)  // 没有明白这个email变量是哪里来的（和前面的对比后发现，这里其实只是匿名函数的parameter而已用啥名字都行）
//        );
        processElements(
                lp1,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }


//    public static void processPersonsWithFunction(
//            List<Person> roster,
//            Predicate<Person> tester,   // Predicate,Function, Consumer都是functional interface
//            Function<Person, String> mapper, //
//            Consumer<String> block) { //
//        for (Person p : roster) {
//            if (tester.test(p)) {   // 函数里面实现的逻辑都很抽象，用Predicate类型测试p
//                String data = mapper.apply(p);  // 使用Function类型，输入p输出data
//                block.accept(data); // 使用Consumer类型，接收输入data
//            }
//        }
//    } // 虽然用了generic，但是限制了type为<Person> <String>。。。
    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function <X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    } // 彻底generic化，没有限制类型
}
