package study.lambda;

import java.time.LocalDate;
import java.util.Calendar;

public class Person {
    public enum Sex {
    MALE, FEMALE
}

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        // ...
        return 1;
    }

    public void printPerson() {
        // ...
    }
    public Sex getGender(){
        return gender;
    }
    public String getEmailAddress(){
        return emailAddress;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
}
