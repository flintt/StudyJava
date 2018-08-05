package study.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//Approach 9: Use Aggregate Operations That Accept Lambda Expressions as Parameters
public class Approach9 {
    public static void main(String[] args){
        int age = 10;
        List<Person> lp1 = new ArrayList<Person>();

        processElements(
                lp1,
                p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        ); // 在method修改后，使用method以及里面的逻辑几乎没有变化

        lp1
            .stream()  // 对lp1对象进行stream操作，下面的filter, map, forEach都定义在Stream类中。把原先的表达式每行放在括号中。
            .filter( p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
            .map(p -> p.getEmailAddress())
            .forEach(email -> System.out.println(email));
//        下面这4种都是一样的
//        1：使用了自己实现的Comparator接口
//        2：把1的表示lambda表达式化
//        3：用了Person类里的比较method
//        4：lambda表达式调用method的时候可以method reference化
        Person[] rosterAsArray = lp1.toArray(new Person[lp1.size()]);
// 1
        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        Arrays.sort(rosterAsArray, new PersonAgeComparator());
//2
        Arrays.sort(rosterAsArray,
                (Person a, Person b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
        );
//3
        Arrays.sort(rosterAsArray,
                (a, b) -> Person.compareByAge(a, b)
        );
//4
        Arrays.sort(rosterAsArray, Person::compareByAge);

    }


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
    } // 彻底generic化，没有限制类型j
}
