package automobile;

//las clases abstractas no pueden puedes instanciar objetos pero puedes extender la clase
//las clases abstractas no pueden ser instanciadas y no se pueden crear objetos
public abstract class AbstractCars {

    private int privateSpeed;
    public int publicSpeed;
    protected int protectedSpeed;

    int speedLimit = 100;

    public AbstractCars(){
        this(0);
    }

    public AbstractCars(int startSpeed){
        this.privateSpeed = startSpeed;
    }

    public void setPrivateSpeed(int pSpeed){
        this.privateSpeed = pSpeed;
    }

    public abstract void engineStart(String keyType, int numOfCyl);

}
