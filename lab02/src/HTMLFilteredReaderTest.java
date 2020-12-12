
/**
 * A program that reads the html and print its readable contents.
 *
 * @author Bulut Gozubuyuk
 * @version 24.10.2019
 */

public class HTMLFilteredReaderTest {

    public static void main(String[] args) {
        System.out.println((new HTMLFilteredReader("http://www.cs.bilkent.edu.tr/~adayanik/cs102/docs/housman.htm")).getPageContents());
    }
}