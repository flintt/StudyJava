package study.studyjava;

import java.util.ArrayList;
import java.util.List;

//Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. For example, converting an int to an Integer, a double to a Double, and so on. If the conversion goes the other way, this is called unboxing.
//The Java compiler applies autoboxing when a primitive value is:
//
//        Passed as a parameter to a method that expects an object of the corresponding wrapper class.
//        Assigned to a variable of the corresponding wrapper class.
//The Java compiler applies unboxing when an object of a wrapper class is:
//
//        Passed as a parameter to a method that expects a value of the corresponding primitive type.
//        Assigned to a variable of the corresponding primitive type.
public class boxing {
    public static void main(String[] args){
        Character ch = 'a'; // 这里就是简单的自动boxing
        List<Integer> li = new ArrayList<>();
        for (int i = 1; i < 50; i += 2)
            li.add(i);

    }
    public class Unboxing {

        public void main(String[] args) {
            Integer i = new Integer(-8);

            // 1. Unboxing through method invocation
            int absVal = absoluteValue(i);
            System.out.println("absolute value of " + i + " = " + absVal);

            List<Double> ld = new ArrayList<>();
            ld.add(3.1416);    // Π is autoboxed through method invocation.

            // 2. Unboxing through assignment
            double pi = ld.get(0);
            System.out.println("pi = " + pi);
        }

        public int absoluteValue(int i) {
            return (i < 0) ? -i : i;
        }
    }

}
