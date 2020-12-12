import cs101.sosgame.*;

import javax.swing.*;
import java.awt.*;

/**
 * @author Bulut Gozubuyuk
 * Main class for SOS game
 */
public class Main {
    public static void main(String[] args) {
        // two sos games
        SOS sos1 = new SOS(4);
        SOS sos2 = new SOS(3);

        // new frame
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1, 2));

        // panels
        SOSGUIPanel panel1 = new SOSGUIPanel(sos1, "bulut", "berk");
        SOSGUIPanel panel2 = new SOSGUIPanel(sos2, "ali", "onat");

        // adding panels to frame
        frame.add(panel1);
        frame.add(panel2);

        // to do
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
