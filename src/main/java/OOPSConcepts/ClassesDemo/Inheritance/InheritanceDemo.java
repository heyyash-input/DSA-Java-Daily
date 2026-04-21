package OOPSConcepts.ClassesDemo.Inheritance;

public class InheritanceDemo {
    public static void main(String[] args) {
        Car car1 = new Car("BMW - M5 competion" , 120);
        car1.dispplayInfo();
        Bike bike1 = new Bike("NINJA",200 , true);
        bike1.dispplayInfo();
    }
}
