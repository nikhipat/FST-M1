package activities;

public class Activity1 {
    public static void main(String[] args) {
        Car BMW=new Car();
        BMW.make=2023;
        BMW.color="Black";
        BMW.transmission="Auto";

        BMW.accelarate();
        BMW.brake();
        BMW.displayCharacteristics();
    }
}
