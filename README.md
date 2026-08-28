# 🎯 Number Guessing Game – Java Swing

A simple and interactive **Number Guessing Game** developed using **Java Swing**. The player has to guess a randomly generated number within a limited number of attempts and time.

The game provides different difficulty levels, hints, scoring, performance feedback, and a countdown timer.

## ✨ Features

* 🎮 **Three Difficulty Levels**

  * Easy → Number between **1–50**
  * Medium → Number between **1–100**
  * Hard → Number between **1–500**

* 🔢 **Random Number Generation**

  * A secret number is randomly generated for every new game.

* ❤️ **Attempt Limit**

  * Maximum of **10 attempts** per game.

* ⏳ **30-Second Timer**

  * The player must guess the number before the timer reaches zero.

* 💡 **Hint System**

  * Provides useful hints based on the number of attempts.
  * Using a hint reduces the score by **20 points**.
  * A hint can only be used once per game.

* 🏆 **Scoring System**

  * Starting score is calculated based on the number of attempts.
  * Fewer attempts result in a higher score.
  * Using a hint applies a 20-point penalty.

* 🥇 **Best Score**

  * The highest score achieved during the application's runtime is displayed.

* 📊 **Performance Feedback**

  * 3 or fewer attempts → Excellent
  * 4–7 attempts → Good Job
  * More than 7 attempts → Keep Practicing

* 🔥 **Guess Feedback**

  * Very Close
  * Close
  * Far Away
  * Too High
  * Too Low

* 🔄 **Play Again**

  * Start a new game without restarting the application.

* ❌ **Exit Button**

  * Closes the application.

## 🛠️ Technologies Used

* **Java**
* **Java Swing**
* **AWT**
* **Random Number Generation**
* **Event Handling**
* **Swing Timer**

## 📁 Project Structure

```text
NumberGuessingGame/
│
├── NumberGuessingGameGUI.java
└── README.md
```

## 🚀 How to Run

### 1. Install Java

Make sure Java JDK is installed on your system.

Check the installation using:

```bash
java -version
```

### 2. Save the Code

Save the Java source file as:

```text
NumberGuessingGameGUI.java
```

The filename must match the public class name.

### 3. Compile

Open Command Prompt/Terminal in the project folder and run:

```bash
javac NumberGuessingGameGUI.java
```

### 4. Run

```bash
java NumberGuessingGameGUI
```

## 🎮 How to Play

1. Launch the application.
2. Select a difficulty level.
3. The game generates a secret number.
4. Enter your guess in the text field.
5. Click **Submit**.
6. The game tells you whether your guess is:

   * Too High
   * Too Low
   * Very Close
   * Close
   * Far Away
7. Use the **Hint** button if needed.
8. Try to guess the number within **10 attempts and 30 seconds**.
9. Your score and best score are displayed when you win.

## 💡 Hint System

The hint depends on the number of attempts:

| Attempts | Hint                                                                  |
| -------- | --------------------------------------------------------------------- |
| 0–3      | Tells whether the number is Even or Odd                               |
| 4–6      | Gives a range of ten numbers                                          |
| 7+       | Tells whether the number is above or below half of the selected range |

Using a hint reduces the final score by **20 points**.

## 🏆 Scoring

The basic score is calculated using:

```text
Score = 100 - (Attempts × 5)
```

If a hint is used:

```text
Final Score = Score - 20
```

The score cannot go below **0**.

## 🎨 GUI Design

The application uses Java Swing components including:

* `JFrame`
* `JPanel`
* `JLabel`
* `JTextField`
* `JButton`
* `JComboBox`
* `JOptionPane`

The interface uses a simple grid-based layout and custom fonts/backgrounds for a beginner-friendly graphical interface.

## 📚 Java Concepts Demonstrated

This project demonstrates several important Java concepts:

* Classes and Objects
* Inheritance using `JFrame`
* Variables and Data Types
* Conditional Statements
* Exception Handling
* Random Number Generation
* Event Handling
* Lambda Expressions
* GUI Programming with Swing
* Timers
* Methods
* User Input Validation

## 🔮 Future Enhancements

Possible improvements include:

* 💾 Save high scores to a file
* 👤 Add player names
* 🏅 Create a leaderboard
* 🔊 Add sound effects
* 🌙 Add dark mode
* 🎨 Add more GUI themes
* 📈 Store game statistics
* 🏆 Add achievement badges
* 🔢 Add customizable number ranges
