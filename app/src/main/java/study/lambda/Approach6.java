package study.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//Approach 6: Use Standard Functional Interfaces with Lambda Expressions
public class Approach6 {
    public static void main(String[] args){
        int age = 10;
//        List<Person> lp1 = new List<Person>() ;
        List<Person> lp1 = new ArrayList<Person>();
        Approach6 a1 = new Approach6();

        printPersons(lp1,
                (Person p) -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );
    }

    public static void printPersons(
            List<Person> roster, Predicate<Person> tester) {    // 使用Predicate泛型替换了原来在外面定义的CheckPerson接口
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}
