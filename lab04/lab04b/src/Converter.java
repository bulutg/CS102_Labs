import javax.swing.*;
import java.awt.*;

/**
 * Number converter
 *
 * @author Bulut Gozubuyuk
 */
public class Converter extends JFrame {

    // Properties
    final static String hexadecimal = "0123456789ABCDEF";
    JTextField dec, hex, bin;

    // Main method
    public static void main(String[] args) {
        Converter converter = new Converter();
        converter.setDefaultCloseOperation(EXIT_ON_CLOSE);
        converter.setVisible(true);
    }

    // Constructor
    public Converter() {
        JPanel test = new JPanel(new GridLayout(3, 2));
        setSize(225, 150);

        // Create fields
        dec = new JTextField();
        dec.addActionListener(e -> {
            hex.setText(decTo(dec.getText(), 16));
            bin.setText(decTo(dec.getText(), 2));
        });
        hex = new JTextField();
        hex.addActionListener(e -> {
            dec.setText(Integer.toString(hex2decimal(hex.getText().toUpperCase())));
            bin.setText(Integer.toString(hex2binary(hex.getText().toUpperCase())));
        });
        bin = new JTextField();
        bin.addActionListener(e -> {
            dec.setText(Integer.toString(binary2dec(bin.getText())));
            hex.setText(decTo(Integer.toString(binary2dec(bin.getText())), 16));
        });

        // Add fields
        test.add(new JLabel("Decimal:"));
        test.add(dec);
        test.add(new JLabel("Hexadecimal:"));
        test.add(hex);
        test.add(new JLabel("Binary: "));
        test.add(bin);

        add(test);
    }

    /**
     * Hexadecimal to decimal converter
     *
     * @param number Hexadecimal number
     * @return Decimal number
     */
    public static int hex2decimal(String number) {
        int decimal = 0;

        for (int i = 0; i < number.length(); i++)
            decimal += Math.pow(16, (number.length() - i - 1))
                    * hexadecimal.indexOf(number.charAt(i));
        return decimal;
    }

    /**
     * Hexadecimal to binary converter
     *
     * @param number Hexadecimal Number
     * @return Binary string
     */
    public static int hex2binary(String number) {
        int decimal = 0;

        for (int i = 0; i < number.length(); i++)
            decimal += Integer.parseInt(decTo(Integer.toString((int) (Math.pow(16, (number.length() - i - 1))
                    * hexadecimal.indexOf(number.charAt(i)))), 2));
        return decimal;
    }

    /**
     * Decimal to hex or binary
     *
     * @param number Decimal number
     * @param base   base to be converted
     * @return converted number
     */
    public static String decTo(String number, int base) {
        int n = Integer.parseInt(number);
        String result = "";
        while (n > 0) {
            result += hexadecimal.charAt(n % base);
            n /= base;
        }
        return new StringBuffer(result).reverse().toString();
    }

    /**
     * Binary to decimal converter
     *
     * @param str Binary string
     * @return Converted decimal
     */
    public static int binary2dec(String str) {
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') j += (int) Math.pow(2, str.length() - 1 - i);
        }
        return j;
    }
}
