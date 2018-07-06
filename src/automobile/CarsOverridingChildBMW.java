package automobile;

// Dynamic Method

/**
 * Rules
 * 1. Arguments List: Arguments list in the overriding method should be same as the parent class overridden method
 * 2. Access Modifier: Access modifier of the overriding method cannot be more restrictive than the overriden method
 * 3. Private, Static and Final methods cannot be overridden as they are local to the class
 */

public class CarsOverridingChildBMW extends CarsOverridingParent {

    public static void main(String[] args){
        //CarsOverridingChildBMW c1 = new CarsOverridingChildBMW();
        CarsOverridingParent c1 = new CarsOverridingChildBMW();
        c1.increaseSpeed();
        c1.engineStart(2);
    }

    @Override
    public void engineStart(int cyl){
        //super.engineStart(2);
        System.out.println("I am from the child class");
    }

    public static void staticExample(){
        System.out.println("I am the static method from the child class");
    }

}
