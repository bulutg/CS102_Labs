import javax.swing.*;

import cs101.sosgame.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Bulut Gozubuyuk
 * SOSGUIPanel class
 */
public class SOSGUIPanel extends JPanel {
    // parameters
    private SOS sos;
    private SOSCanvas canvas;
    private String player1;
    private String player2;
    JLabel p1;
    JLabel p2;
    private JRadioButton sbutton;
    private JRadioButton obutton;
    private char currentLetter;

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public SOSGUIPanel(SOS sos, String player1, String player2) {
        this.sos = sos;
        this.player1 = player1;
        this.player2 = player2;
        sbutton = new JRadioButton("S");
        obutton = new JRadioButton("O");

        p1 = new JLabel(player1);
        p2 = new JLabel(player2);

        sbutton.addActionListener(e -> currentLetter = 's');

        obutton.addActionListener(e -> currentLetter = 'o');

        setLayout(new GridLayout(2, 1));
        canvas = new SOSCanvas(sos);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // call super class
                super.mouseClicked(e);

                // get x and y
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + "," + y);


                // play game
                sos.play(currentLetter, canvas.getRow(y), canvas.getColumn(x));
                System.out.println(canvas.getRow(y) + ", " + canvas.getColumn(x));

                // update player text
                p1.setText(player1 + ": " + sos.getPlayerScore1());
                p2.setText(player2 + ": " + sos.getPlayerScore2());

                // print board
                sos.printBoard();

                // repaint
                canvas.repaint();

                // set bold for turns
                if (sos.getTurn() == 1) {
                    p1.setFont(new Font("Monospaced", Font.BOLD, 12));
                    p2.setFont(new JLabel().getFont());
                } else if (sos.getTurn() == 2) {
                    p2.setFont(new Font("Monospaced", Font.BOLD, 12));
                    p1.setFont(new JLabel().getFont());
                }

                // show popup if game over
                if (sos.isGameOver()) {
                    if (sos.getPlayerScore1() > sos.getPlayerScore2())
                        JOptionPane.showMessageDialog((JPanel) e.getSource(), player1 + " wins");
                    else if (sos.getPlayerScore1() < sos.getPlayerScore2())
                        JOptionPane.showMessageDialog((JPanel) e.getSource(), player2 + " wins");
                    else JOptionPane.showMessageDialog((JPanel) e.getSource(), "Its draw");
                }
            }
        });

        JPanel bottomBar = new JPanel(new GridLayout(1, 4));

        // radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(sbutton);
        group.add(obutton);

        // add to buttonbar
        bottomBar.add(p1);
        bottomBar.add(sbutton);
        bottomBar.add(obutton);
        bottomBar.add(p2);

        add(canvas);

        add(bottomBar);

    }
}
