import cs1.*;

/**
 * A program that reads the contents of url and print its contents and the number of lines it contains using extended class.
 *
 * @author Bulut Gozubuyuk
 * @version 24.10.2019
 */
public class MySimpleURLReaderTest {
    public static void main(String[] args) {
        SimpleURLReader urlRead;

        urlRead = new MySimpleURLReader("http://www.cs.bilkent.edu.tr/~adayanik/cs102/docs/housman.txt");

        System.out.println(urlRead.getPageContents());
        System.out.println("Line count: " + urlRead.getLineCount());
    }
}
