package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] num={10, 77, 10, 54, -11, 10};
        int a=0;
        for (int i=0; i< num.length; i++){
            if((num[i]/10)==1){

                a=a+num[i];
                System.out.println(a);
            }
        }
        if (a==30){
            System.out.println("Total is 30");
        }
        else {
            System.out.println("Total is not 30");
        }
    }
}
