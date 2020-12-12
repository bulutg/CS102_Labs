import java.util.Scanner;

/**
 * Main class for Shapes
 * @author Bulut Gozubuyuk
 * @version 31.10.2019
 */
public class Main {

    public static void main(String[] args) {
        //Scanner
        Scanner scan = new Scanner(System.in);

        final String LIST = "1. Add circle or rectangle to array\n" +
                "2. Show total area of shapes\n" +
                "3. Show shapes info\n" +
                "4. Find then select the first shape that contains x, y\n" +
                "5. Remove selected shapes\n" +
                "6. Quit";

        // Variables
        ShapeContainer container;
        int choice;
        int var1;
        int var2;
        int x;
        int y;

        container = new ShapeContainer();

        // Menu
        do {
            System.out.println(LIST);
            while (!scan.hasNextInt()) {
                System.out.println("Please select");
                System.out.println(LIST);
                scan.next();
            }
            choice = scan.nextInt();

            // Add if 1
            if (choice == 1) {
                do {
                    System.out.println("Enter (1 - circle, 2 - rectangle, 3 - main menu) to add");
                    while (!scan.hasNextInt()) {
                        System.out.println("Enter (1 - circle, 2 - rectangle, 3 - main menu) to add");
                        scan.next();
                    }
                    choice = scan.nextInt();

                    // Circle
                    if (choice == 1) {
                        System.out.print("Enter radius");
                        while (!scan.hasNextInt()) scan.next();

                        // radius is var1
                        var1 = scan.nextInt();
                        Circle c = new Circle(var1);

                        System.out.print("Enter x:");
                        x = scan.nextInt();

                        System.out.print("Enter y:");
                        y = scan.nextInt();

                        c.setLocation(x, y);
                        container.add(c);
                        System.out.println("Added");
                    }
                    // Rectangle
                    else if (choice == 2) {
                        System.out.print("Enter width: ");
                        var1 = scan.nextInt();

                        System.out.print("Enter height: ");
                        var2 = scan.nextInt();

                        // Square
                        if (var2 == var1) {
                            Square s = new Square(var2);
                            System.out.print("Enter x:");
                            x = scan.nextInt();

                            System.out.print("Enter y:");
                            y = scan.nextInt();

                            s.setLocation(x, y);
                            container.add(s);
                            System.out.println("Added");

                        }
                        else {
                            Rectangle r = new Rectangle(var1, var2);
                            System.out.print("Enter x: ");
                            x = scan.nextInt();

                            System.out.print("Enter y: ");
                            y = scan.nextInt();

                            r.setLocation(x, y);
                            container.add(r);
                            System.out.println("Added");
                        }
                    }
                } while (choice != 3);

            }
            // Total area
            else if (choice == 2) System.out.println("Total area: " + container.getArea() + "\n");
            // Show all
            else if (choice == 3) System.out.println(container.toString());
            // Find and toggle
            else if (choice == 4) {
                System.out.print("Enter x: ");
                x = scan.nextInt();

                System.out.print("Enter y: ");
                y = scan.nextInt();

                container.find(x, y);
            }
            // Remove
            else if (choice == 5) container.remove();
            // Quit
            else if (choice == 6) System.out.println("Quitting");
        } while (choice != 6);
    }
}
