import java.util.ArrayList;

/**
 * @author Bulut Gozubuyuk
 * @version 24.10.2019
 */
public class SuperHTMLFilteredReader extends HTMLFilteredReader {
    // Constructor
    public SuperHTMLFilteredReader(String url) {
        super(url);
    }

    /**
     * A method that returns overhead percentage
     *
     * @return overhead percentage
     */
    public int getOverhead() {
        return (getPageContents().length() * 100) / getUnfilteredPageContents().length();
    }

    /**
     * A method that finds all href links in the content and returns them.
     * @return All links as an array list.
     */
    public ArrayList<String> getLinks() {
        ArrayList<String> links = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();

        String content = super.getUnfilteredPageContents();

        int index = 0;
        int endIndex;

        // Find where all hrefs exist
        while (content.indexOf("href=", index) != -1) {
            indexes.add(content.indexOf("href=", index));
            index = content.indexOf("href=", index) + 1;
        }

        // Add all links to array using indexes hrefs start and end
        for (int i : indexes) {
            endIndex = content.indexOf("\"", i + 6);
            links.add(content.substring(i + 6, endIndex));
        }
        return links;
    }
}
