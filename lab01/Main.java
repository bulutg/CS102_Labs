import java.util.Scanner;

/**
 * Main for the IntBag application
 * @author Bulut Gozubuyuk
 */
public class Main {
    /**
     * The main method
     */
    public static void main(String[] args) {

        // Scanner and IntBag initialization
        Scanner scan = new Scanner(System.in);
        IntBag bag = new IntBag();

        // Properties
        int input;
        int value;
        int index;
        boolean exists;

        exists = false;

        // Repeat until user quits
        do {
            System.out.println(" 1. Create a new empty collection (any previous values are lost!)");
            System.out.println(" 2. Read a set of positive values into the collection (use zero to indicate all the values have been entered.)");
            System.out.println(" 3. Print the collection of values.");
            System.out.println(" 4. Add a value to the collection of values at a specified location");
            System.out.println(" 5. Remove the value at a specified location from the collection of values");
            System.out.println(" 6. Remove all instances of a value within the collection");
            System.out.println(" 7. Quit the program.");
            
            System.out.print(" Choose one: ");
            input = scan.nextInt();

            if (input > 7) {
                System.out.println("You must choose from the list");
            }
            else {
                if (input == 1) {
                    bag = new IntBag();
                    exists = true;
                }

                if ( exists ) {
                    if (input == 2) {
                        System.out.println("Enter the values");
                        value = scan.nextInt();
                        while (value != 0) {
                            bag.add(value);
                            value = scan.nextInt();
                        }
                    } else if (input == 3) {
                        System.out.println(bag.toString());
                    } else if (input == 4) {
                        System.out.print("Enter the value");
                        value = scan.nextInt();
                        System.out.print("Enter the index");
                        index = scan.nextInt();
                        bag.add(value, index);
                    } else if (input == 5) {
                        System.out.print("Enter the index");
                        index = scan.nextInt();
                        bag.remove(index);
                    } else if (input == 6) {
                        System.out.print("Enter the value");
                        value = scan.nextInt();
                        bag.removeAll( value );
                    }
                }
                else if (input == 7) {
                    System.out.println("Quitting...");
                }
                else {
                    System.out.println("First, you must create a bag");
                }
            }

        } while (input != 7);
    }
}