package OOPSConcepts.ClassesDemo;

public class CarObjectDemo {
    public static void main(String[] args) {
//        in class Car we created new obj name car1 then we are setting values for it
        Car car1 = new Car() ; // Object creation by using new word
        car1.speed = 100 ;
        car1.brand = "BMW";
        car1.color = "Blue";
//        Creating constructer:-

        car1.Drive();
    }
}
