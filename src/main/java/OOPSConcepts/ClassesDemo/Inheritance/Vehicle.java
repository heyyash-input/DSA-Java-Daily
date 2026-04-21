package OOPSConcepts.ClassesDemo.Inheritance;

public class Vehicle {
    public String brand ;
    public int speed ;

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void dispplayInfo(){
        System.out.println("Brand:- " + brand + ", Speed:- " + speed + " km/hr" );
    }
}
