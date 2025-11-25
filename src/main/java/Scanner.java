import Feeds.*;

public abstract class Scanner {
    private EnvironmentalSystem envSys;

    public Scanner(EnvironmentalSystem envSys){
        this.envSys = envSys;
    }

    public EnvironmentalSystem getEnvSys(){
        return envSys;
    }

    public abstract String getStatus();
}
