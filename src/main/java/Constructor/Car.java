package Constructor;

public class Car {
    String brand ;
    String color ;
    int speed;

    public Car(String brand , String color , int speed){
        System.out.println("Constructer is called ");
//        INIT:-
        this.brand = brand;
        this.color = color ;
        this.speed = speed;
    }
    public void Drive(){
        System.out.println(brand + " is driving at " + speed);
    }
}
