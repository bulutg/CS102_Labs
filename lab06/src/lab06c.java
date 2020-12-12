import java.util.ArrayList;

/**
 * Lab06c
 * @author Bulut Gozubuyuk
 */
public class lab06c {
    public static void main(String[] args) {

        ArrayList<String> lexi = new ArrayList<>();

        // Add to arraylist
        lexi.add("abc");
        lexi.add("abcd");
        lexi.add("abcde");
        lexi.add("abcdef");

        System.out.println(" >> " + isLexi(lexi, 0));
    }

    /**
     * Checks if array list is lexicographic
     * @param arr word list
     * @return if it is true or not
     */
    public static boolean isLexi(ArrayList<String> arr, int count) {

        // if not lexicographic return false
        if ( strComp(arr.get(count), arr.get(count + 1)) == 1 ) return false;
        // if lexicographic then continue
        else if (count + 2 < arr.size()) return isLexi(arr, count + 1);
        return true;
    }

    /**
     * Compares two strings
     * @param str1 string 1
     * @param str2 string 2
     * @return 2 if string 2 is larger than 1, 1 if string 1 is larger than 2, 0 if equal
     */
    public static int strComp(String str1, String str2) {
        if (str1.equals("") && str2.equals("")) return 0;
        else if (str1.equals("")) return 2;
        else if (str2.equals("")) return 0;
        else if (str1.charAt(0) > str2.charAt(0)) return 1;
        else if (str1.charAt(0) < str2.charAt(0)) return 2;
        else return strComp(str1.substring(1), str2.substring(1));
    }
}
