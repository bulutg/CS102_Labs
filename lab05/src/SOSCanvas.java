import cs101.sosgame.SOS;

import javax.swing.*;
import java.awt.*;

/**
 * @author Bulut Gozubuyuk
 * SOSCanvas class
 */
public class SOSCanvas extends JPanel {

    // properties
    SOS sos;
    int side;
    int xStart;
    int yStart;

    /**
     * Creates a new SOS canvas
     */
    public SOSCanvas(SOS sos) {
        this.sos = sos;
    }


    /**
     * Paints each of the SOS components in this container.
     */
    @Override
    public void paintComponent(Graphics g) {
        // call super
        super.paintComponent(g);

        // set background
        setBackground(Color.LIGHT_GRAY);

        // get properties
        int width = getWidth();
        int height = getHeight();
        int d = sos.getDimension();


        // calculate side length and offsets
        side = Math.min(width, height) - 1;
        xStart = (width - side - 1) / 2;
        yStart = (height - side - 1) / 2;

        // draw rectangle
        g.drawRect(xStart, yStart, side, side);

        // horizontal lines
        for (int i = 1; i < d; i++)
            g.drawLine(xStart, yStart + (i * (side / d)), xStart + side, yStart + (i * (side / d)));

        // vertical lines
        for (int i = 1; i < d; i++)
            g.drawLine(xStart + (i * (side / d)), yStart, xStart + (i * (side / d)), yStart + side);

        // draw S and O's
        for (int x = 1; x < d + 1; x++) {
            for (int y = 1; y < d + 1; y++) {
                if (sos.getCellContents(x - 1, y - 1) == 's') {
                    g.drawString("S", yStart + (y * (side / sos.getDimension())) - (side / sos.getDimension() / 2), xStart + (x * (side / sos.getDimension())) - (side / sos.getDimension()) / 2);
                } else if (sos.getCellContents(x - 1, y - 1) == 'o') {
                    g.drawString("O", yStart + (y * (side / sos.getDimension())) - (side / sos.getDimension() / 2), xStart + (x * (side / sos.getDimension())) - (side / sos.getDimension()) / 2);
                }
            }
        }


    }

    /**
     * getter method for mouseclick
     *
     * @param x coordinate for column
     * @return column
     */
    public int getColumn(int x) {

        return (x - xStart) / (side / sos.getDimension()) + 1;
    }

    /**
     * getter method for mouseclick
     *
     * @param y coordinate for row
     * @return row
     */
    public int getRow(int y) {
        return (y - yStart) / (side / sos.getDimension()) + 1;
    }
}
