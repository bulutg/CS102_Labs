/**
 * Lab06d
 * @author Bulut Gozubuyuk
 */
public class lab06d {
    public static void main(String[] args) {
        generate(6, 0);
    }

    /**
     * Generates even numbers and tests them
     * @param digit number
     * @param count current value
     */
    public static void generate(int digit, int count) {
        // Generate 111 + 1
        if (count == 0) {
            for (int i = 0; i < digit; i++) count += Math.pow(10, i);
            count++;
        }
        if (isGreater(count)) System.out.println(count);
        // Continue until is increasing
        while (!isGreater(count + 2) && (count + 2 < Math.pow(10, digit) - 1)) count += 2;
        if (isGreater(count + 2 )) generate(digit, count + 2);
    }

    /**
     * Checks if a number have increasing digits to right
     * @param n
     * @return if it is true or not
     */
    public static boolean isGreater(int n) {
        if (n < 10) return true;
        if (n % 10 > (n / 10) % 10) return isGreater(n / 10);
        return false;
    }
}
