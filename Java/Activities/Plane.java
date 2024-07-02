package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SequencedCollection;

public class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    Plane(int maxPassengers){
        this.maxPassengers=maxPassengers;
        this.passengers=new ArrayList<>();
    }
    public void onboard(String passanger){
        this.passengers.add(passanger);
    }
    public Date takeOff(){
        lastTimeTookOf=new Date();
        return lastTimeTookOf;
    }
    public void land(){
        lastTimeLanded=new Date();
        this.passengers.clear();
    }
    public Date getLastTimeLanded(){
        return lastTimeLanded;
    }
    public List<String> getPassengers(){
        return passengers;
    }

}
