import javax.swing.*;
import java.awt.*;

public class HumidPanel extends JPanel {
    private JLabel inside;
    private JLabel outside;
    private JLabel difference;
    private JLabel humidStatus;
    private Wing wing;

    public HumidPanel(Wing wing){
        this.wing = wing;
        setLayout(new GridLayout(1,4){});

        update();
    }
    public void update(){
        removeAll();
        inside = new JLabel("Inside Humidity: "+ wing.getInsideHumidity());
        add(inside);

        outside = new JLabel("Outside Humidity: "+ wing.getOutsideHumidity());
        add(outside);

        difference = new JLabel("Difference"+ (wing.getInsideHumidity()- wing.getOutsideHumidity()));
        add(difference);

        if (wing.getHumidStatus()){
            humidStatus = new JLabel("Dehumidifier is on");
        } else {
            humidStatus = new JLabel("Dehumidifier is off");
        }
        add(humidStatus);
    }
}
