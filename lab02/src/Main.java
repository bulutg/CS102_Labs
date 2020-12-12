import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that maintains collection of SimpleURLReads
 *
 * @author Bulut Gozubuyuk
 * @version 24.10.2019
 */
public class Main {
    public static void main(String[] args) {

        // Scanner
        Scanner scan = new Scanner(System.in);

        // Initializations
        ArrayList<MySimpleURLReader> urls;
        String input;
        int choice;
        int poemChoice;

        urls = new ArrayList<>();

        // Menu implementation
        do {
            System.out.println("1. Add an url to collection\n2. List the collection\n3. Quit");

            choice = scan.nextInt();

            // Choice 1
            if (choice == 1) {
                System.out.print("Enter the url: ");
                input = scan.next();

                // if it is txt then simple read else put in html parser
                if (input.indexOf(".txt") != -1) urls.add(new MySimpleURLReader(input));
                else if (input.indexOf(".htm") != -1) urls.add(new HTMLFilteredReader(input));

            }

            // Choice 2
            else if (choice == 2) {
                do {
                    // Show all URLs
                    for (int i = 0; i < urls.size(); i++) {
                        System.out.println(i + ". " + urls.get(i).getName());
                    }

                    System.out.print("Enter index number to view it, or enter " + urls.size() + " to go main page)");

                    while (!scan.hasNextInt()) {
                        System.out.print("Enter index number to view it, or enter " + urls.size() + " to go main page)");
                        scan.next();
                    }

                    poemChoice = scan.nextInt();

                    // If input is valid then show contents
                    if (poemChoice < urls.size() && poemChoice >= 0) {
                        System.out.println(urls.get(poemChoice).getPageContents());
                    }

                } while (poemChoice != urls.size());

            }
            // Choice 3
            else if (choice == 3) {
                System.out.println("Quitting...");
            }
        } while (choice != 3);
    }
}