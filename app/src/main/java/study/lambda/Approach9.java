package study.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//Approach 9: Use Aggregate Operations That Accept Lambda Expressions as Parameters
public class Approach9 {
    public static void main(String[] args){
        int age = 10;
        List<Person> roster = new ArrayList<Person>();
//        下面这4种都是一样的
//        1：使用了自己实现的Comparator接口
//        2：把1的表示lambda表达式化
//        3：用了Person类里的比较method
//        4：lambda表达式调用method的时候可以method reference化
        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
// 1
        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        Arrays.sort(rosterAsArray, new PersonAgeComparator());
//2
        Arrays.sort(rosterAsArray,
                Comparator.comparing(Person::getBirthday)
//                Comparator.comparing(Person::getBirthday) // 等效于上面

        );
//3
        Arrays.sort(rosterAsArray,
                (a, b) -> Person.compareByAge(a, b)
        );
//4
        Arrays.sort(rosterAsArray, Person::compareByAge);

        Set<Person> rosterSetLambda = transferElements(roster, () -> { return new HashSet<>(); });
        Set<Person> rosterSet = transferElements(roster, HashSet::new);
        Set<Person> rosterSet2 = transferElements(roster, HashSet<Person>::new);
    }

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> //
    DEST transferElements(
        SOURCE sourceCollection, // 一个由collection接口扩展的SOURCE类的parameter？？？
        Supplier<DEST> collectionFactory) { // 一个collection接口扩展的DEST类，并且实现了Supplier接口？？？

        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    } // 这个属于generic的内容吧？实在是看不懂这一段代码是干嘛了 todo

}
