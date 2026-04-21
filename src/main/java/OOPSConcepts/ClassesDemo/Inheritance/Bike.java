package OOPSConcepts.ClassesDemo.Inheritance;

public class Bike extends Vehicle{
    boolean hasCarrier ;

    public Bike(String brand, int speed , boolean hasCarrier) {
        super(brand , speed);
        this.hasCarrier=hasCarrier;
    }
}
