package activities;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane=new Plane(10);
        plane.onboard("Nikhil");
        plane.onboard("Patil");

        System.out.println("Plane take off time is: "+plane.takeOff());

        System.out.println("Passengers are: "+plane.getPassengers());

        Thread.sleep(5000);

        plane.land();

        System.out.println("Plane landed at: "+plane.getLastTimeLanded());

    }
}
