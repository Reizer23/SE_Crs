package java_Basic;

public class StringMethods {

    public static void main(String[] args) {
        String str = "This is the test string";

        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "Welcome";
        String str4 = "";
        String str5 = "            Spaces all around     ";
        String str6 = "Hellllllllolll";

        System.out.println("Length of the string is: " + str.length());
        System.out.println("Character at index 2 is: " + str.charAt(2));
        System.out.println(str.concat(" This is the appended string"));
        System.out.println("Contains check 1: " + str.contains("is"));
        System.out.println("Contains check 2: " + str.contains("si"));
        System.out.println("Starts with check 1: " + str.startsWith("This"));
        System.out.println("Starts with check 2: " + str.startsWith("is"));
        System.out.println("Ends with check 2: " + str.endsWith("string"));
        System.out.println("Ends with check 2: " + str.endsWith("is"));
        System.out.println("Check contents are equal: " + str1.equals(str2));
        System.out.println("Check contents are equal: " + str1.equals(str3));
        System.out.println("Index of 's' is: " + str.indexOf('s')); //Takes the first coincidence
        System.out.println("Check if string is empty 1: " + str.isEmpty());
        System.out.println("Check if string is empty 2: " + str4.isEmpty());
        System.out.println("Trim the leading and trailing spaces: " + str5.trim());
        System.out.println("Replace Example: " + str6.replace('l', 's'));// changes all the letters founded on the String

        System.out.println("Substring Example 1: " + str.substring(5));
        System.out.println("Substring Example 2: " + str.substring(5, 10));

        char[] charArray = str.toCharArray();
        for (int i = 0; i<charArray.length; i++) {
            System.out.println("Index " + i + " is: " + charArray[i]);
        }

        System.out.println("Lower case: " + str.toLowerCase());
        System.out.println("Upper case: " + str.toUpperCase());
    }

    //Overload
  /*  public class OverloadExample {
        OverloadExample obj = new OverloadExample();
        obj.println('example');
        obj.print('example2', 10 );
    }*/

    public void print(String str){
        System.out.println(str);
    }
    //Method name same but parameters are different
    public void print(String str, int num)
    {
        System.out.println(str + "" + num);
    }

    //Overriding
    class Parent
    {
        public void method1() {
            System.out.println("method1() of parent class");
        }
        public void method2(){
            System.out.println("method2() method of parent class");
        }
    }
    public class Child extends Parent
    {
        public void method1()
        {
            System.out.println("method1() of Child class");
        }
        public void method2()
        {
            System.out.println("method2() of Child class");
        }

        public  void main(String args[]){
            //Parent class reference to child class object
            Parent obj = new Child();
            obj.method1();
            obj.method2();
        }
    }

    //Immutable Class
    public final class ImmutableClass
    {
        private final String name;
        private final String contact;

        public ImmutableClass(String name, String contact)
        {
               this.name = name;
               this.contact = contact;
        }

        public String getName()
        {
            return name;
        }

        public String getMobile()
        {
            return contact;
        }
    }

}