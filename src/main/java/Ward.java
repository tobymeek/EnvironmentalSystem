import Feeds.*;

public class Ward {
    private final String name;
    private final int id;
    private int targetTemp;
    private EnvironmentalSystem envSys;

    public Ward(String name, int id, int targetTemp, EnvironmentalSystem envSys){
        this.name = name;
        this.id = id;
        this.targetTemp = targetTemp;
        this.envSys = envSys;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public int getTargetTemp(){
        return targetTemp;
    }

    public void setTargetTemp(int temp){
        this.targetTemp = temp;
    }

    public float getTemp(){
        return envSys.getTempFeed().getTemperature(id);
    }

    public boolean getHeatingStatus(){
        return envSys.isHeatingOn(id);
    }

    public void heatingControl(){
        if (getTemp() < targetTemp-0.5 && !getHeatingStatus()){
            envSys.turnHeatingOn(id, true);
        }
        else if (getTemp() > targetTemp+0.5 && getHeatingStatus()){
            envSys.turnHeatingOn(id, false);
        }
    }
}
