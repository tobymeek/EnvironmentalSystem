import javax.swing.*;
import java.awt.*;

public class TempPanel extends JPanel {
    private JLabel name;
    private JLabel temp;
    private JLabel ideal;
    private JLabel status;
    private Ward ward;

    public TempPanel(Ward ward){
        this.ward = ward;
        setLayout(new GridLayout(4,1){});

        name = new JLabel(getName());
        add(name);
        name.setText(getName());

        temp = new JLabel("Temp: "+String.valueOf(ward.getTemp()));
        add(temp);
        temp.setText("Temp: "+String.valueOf(ward.getTemp()));

        ideal = new JLabel("Target :"+String.valueOf(ward.getTargetTemp()));
        add(ideal);
        ideal.setText("Temp: "+String.valueOf(ward.getTemp()));

        if (ward.getHeatingStatus()){
            status = new JLabel("Heater is on");
            status.setText("Heater is on");
        } else {
            status = new JLabel("Heater is off");
            status.setText("Heater is off");
        }
        add(status);
    }
}
