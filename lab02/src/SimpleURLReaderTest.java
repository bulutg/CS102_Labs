import cs1.*;

/**
 * A program that reads the contents of url and print its contents and the number of lines it contains.
 *
 * @author Bulut Gozubuyuk
 * @version 24.10.2019
 */
public class SimpleURLReaderTest {
    public static void main(String[] args) {
        SimpleURLReader urlRead = new SimpleURLReader("http://www.cs.bilkent.edu.tr/~adayanik/cs102/docs/housman.txt");

        // Page contents
        System.out.println(urlRead.getPageContents());

        // Line count
        System.out.println("Line count: " + urlRead.getLineCount());
    }
}
