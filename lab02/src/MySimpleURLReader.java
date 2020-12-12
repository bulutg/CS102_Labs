import cs1.SimpleURLReader;

/**
 * @author Bulut Gozubuyuk
 * @version 24.10.2019
 */
public class MySimpleURLReader extends SimpleURLReader {

    // Initialization
    String url;

    // Constructor
    public MySimpleURLReader(String s) {
        super(s);
        this.url = s;
    }

    /**
     * A function that returns url
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * A function that returns file name
     *
     * @return file name
     */
    public String getName() {
        boolean isFound = false;
        int index = url.length();

        while (!isFound) {
            if (url.charAt(index - 1) == '/') isFound = true;
            index--;
        }

        return url.substring(index + 1);
    }

    /**
     * Overridden from superclass and fixes the bug
     *
     * @return fixed page content
     */
    @Override
    public String getPageContents() {
        return super.getPageContents().substring(4);
    }
}
