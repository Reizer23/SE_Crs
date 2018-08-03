package automobile;

import java_Basic.InterfaceDemo;

public class InterfaceDemo1 {

    public static void main(String[] args){
        CarsInterface myInterface = new InterfaceDemo();
        myInterface.engineStart("6 Cyl", true);
        ((InterfaceDemo) myInterface).headsUpNavigation();
    }
}
