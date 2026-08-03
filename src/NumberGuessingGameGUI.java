import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NumberGuessingGameGUI extends JFrame {

    JComboBox<String> difficultyBox;
    JTextField guessField;
    JButton submitButton;
    JButton playAgainButton;
    JButton exitButton;
    JButton hintButton;

    JLabel resultLabel;
    JLabel attemptsLabel;
    JLabel performanceLabel;
    JLabel scoreLabel;
    JLabel rangeLabel;
    JLabel bestScoreLabel;
    JLabel timerLabel;

    boolean hintUsed = false;
    int hintPenalty = 20;

    Random random = new Random();

    int secretNumber;
    int attempts;
    int maxAttempts = 10;
    int limit = 100;
    int score;
    int bestScore = 0;
    Timer timer;
    int timeLeft = 30;

    public NumberGuessingGameGUI() {
        setTitle(" Number Guessing Game");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9,2,10,10));
        panel.setBackground(new Color(255,220,230)); // Pink background
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        setContentPane(panel);

        JLabel titleLabel = new JLabel("Number Guessing Game", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(new Color(214,51,132));

        difficultyBox = new JComboBox<>();

        difficultyBox.addItem("Easy");
        difficultyBox.addItem("Medium");
        difficultyBox.addItem("Hard");

        guessField = new JTextField();
        difficultyBox.setFont(new Font("Segoe UI", Font.BOLD, 15));
        difficultyBox.setBackground(Color.WHITE);
        difficultyBox.setForeground(new Color(214, 51, 132));
        difficultyBox.setFocusable(false);

        guessField.setBackground(new Color(241,243,245));
        guessField.setBorder(BorderFactory.createLineBorder(
                new Color(214,51,132),2));

        guessField.setForeground(Color.BLACK);
        guessField.setFont(new Font("Segoe UI",Font.BOLD,15));
        guessField.setHorizontalAlignment(JTextField.CENTER);

        submitButton = new JButton("Submit");
        playAgainButton = new JButton("Play Again");
        hintButton = new JButton("Hint");
        exitButton = new JButton("Exit");

        submitButton.setBackground(new Color(34,197,94));
        submitButton.setForeground(Color.WHITE);

        hintButton.setBackground(new Color(250,204,21));
        hintButton.setForeground(Color.BLACK);

        playAgainButton.setBackground(new Color(59,130,246));
        playAgainButton.setForeground(Color.WHITE);

        exitButton.setBackground(new Color(239,68,68));
        exitButton.setForeground(Color.WHITE);

        submitButton.setFont(new Font("Segoe UI",Font.BOLD,15));
        playAgainButton.setFont(new Font("Segoe UI",Font.BOLD,15));
        hintButton.setFont(new Font("Segoe UI",Font.BOLD,15));
        exitButton.setFont(new Font("Segoe UI",Font.BOLD,15));

        resultLabel = new JLabel(" Result:");
        attemptsLabel = new JLabel(" Attempts: 0/10");
        performanceLabel = new JLabel(" Performance:");
        scoreLabel = new JLabel(" Score: 0");
        bestScoreLabel = new JLabel(" Best Score: 0");
        rangeLabel = new JLabel(" Guess a number");
        timerLabel = new JLabel("⏳ Time Left: 30 sec");

        Font labelFont = new Font("Segoe UI", Font.BOLD, 15);

        resultLabel.setForeground(new Color(214, 51, 132));   // Pink
        attemptsLabel.setForeground(new Color(59, 130, 246)); // Blue
        performanceLabel.setForeground(new Color(34, 197, 94)); // Green
        scoreLabel.setForeground(new Color(255, 140, 0)); // Orange
        bestScoreLabel.setForeground(new Color(138, 43, 226)); // Purple
        rangeLabel.setForeground(new Color(90, 90, 90)); // Gray

        resultLabel.setFont(labelFont);
        attemptsLabel.setFont(labelFont);
        performanceLabel.setFont(labelFont);
        scoreLabel.setFont(labelFont);
        bestScoreLabel.setFont(labelFont);
        rangeLabel.setFont(labelFont);

        submitButton.setFocusPainted(false);
        playAgainButton.setFocusPainted(false);
        hintButton.setFocusPainted(false);
        exitButton.setFocusPainted(false);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(255,220,230));

        titlePanel.add(titleLabel);

        add(titlePanel);
        add(new JLabel(""));

        add(new JLabel("Difficulty"));
        add(difficultyBox);

        add(new JLabel("Guess"));
        add(guessField);

        add(rangeLabel);
        add(timerLabel);

        add(submitButton);
        add(hintButton);

        add(playAgainButton);
        add(exitButton);

        add(resultLabel);
        add(attemptsLabel);

        add(performanceLabel);
        add(scoreLabel);

        add(bestScoreLabel);
        add(new JLabel(""));

        startNewGame();

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        playAgainButton.addActionListener(e -> {
            startNewGame();
        });

        difficultyBox.addActionListener(e -> {
            startNewGame();
        });

        hintButton.addActionListener(e -> {

            if (!hintUsed) {

                hintUsed = true;

                if (attempts <= 3) {

                    if (secretNumber % 2 == 0) {
                        JOptionPane.showMessageDialog(this,
                                "Hint: The number is EVEN\n(-20 Score)");
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Hint: The number is ODD\n(-20 Score)");
                    }

                }
                else if (attempts <= 6) {

                    int low = (secretNumber / 10) * 10;
                    int high = low + 10;

                    JOptionPane.showMessageDialog(this,
                            "Hint: The number is between "
                                    + low + " and " + high +
                                    "\n(-20 Score)");

                }
                else {

                    if (secretNumber > limit / 2) {
                        JOptionPane.showMessageDialog(this,
                                "Hint: The number is greater than " + (limit / 2)
                                        + "\n(-20 Score)");
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Hint: The number is less than " + (limit / 2)
                                        + "\n(-20 Score)");
                    }

                }

                hintButton.setEnabled(false);

            } else {

                JOptionPane.showMessageDialog(this,
                        "Hint already used!");

            }

        });

        submitButton.addActionListener(e -> {

            int guess;

            try {
                guess = Integer.parseInt(guessField.getText());
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number!");
                guessField.setText("");
                return;
            }

            if (guess < 1 || guess > limit) {
                resultLabel.setText("Enter between 1 and " + limit);
                guessField.setText("");
                return;
            }

            attempts++;
            difficultyBox.setEnabled(false);
            attemptsLabel.setText("Attempts: " + attempts + "/" + maxAttempts);

            if (guess == secretNumber) {

                score = 100 - (attempts * 5);

                if (hintUsed) {
                    score = score - hintPenalty;
                }

                if (score < 0) {
                    score = 0;
                }
                scoreLabel.setText(" Score: " + score);
                if (score > bestScore) {
                    bestScore = score;
                }

                bestScoreLabel.setText(" Best Score: " + bestScore);
                resultLabel.setText("Congratulations! You Won!");

                if (attempts <= 3) {
                    performanceLabel.setText("Performance: Excellent!");
                } else if (attempts <= 7) {
                    performanceLabel.setText("Performance: Good Job!");
                } else {
                    performanceLabel.setText("Performance: Keep Practicing!");
                }

                submitButton.setEnabled(false);
                timer.stop();
                JOptionPane.showMessageDialog(
                        this,
                        " Congratulations!\nYou guessed the correct number!"
                );

            }
            else {

                int difference = Math.abs(secretNumber - guess);

                if (difference <= 5) {
                    resultLabel.setText(" Very Close!");
                }
                else if (difference <= 15) {
                    resultLabel.setText("Close!");
                }
                else {
                    resultLabel.setText("Far Away!");
                }

                if (guess > secretNumber) {
                    resultLabel.setText(resultLabel.getText() + " Too High!");
                } else {
                    resultLabel.setText(resultLabel.getText() + " Too Low!");
                }
            }

            if (attempts >= maxAttempts && guess != secretNumber) {

                resultLabel.setText("Game Over! Number was " + secretNumber);
                performanceLabel.setText("Performance: Better Luck Next Time!");
                submitButton.setEnabled(false);

                JOptionPane.showMessageDialog(
                        this,
                        " Game Over!\nThe correct number was: " + secretNumber
                );
            }

            guessField.setText("");
        });

        guessField.addActionListener(e -> {
            submitButton.doClick();
        });
        setVisible(true);
    }

    private void startNewGame() {
        attempts = 0;
        score = 0;
        hintUsed = false;
        hintButton.setEnabled(true);

        String difficulty = (String)difficultyBox.getSelectedItem();
        if(difficulty.equals("Easy")) {
            limit = 50;
        }
        else if(difficulty.equals("Medium")) {
            limit = 100;
        }

        else {
            limit = 500;
        }
        secretNumber = random.nextInt(limit)+1;
        rangeLabel.setText("Guess a number between 1 and " + limit);
        guessField.setText("");

        resultLabel.setText(" Result:");
        attemptsLabel.setText(" Attempts: 0/" + maxAttempts);
        performanceLabel.setText(" Performance:");
        scoreLabel.setText(" Score: 0");
        bestScoreLabel.setText(" Best Score: " + bestScore);

        submitButton.setEnabled(true);
        difficultyBox.setEnabled(true);
        guessField.requestFocus();
        timeLeft = 30;
        timerLabel.setText(" Time Left: " + timeLeft + " sec");

        if (timer != null) {
            timer.stop();
        }

        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText(" Time Left: " + timeLeft + " sec");

            if (timeLeft <= 0) {
                timer.stop();
                submitButton.setEnabled(false);

                JOptionPane.showMessageDialog(
                        this,
                        " Time's Up!\nThe correct number was: " + secretNumber
                );
            }
        });

        timer.start();
    }

    public static void main(String[] args) {

        new NumberGuessingGameGUI();
    }
}