package study.lambda;

import java.time.LocalDate;

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
}
