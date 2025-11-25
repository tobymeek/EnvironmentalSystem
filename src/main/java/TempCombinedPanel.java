import javax.swing.*;
import java.awt.*;

public class TempCombinedPanel extends JPanel {
    private Wing wing;

    public TempCombinedPanel(Wing wing){
        this.wing = wing;
        setLayout(new GridLayout(1,3){});

        for (Ward w: wing.getWards()){
            add(new TempPanel(w));
        }
    }

    public void update(){
        removeAll();
        for (Ward w: wing.getWards()){
            add(new TempPanel(w));
        }
    }

}
