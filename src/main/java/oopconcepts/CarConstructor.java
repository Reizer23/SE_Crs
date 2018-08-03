package oopconcepts;

public class CarConstructor {
    private String make;
    int speed;
    int gear;

    //default constructor
    public CarConstructor(){
        this(10,2);
        this.speed = 0;
        this.gear = 0;
        System.out.println("Executing constructor without arguments");
    }

    public CarConstructor(int speed, int gear){
        this.speed = speed;
        this.gear = gear;
        System.out.println("Executing constructor with arguments");
    }

    // methods can have any other name, but the constructor would have the same name as the class

    // "this" refers to the instance of the class (object)
    public void setMake(String make){
        this.make = make;
    }

    public String getMake(){
        return make;
    }

}
