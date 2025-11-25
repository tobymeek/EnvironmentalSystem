import Feeds.EnvironmentalSystem;

public class CT extends Scanner{

    public CT(EnvironmentalSystem envSys){
        super(envSys);
    }

    public String getStatus(){
        return getEnvSys().getCTScannerStatus();
    }
}
