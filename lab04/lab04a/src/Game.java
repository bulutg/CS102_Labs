import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Bulut Gozubuyuk
 * Pot Luck
 */
public class Game extends JFrame {

    // Properties
    private int attempts, correct, bomb1, bomb2;
    private ArrayList<Integer> numbers;
    private JLabel statusBar;
    private JPanel panel, buttonPanel;
    private JButton button;

    // Main class
    public static void main(String[] args) {
        Game game = new Game();

        game.setDefaultCloseOperation(EXIT_ON_CLOSE);
        game.setVisible(true);
    }

    /**
     * Constructor
     */
    public Game() {
        // Set properties
        attempts = 0;
        setSize(250, 300);
        numbers = new ArrayList<>();
        correct = generate();
        bomb1 = generate();
        bomb2 = generate();

        // Main panel
        panel = new JPanel(new BorderLayout());

        // Button Panel
        buttonPanel = new JPanel(new GridLayout(5, 5));

        //Editing the text of status bar
        statusBar = new JLabel("Attempt 0", JLabel.CENTER);

        // Creating buttons
        for (int i = 1; i < 26; i++) {
            button = new JButton(Integer.toString(i));
            // Generate correct button
            if (i == correct) {
                button.addActionListener(e -> {
                    // If game over, disable all buttons
                    for (Component b : buttonPanel.getComponents()) b.setEnabled(false);
                    statusBar.setForeground(new Color(39, 145, 0));
                    statusBar.setText("You found in " + ++attempts + " attempts" );
                    statusBar.setFont(new Font("font", Font.BOLD, 15));
                });
                button.setForeground(Color.green);
            }
            // Generate bombs
            else if ( i == bomb1 || i == bomb2 ) {
                button.addActionListener(e -> {
                    // If game over, disable all buttons
                    for (Component b : buttonPanel.getComponents()) b.setEnabled(false);
                    buttonPanel.setBackground(new Color(164, 0, 2));
                    statusBar.setText("You lost");
                });
                button.setForeground(Color.red);
            }
            else {
                button.addActionListener(e -> {
                    // Increment attempts
                    statusBar.setText("Attempt: " + ++attempts);
                    ((JButton) e.getSource()).setEnabled(false);
                });
            }
            buttonPanel.add(button);
        }

        panel.add(statusBar, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);
    }

    /**
     * Random number generator
     * @return random number
     */
    public int generate(){
        int number = (((int) (Math.random() * 25)) + 1);
        if(!numbers.contains(number)){
            numbers.add(number);
            return number;
        }
        else {
            return generate();
        }
    }


}
