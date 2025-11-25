import javax.swing.*;
import java.awt.*;

public class PollutionPanel extends JPanel {
    private Wing wing;
    private JLabel pollution;
    private JLabel purifier;

    public PollutionPanel(Wing wing){
        this.wing = wing;
        setLayout(new GridLayout(1,2){});

        update();
    }

    public void update(){
        removeAll();
        pollution = new JLabel("Pollution level: "+ wing.getPollution());
        add(pollution);

        if (wing.getPurifierStatus()){
            purifier = new JLabel("Purifier is on");
        } else {
            purifier = new JLabel("Purifier is off");
        }
        add(purifier);
    }
}
