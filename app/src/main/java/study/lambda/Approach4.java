package study.lambda;

import java.util.ArrayList;
import java.util.List;

//Approach 4: Specify Search Criteria Code in an Anonymous Class
public class Approach4 {
    public static void main(String[] args){
        int age = 10;
//        List<Person> lp1 = new List<Person>() ;
        List<Person> lp1 = new ArrayList<Person>();
        Approach4 a1 = new Approach4();
//        CheckPerson cp1 = new CheckPerson() {
//            @Override
//            public boolean test(Person p) {
//                return p.gender == Person.Sex.MALE &&
//                    p.getAge() >= 18 &&
//                    p.getAge() <= 25;
//            }
//        }; // 如果不在其他.java文件实现class的话，就这样写
//        Approach3.printPersons(lp1, cp1);
//        printPersons(lp1,new CheckPersonEligibleForSelectiveService()); // 为何不能用有报错？在App3里面没问题【没注意这个文件里面的CheckPerson接口，注释后就没问题了】
        printPersons(lp1, new CheckPerson() {
            @Override
            public boolean test(Person p) {
//                return false;
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        }); // 如果不另外建一个java文件实现CheckPersonEligibleForSelectiveService class，用匿名class直接实现逻辑
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
//    }
//    class CheckPersonEligibleForSelectiveService implements CheckPerson {
//        public boolean test(Person p) {
//            return p.gender == Person.Sex.MALE &&
//                    p.getAge() >= 18 &&
//                    p.getAge() <= 25;
//        }
//    }
}
