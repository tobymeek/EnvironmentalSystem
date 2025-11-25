import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args){
        Wing wing = new Wing("Children");

        FrameGUI frame = new FrameGUI();
        TempCombinedPanel tempCombinedPanel = new TempCombinedPanel(wing);
        HumidPanel humidPanel = new HumidPanel(wing);
        PollutionPanel pollutionPanel = new PollutionPanel(wing);

        frame.add(tempCombinedPanel);
        frame.add(humidPanel);
        frame.add(pollutionPanel);
        frame.setVisible(true);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wing.updateSystems();
                tempCombinedPanel.update();
                humidPanel.update();
                pollutionPanel.update();
                frame.revalidate();
                frame.repaint();
            }
        });
        timer.start();

        Timer longTimer = new Timer(30000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wing.updateSystems();
                wing.printStatus();
            }
        });
        longTimer.start();


    }
}
