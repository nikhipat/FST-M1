package activities;

public class Bicycle implements BicycleParts,BicycleOperations {

    @Override
    public int applyBrake(int decrement) {
        currentSpeed=currentSpeed-decrement;
        return currentSpeed;
    }

    @Override
    public int speedUp(int increment) {
        currentSpeed=currentSpeed+increment;
        return currentSpeed;
    }
    public int gears;
    public int currentSpeed;
    Bicycle(){
        this.gears=gears;
        this.currentSpeed=currentSpeed;
    }
    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
    }
}