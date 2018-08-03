package study.lambda;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//Approach 1: Create Methods That Search for Members That Match One Characteristic
public class Approach1 {
    public static void main(String[] args){
        int age = 10;
//        List<Person> lp1 = new List<Person>() ;  // 如何初始化List<Person>? todo
        List<Person> lp1 = new ArrayList<Person>();
        Approach1 a1 = new Approach1();
        a1.printPersonsOlderThan(lp1, age);

    }
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }
}
