/**
 * A program that tests the superHTMLFiltered reader
 * @author Bulut Gozubuyuk
 * @version 24.10.2019
 */
public class SuperHTMLFilteredReaderTest {
    public static void main(String[] args) {
        SuperHTMLFilteredReader reader;

        reader = new SuperHTMLFilteredReader("https://docs.oracle.com/javase/tutorial/index.html");

        System.out.println("Overhead %: " + reader.getOverhead());
        System.out.println(reader.getLinks());
    }
}
