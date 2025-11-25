import Feeds.*;

import javax.swing.*;
import java.util.ArrayList;

public class Wing {
    private String name;
    private ArrayList<Ward> wards = new ArrayList<Ward>();
    private ArrayList<Scanner> scanners = new ArrayList<Scanner>();
    private EnvironmentalSystem envSys = new EnvironmentalSystem();

    public Wing(String name){
        this.name = name;
        wards.add(new Ward("North",0,23, envSys));
        wards.add(new Ward("Cenral",1,22, envSys));
        wards.add(new Ward("South",2,20, envSys));
        scanners.add(new CT(envSys));
        scanners.add(new Ultrasound(envSys));
    }

    //

    public int getInsideHumidity(){
        return envSys.getHumidityFeed().getInsideHumidity();
    }

    public int getOutsideHumidity(){
        return envSys.getHumidityFeed().getOutsideHumidity();
    }

    public boolean getHumidStatus(){
        return envSys.isDehumudifierOn();
    }

    public void humidityControl(){
        if (getInsideHumidity() > getOutsideHumidity()*1.1 && getHumidStatus() == false){
            envSys.turnDehumudifierOn(true);
        } else if (getInsideHumidity() < getOutsideHumidity()*1.1 && getHumidStatus() == true) {
            envSys.turnDehumudifierOn(false);

        }
    }

    //

    public float getPollution(){
        return envSys.getPollutionFeed().getPollution();
    }

    public boolean getPurifierStatus(){
        return envSys.isAirPurifierOn();
    }
    public void polutionControl(){
        if (getPollution() > 5 && getPurifierStatus() == false){
            envSys.turnAirPurifierOn(true);
        } else if (getPollution() < 5 && getHumidStatus() == true) {
            envSys.turnAirPurifierOn(false);

        }
    }

    public void updateSystems(){
        humidityControl();
        polutionControl();
        for(Ward w:wards){
            w.heatingControl();
        }
    }

    public ArrayList<Ward> getWards(){
        return wards;
    }

    public void printStatus(){
        for(Ward w:wards){
            System.out.println(w.getName()+" Temp: "+w.getTemp()+" Target: "+w.getTargetTemp()+" Heater Status: "+w.getHeatingStatus());
        }
        for(Scanner s:scanners){
            System.out.println(s.getStatus());
        }
        System.out.println("Inside humidity: "+getInsideHumidity()+" Outside humidity: "+getOutsideHumidity()+" Dehumidifier Status: "+String.valueOf(getHumidStatus()));
        System.out.println("Pollution: "+getPollution()+" Air Purifier Status: "+String.valueOf(getPurifierStatus()));
    }

}
