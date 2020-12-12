public class Circle extends Shape implements Selectable {

    // Variables
    int radius;
    int x;
    int y;
    boolean selected;

    // Constructor
    public Circle(int radius) {
        this.radius = radius;
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
        return Math.PI * radius * radius;
    }

    /**
     * A method to show properties of the shape
     * @return properties
     */
    @Override
    public String toString() {
        return "\nShape:" + this.getClass().getSimpleName() + "\nLocation X: " + x + " Y: " + y + "\nSelected: " + selected;
    }

    /**
     * A method to set location
     * @param x x location
     * @param y y location
     */
    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * A method to get x location
     * @return x
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * A method to get y location
     * @return y
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * A method to set selected state of a shape
     * @param b boolean for selected or not
     */
    @Override
    public void setSelected(boolean b) {
        this.selected = b;
    }

    /**
     * A method to get selected state of a shape
     * @return selected state
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
        if (Math.sqrt(Math.pow(Math.abs(this.x - x), 2) + Math.pow(Math.abs(this.y - y), 2)) < radius) {
            return this;
        }
        return null;
    }
}
