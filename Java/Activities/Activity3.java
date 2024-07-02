package activities;

public class Activity3 {
    public static void main(String[] args) {
        double age=1000000000;
        double earth=31557600;
        double mercury=0.2408467*earth;
        double Venus=0.61519726*earth;
        double Mars= 1.8808158*earth;
        double Jupiter = 11.862615*earth;
        double Saturn = 29.447498*earth;
        double Uranus = 84.016846*earth;
        double Neptune = 164.79132*earth;

        System.out.println("Age on earth is: "+(float)age/earth );
        System.out.println("Age on Mercury is: "+(float)age/mercury);
        System.out.println("Age on Venus is: "+(float)age/Venus);
        System.out.println("Age on Mars is: "+(float)age/Mars);
        System.out.println("Age on Jupiter is: "+(float)age/Jupiter);
        System.out.println("Age on Saturn is: "+(float)age/Saturn);
        System.out.println("Age on Uranus is: "+(float)age/Uranus);
        System.out.println("Age on Neptune is: "+(float)age/Neptune);

    }
}
