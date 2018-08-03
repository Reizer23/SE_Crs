package automobile;

public class AbstractDemoBMW extends AbstractCars{

    public void setPrivateSpeed(int speed){
        //la super clase es "AbstractCars"
        super.setPrivateSpeed(10);
    }

    /*public void engineStart(){
        super.engineStart();
        System.out.println("BMWs have keyless engine start");
    }*/

    @Override
    public void engineStart(String keyType, int numOfCyl){
        System.out.println("This is the BMW engine start");
    }

}
