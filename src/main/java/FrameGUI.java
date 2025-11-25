import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameGUI extends JFrame {

    static GraphicsConfiguration gc;

    public FrameGUI(){
        // Setting up the frame
        super(gc);
        setTitle("Example Title!");
        setSize(600,600);
        setLocationRelativeTo(null); // Sets where the frame appears (null is center)
        setResizable(true); // Sets whether you can resize
        setLayout(new GridLayout(3,1)); // Exactly the same concept as panel
        addWindowListener(new WindowAdapter() {	// Closes the program if close window clicked
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}