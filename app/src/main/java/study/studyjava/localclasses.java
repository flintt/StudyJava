package study.studyjava;

public class localclasses {

    static String regularExpression = "[^0-9]";

    public static void validatePhoneNumber(
            String phoneNumber1, String phoneNumber2) {

        final int numberLength = 10;

        // Valid in JDK 8 and later: 并没有，还是报错。原因是没有修改module的project structure里面的使用的版本为1.8

//         int numberLength = 10;

        class PhoneNumber {

            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber){
                // numberLength = 7;
                String currentNumber = phoneNumber.replaceAll(
                        regularExpression, "");
                if (currentNumber.length() == numberLength)
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;

            } // 去除数字外的字符，如果得到的长度等于电话号码长度则返回，否则返回空

            public String getNumber() {
                return formattedPhoneNumber;
            }

            // Valid in JDK 8 and later:

//            public void printOriginalNumbers() {
//                System.out.println("Original numbers are " + phoneNumber1 +
//                    " and " + phoneNumber2);
//            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        // Valid in JDK 8 and later:

//        myNumber1.printOriginalNumbers();

        if (myNumber1.getNumber() == null)
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNumber1.getNumber());
        if (myNumber2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + myNumber2.getNumber());
//        if (1<2){
//            class take{
//
//            }
//            System.out.println();
//        }
//            else
//                System.out.println();
//

    }



    public static void main(String... args) {
        validatePhoneNumber("123-456-7890", "456-7890"); // 为了不新建Object直接使用，所以这个method被定义为static的，
    }
}
