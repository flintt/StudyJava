package study.studyjava;

public class numberclasses {
    public static void main(String[] args){
//        There are three reasons that you might use a Number object rather than a primitive:
//        As an argument of a method that expects an object (often used when manipulating collections of numbers).
//        To use constants defined by the class, such as MIN_VALUE and MAX_VALUE, that provide the upper and lower bounds of the data type.
//        To use class methods for converting values to and from other primitive types, for converting to and from strings, and for converting between number systems (decimal, octal, hexadecimal, binary).
        int int01 = 20;
        System.out.println(int01);
        Integer int02 = 30;
        Integer int03 = int01;  // 这里发生了auto boxing
//        System.out.println(int01.intValue()); // 这里并没有自动box或unbox？
        System.out.println(int02.intValue());
        System.out.println(int02.compareTo(int01));

    }
}
