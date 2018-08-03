package oopconcepts;

public class ClassDemo {

    public static void main(String[] args) {
        Car bmw = new Car();
        bmw.setMake("BMW ");
        System.out.println("Make of BMW is: " + bmw.getMake());

        Car benz = new Car();
        benz.setMake("Benz");
        System.out.println("Make of Benz is: " + benz.getMake());

        benz.setModel("c300");
        System.out.println("Model of BMW is: " + benz.getModel());

        benz.setYear(2020);
        System.out.println("Year of BMW is: " + benz.getYear());
    }
}
