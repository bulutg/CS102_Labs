/**
 * Lab06b
 * @author Bulut Gozubuyuk
 */
public class lab06b {
    public static void main(String[] args) {
        System.out.println(hex(125676));
    }

    /**
     * Decimal to hex converter
     * @param n decimal number
     * @return hex value
     */
    public static String hex(int n){
        if (n > 0) return hex(n/16) + "0123456789ABCDEF".charAt(n % 16);
        return "";
    }
}
