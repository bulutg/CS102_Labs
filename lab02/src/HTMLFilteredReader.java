/**
 * A class that is able to show html file as readable text
 *
 * @author Bulut Gozubuyuk
 * @version 24.10.2019
 */
public class HTMLFilteredReader extends MySimpleURLReader {
    public HTMLFilteredReader(String url) {
        super(url);
    }

    /**
     * A method that parses html file and returns readable text.
     *
     * @return pure content
     */
    @Override
    public String getPageContents() {
        String pureContent = "";
        boolean nbsp = false;
        boolean isContent = false;


        for (int i = 0; i < super.getPageContents().length(); i++) {
            if (super.getPageContents().charAt(i) == '<') {
                isContent = false;
            }

            if (isContent) {
                if (super.getPageContents().indexOf("&nbsp;") == i) nbsp = true;

                // if not &nbsp; it should be a readable text
                if (!nbsp) pureContent += super.getPageContents().charAt(i);
                if (super.getPageContents().indexOf("&nbsp;") == i - 5) nbsp = false;
            }

            // There should be content after ">" if it is not &nbsp;
            if (super.getPageContents().charAt(i) == '>') {
                isContent = true;
            }
        }

        return pureContent;
    }

    /**
     * @return unfiltered page contents from superclass
     */
    public String getUnfilteredPageContents() {
        return super.getPageContents();
    }
}