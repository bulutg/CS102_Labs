/**
 * Fibonacci class
 * @author Bulut Gozubuyuk
 */
public class fibonacci {
    /**
     * A method to display first 40 fibonacci numbers
     */
    public static void main(String[] args) {

        IntBag intbag = new IntBag();
        System.out.println(intbag.add(0));
        System.out.println(intbag.add(1));

        for (int i = 0; i < 38; i++) {
            intbag.add(intbag.bag[i] + intbag.bag[i + 1]);
            System.out.println(intbag.bag[i + 2]);
        }
        
        
    }
}
