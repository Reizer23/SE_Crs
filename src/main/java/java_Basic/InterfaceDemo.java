package java_Basic;

import automobile.BMWCarsInterface;
import automobile.CarsInterface;

public class InterfaceDemo implements CarsInterface, BMWCarsInterface {

    @Override
    public void engineStart(String engineType, boolean isKeyLess) {
        System.out.println("This is the implementation");
    }


    @Override
    public void headsUpNavigation() {
        System.out.println("This is the headsUp Navigation");
    }
}
