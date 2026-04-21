package OOPSConcepts.ClassesDemo.Encapsulation;

 class Car {
    private String brand ;
    private String color ;
    private int speed;

    public Car(String brand , String color , int speed){
//        System.out.println("Constructer is called ");
//        INIT:-
        this.brand = brand;
        this.color = color ;
//        this.speed = speed;
        setSpeed(speed); // to change the constructor value then add
                        // setters to specific value
    }

    public void Drive(){
        System.out.println(brand + " is driving at " + speed);
    }

    public int getSpeed(){
        return speed ;
    }
    public void setSpeed(int speed){
        if (speed < 0)
            speed = 0 ;
        this.speed = speed ;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        Car car1 = new Car("BMW" , "Yellow" , 120);
        car1.getSpeed();
        car1.Drive();
        Car car2 = new Car("KIA" , "BLUE" , -120);
        car2.getSpeed() ;
        car2.Drive();
    }
}
