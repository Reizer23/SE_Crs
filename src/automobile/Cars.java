package automobile;

public class Cars {
    //No modifier - accessible in the same package
    int speed;

    //Private is only shows in class
    private int privateSpeed;

    //Anywhere in java world "Public Keyword" can be used with importing the package and class
    public int publicSpeed;

    //Protected - should be available anywhere in any class within the same package, and can access without creating new object, just use it.
    //In same package and in sub classes
    protected int protectedSpeed;

    int speedLimit = 100;

    public Cars(){
        this(0);
    }

    public void setPrivateSpeed(int pSpeed){
        privateSpeed = pSpeed;
    }

    public Cars(int startSpeed){
        speed = startSpeed;
    }

    public void increaseSpeed(){
        if(speed < 100)
            speed++;
        System.out.println("Increasing Speed of Cars");
        //speed++;
        //System.out.println("Increasing speed of cars");
    }

    protected void decreaseSpeed(){
        speed--;
        System.out.println("Decreasing speed of cars");
    }

}
