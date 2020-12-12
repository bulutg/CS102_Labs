/**
 * Rectangle Class
 * @author Bulut Gozubuyuk
 * @version 31.10.2019
 */
public class Rectangle extends Shape implements Selectable {
    // Variables
    int width;
    int height;
    int x;
    int y;
    boolean selected;

    // Constructor
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        selected = false;
        x = 0;
        y = 0;
    }

    /**
     * A method that returns area
     * @return area
     */
    @Override
    public double getArea() {
        return width * height;
    }

    /**
     * A method to show properties of shape
     * @return properties
     */
    @Override
    public String toString() {
        return "\nShape: " + this.getClass().getSimpleName() + "\nHeight: " + height + "\nWidth: " + width + "\nSelected: " + selected;
    }

    /**
     * A method to set location
     * @param x is x location
     * @param y is y location
     */
    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter method for x location
     * @return x
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Getter method for y location
     * @return y
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * A method to set selected state of shape
     * @param b is for selected or not
     */
    @Override
    public void setSelected(boolean b) {
        this.selected = b;
    }

    /**
     * A method that returns if a shape is selected or not
     * @return selected
     */
    @Override
    public boolean getSelected() {
        return selected;
    }

    /**
     * A method to calculate whether the coordinates given includes the shape
     * @param x x location
     * @param y y location
     * @return object if exists
     */
    @Override
    public Shape contains(int x, int y) {
        if ( Math.abs(x - this.x) <= ((double) (width) / 2) && Math.abs(y - this.y) <= ((double) (height) / 2) ) return this;
        return null;
    }

}
