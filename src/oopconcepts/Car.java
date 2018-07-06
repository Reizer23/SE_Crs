package oopconcepts;

public class Car {
    //encapsulamiento utilizar privates, getters and setters
    //color
    private String color;
    //make
    private String make;
    //model
    private String model;
    //year
    private int year;

    public void increaseSpeed(){
        System.out.println("Increasing the speed");
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setMake(String make) {
        this.make = make; //"this" toma el valor de make declarado en la clase
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1900) {
            this.year = year;
        }else {
            System.out.println("This year is not valid");
        }
    }
}
