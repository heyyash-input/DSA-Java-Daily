package Constructor;

public class ConstructorDemo {
    public static void main(String[] args) {
        Car car1 = new Car("BMW" , "RED" , 120) ; // Object creation by using new word
        car1.Drive();
        Car car2 = new Car("THAR" , "PINK" , 120) ;
        car2.Drive();
    }
}
