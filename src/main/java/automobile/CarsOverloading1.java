package automobile;

// Different number of parameters in argument list
// To be different methods, need to be different type of argument, it can be named different
// but it will throw error.

public class CarsOverloading1 {

    //1.- Number of parameters could be different
    //2.- Data type of parameters are different
    //3.- Sequence of data type is different
    //4.- Cannot overload just on return type
    //5.- Cannot overload just changing name of variable

    public static void main(String[] args){
        increaseSeatHeight(2);
        increaseSeatHeight(3,true);
    }

    public static void increaseSeatHeight(int heightToIncrease){
        System.out.println("Increased seat height by " + heightToIncrease + " inches.");
    }

    public static void increaseSeatHeight(int heightToIncrease, boolean rememberHeight){
        System.out.println("Increased seat height by " + heightToIncrease + " inches.");
        if(rememberHeight){
            System.out.println("Your selection is saved");
        }else {
            System.out.println("Your selection is not saved");
        }
    }

}
