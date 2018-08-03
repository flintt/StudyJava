package study.lambda;

import java.util.ArrayList;
import java.util.List;

//Approach 3: Specify Search Criteria Code in a Local Class
public class Approach3 {
    public static void main(String[] args){
        int age = 10;
//        List<Person> lp1 = new List<Person>() ;  // 如何初始化List<Person>? todo
        List<Person> lp1 = new ArrayList<Person>();
        Approach3 a1 = new Approach3();
//        CheckPerson cp1 = new CheckPerson() {
//            @Override
//            public boolean test(Person p) {
//                return p.gender == Person.Sex.MALE &&
//                    p.getAge() >= 18 &&
//                    p.getAge() <= 25;
//            }
//        }; // 如果不在其他.java文件实现class的话，就这样写
//        Approach3.printPersons(lp1, cp1);
        printPersons(lp1,new CheckPersonEligibleForSelectiveService());
    }
    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }
    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
//    interface CheckPerson {
//        boolean test(Person p);
//    }// 如果把interface放在这里面的话，在CheckPersonEFSS需要引用App3的interface，一样的代码App4就不能用
//    class CheckPersonEligibleForSelectiveService implements CheckPerson {
//        public boolean test(Person p) {
//            return p.gender == Person.Sex.MALE &&
//                    p.getAge() >= 18 &&
//                    p.getAge() <= 25;
//        }
//    }
}
