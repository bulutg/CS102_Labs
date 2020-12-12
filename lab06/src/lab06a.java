/**
 * Lab06a
 * @author Bulut Gozubuyuk
 */
public class lab06a {
    public static void main(String[] args) {
        String str = "";
        System.out.println(str + " >> " + removeRv1(str));
    }

    /**
     * Function to remove r's in a string
     * @param s string
     * @return string without any r's
     */
    public static String removeRv1(String s) {
        if (s.length() == 0) return s;
        if (s.length() != 1) {
            if (s.charAt(0) == 'r') return removeRv1(s.substring(1));
            return s.charAt(0) + removeRv1(s.substring(1));
        }
        if (s.charAt(0) == 'r') return "";
        return s;
    }


}
