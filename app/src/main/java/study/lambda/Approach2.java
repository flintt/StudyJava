package study.lambda;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//Approach 2: Create More Generalized Search Methods
public class Approach2 {
    public static void main(String[] args){
        int age = 10;
//        List<Person> lp1 = new List<Person>() ;  // 如何初始化List<Person>? todo
        List<Person> lp1 = new ArrayList<Person>();
        Approach2 a1 = new Approach2();
        a1.printPersonsWithinAgeRange(lp1, 10,20);

    }
    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }
}
