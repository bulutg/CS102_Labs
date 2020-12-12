import java.util.ArrayList;

public class ShapeContainer {
    ArrayList<Shape> shapes;

    // Constructor
    public ShapeContainer() {
        this.shapes = new ArrayList<>();
    }

    /**
     * A method to add shape
     * @param shape shape
     */
    public void add(Shape shape) {
        shapes.add(shape);
    }

    /**
     * A method to get area
     * @return area
     */
    public double getArea() {
        double area = 0;

        for (Shape i : shapes) area += i.getArea();

        return area;
    }

    /**
     * A method to find and toggle a shape
     * @param x x location
     * @param y y location
     */
    public void find(int x, int y) {
        Circle c;
        Rectangle r;
        Square s;
        boolean isFound = false;
        int i = 0;

        // isFound for the first selected shape
        while (!isFound && i < shapes.size()) {

            // if Circle
            if (shapes.get(i) instanceof Circle) {
                c = (Circle) (shapes.get(i));
                if (c == c.contains(x, y)) {
                    isFound = true;
                    c.setSelected(!c.getSelected());
                }
            }
            // if rectangle
            else if (shapes.get(i) instanceof Rectangle) {
                r = (Rectangle) (shapes.get(i));
                if (r == r.contains(x, y)) {
                    isFound = true;
                    r.setSelected(!r.getSelected());
                }
            }
            // if square
            else if (shapes.get(i) instanceof Square) {
                s = (Square) (shapes.get(i));
                if (s == s.contains(x, y)) {
                    isFound = true;
                    s.setSelected(!s.getSelected());
                }
            }
            if (isFound) System.out.println(shapes.get(i).toString());
            i++;
        }

        if (!isFound) System.out.println("Not found");
    }

    /**
     * A method to remove all selected shapes
     */
    public void remove() {
        // Variables
        Circle c;
        Rectangle r;
        boolean removed;
        boolean isFound = false;
        ArrayList<Shape> selected;
        selected = new ArrayList<>();

        // A iterator to move selected shapes to another list
        for (Shape s : shapes) {
            if (s instanceof Circle) {
                c = (Circle) s;
                if (c.getSelected()) {
                    selected.add(s);
                    isFound = true;
                }
            }
            else if (s instanceof Rectangle) {
                r = (Rectangle) s;
                if (r.getSelected()) {
                    selected.add(s);
                    isFound = true;
                }
            }
        }

        // A method that removes matched shapes in original array
        if (isFound) {
            for (Shape s : selected) {
                int i = 0;
                removed = false;
                while (!removed && (i < shapes.size())) {
                    if (s == shapes.get(i)) {
                        shapes.remove(shapes.get(i));
                        removed = true;
                    }
                    i++;
                }
            }
            System.out.println("Removed");
        }
    }

    /**
     * To string method
     * @return string representation
     */
    public String toString() {
        String str = "";

        if (shapes.size() == 0) str = "No shape exist\n";

        for (Shape s : shapes) str += s.toString() + "\n";

        return str;
    }
}
