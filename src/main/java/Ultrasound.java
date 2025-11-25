import Feeds.EnvironmentalSystem;

public class Ultrasound extends Scanner{

    public Ultrasound(EnvironmentalSystem envSys){
        super(envSys);
    }

    public String getStatus(){
        return getEnvSys().getUltrasoundScannerStatus();
    }
}
