import java.util.ArrayList;
import java.util.Scanner;

public class QuizApp {

    // A small helper class to store each question and its details
    static class Question {
        String text;
        String[] options;
        char correct;

        Question(String text, String[] options, char correct) {
            this.text = text;
            this.options = options;
            this.correct = Character.toUpperCase(correct);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Prepare our questions
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "Which language is used for Android app development?",
                new String[]{"A. Java", "B. Python", "C. Swift", "D. Kotlin"},
                'D'
        ));
        questions.add(new Question(
                "What is the capital city of France?",
                new String[]{"A. Paris", "B. London", "C. Rome", "D. Berlin"},
                'A'
        ));
        questions.add(new Question(
                "Which data type is used for true/false values in Java?",
                new String[]{"A. int", "B. boolean", "C. char", "D. String"},
                'B'
        ));

        int score = 0;

        System.out.println("===== Welcome to My Quiz App =====");
        System.out.println("Answer each question by typing A, B, C, or D.\n");

        // Step 2: Ask each question
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);

            System.out.println((i + 1) + ". " + q.text);
            for (String option : q.options) {
                System.out.println(option);
            }

            System.out.print("Your answer: ");
            char ans = sc.next().toUpperCase().charAt(0);

            if (ans == q.correct) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer was: " + q.correct + "\n");
            }
        }

        // Step 3: Show final result
        System.out.println("===== Quiz Over! =====");
        System.out.println("You scored " + score + " out of " + questions.size());

        double percent = (score * 100.0) / questions.size();
        System.out.printf("Percentage: %.2f%%\n", percent);

        if (percent >= 80) {
            System.out.println("🏆 Excellent work!");
        } else if (percent >= 50) {
            System.out.println("👍 Good effort!");
        } else {
            System.out.println("📚 Keep practicing!");
        }

        sc.close();
    }
}
