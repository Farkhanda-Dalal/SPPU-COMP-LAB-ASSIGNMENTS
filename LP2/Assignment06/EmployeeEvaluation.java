import java.util.Scanner;

public class EmployeeEvaluation {
    private static Scanner scanner = new Scanner(System.in);
    private static final int THRESHOLD_GOOD = 18;
    private static final int THRESHOLD_AVERAGE = 12;
    private static final int MAX_SCORE = 24;

    public static void printEvaluationCriteria() {
        System.out.println("\n********** Employee Evaluation Criteria **********\n");
        System.out.println("| Category       | Criteria Impact                                 |");
        System.out.println("|----------------|-------------------------------------------------|");
        System.out.println("| Punctuality    | 3 'No' -> Needs improvement                     |");
        System.out.println("| Teamwork       | 2 'No' -> Lack of collaboration                 |");
        System.out.println("| Productivity   | 3 'Yes' -> Eligible for performance bonus       |");
        System.out.println("| Communication  | 2 'No' -> Training recommended                  |");
        System.out.println("| Problem Solving| 3 'Yes' -> Considered for promotion             |");
        System.out.println("| Adaptability   | 2 'No' -> Struggles with change                 |");
        System.out.println("| Leadership     | 3 'Yes' -> Potential for managerial role        |");
        System.out.println("| Work Ethic     | 3 'No' -> Serious action required               |");
        System.out.println("\n**************************************************\n");
    }

    public static int askQuestion(String category, String question, String alternativeQuestion) {
        System.out.print("\n[" + category + "] " + question + " (y/n): ");
        String response = scanner.next().trim().toLowerCase();
        if (response.startsWith("y")) {
            return 1;
        } else {
            System.out.print("\n[" + category + "] " + alternativeQuestion + " (y/n): ");
            response = scanner.next().trim().toLowerCase();
            return response.startsWith("y") ? 1 : 0;
        }
    }

    public static int evaluateCategory(String category, String[] questions, String[] alternativeQuestions, String negativeRemark, String positiveRemark, StringBuilder report) {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            score += askQuestion(category, questions[i], alternativeQuestions[i]);
        }
        if (score < 2) {
            report.append(String.format("| %-15s | %-35s |\n", category, negativeRemark));
        } else {
            report.append(String.format("| %-15s | %-35s |\n", category, positiveRemark));
        }
        return score;
    }

    public static void main(String[] args) {
        printEvaluationCriteria();
        System.out.println("\n********** Employee Evaluation System **********\n");

        int totalScore = 0;
        StringBuilder report = new StringBuilder();
        report.append("\n********** Final Evaluation Report **********\n");
        report.append("| Category       | Remark                              |\n");
        report.append("|----------------|------------------------------------|\n");

        totalScore += evaluateCategory("Punctuality", 
            new String[]{"Does the employee arrive on time regularly?", "Does the employee meet deadlines consistently?", "Does the employee inform management when running late?"},
            new String[]{"Does the employee make up for lost time?", "Does the employee communicate delays?", "Does the employee plan schedules effectively?"},
            "Needs improvement", "Highly reliable and punctual", report);

        totalScore += evaluateCategory("Teamwork", 
            new String[]{"Does the employee collaborate well with colleagues?", "Does the employee contribute to team discussions?", "Does the employee support team members when needed?"},
            new String[]{"Does the employee try to improve collaboration?", "Does the employee respect different opinions?", "Does the employee acknowledge team efforts?"},
            "Lack of collaboration", "Great team player and contributor", report);

        totalScore += evaluateCategory("Productivity", 
            new String[]{"Does the employee complete tasks efficiently?", "Does the employee show initiative in work?", "Does the employee handle workload effectively?"},
            new String[]{"Does the employee manage time well?", "Does the employee look for process improvements?", "Does the employee meet expected targets?"},
            "Needs motivation", "Eligible for performance bonus", report);

        totalScore += evaluateCategory("Communication", 
            new String[]{"Does the employee communicate effectively?", "Does the employee provide clear and concise reports?", "Does the employee listen actively to others?"},
            new String[]{"Does the employee clarify misunderstandings?", "Does the employee respond professionally?", "Does the employee engage in constructive discussions?"},
            "Training recommended", "Excellent communication skills", report);

        totalScore += evaluateCategory("Problem Solving", 
            new String[]{"Does the employee handle challenges well?", "Does the employee propose effective solutions?", "Does the employee remain calm under pressure?"},
            new String[]{"Does the employee take responsibility for errors?", "Does the employee seek advice when needed?", "Does the employee learn from past mistakes?"},
            "Lacks problem-solving skills", "Considered for promotion", report);

        totalScore += evaluateCategory("Adaptability", 
            new String[]{"Does the employee adapt to new situations easily?", "Does the employee accept changes positively?", "Does the employee learn new skills when needed?"},
            new String[]{"Does the employee work well in different environments?", "Does the employee adjust to team needs?", "Does the employee remain flexible under pressure?"},
            "Struggles with change", "Highly adaptable and flexible", report);

        totalScore += evaluateCategory("Leadership", 
            new String[]{"Does the employee take initiative in tasks?", "Does the employee mentor others?", "Does the employee motivate team members?"},
            new String[]{"Does the employee demonstrate decision-making skills?", "Does the employee handle responsibility well?", "Does the employee inspire confidence?"},
            "Needs leadership training", "Potential for managerial role", report);

        totalScore += evaluateCategory("Work Ethic", 
            new String[]{"Does the employee demonstrate integrity?", "Does the employee take ownership of tasks?", "Does the employee meet commitments consistently?"},
            new String[]{"Does the employee show dedication?", "Does the employee uphold company values?", "Does the employee handle responsibilities professionally?"},
            "Serious action required", "Exemplary work ethic", report);

        System.out.println("\nTotal Score: " + totalScore + " / " + MAX_SCORE);
        if (totalScore >= THRESHOLD_GOOD) {
            System.out.println("Performance Level: Good Performance");
        } else if (totalScore >= THRESHOLD_AVERAGE) {
            System.out.println("Performance Level: Average Performance");
        } else {
            System.out.println("Performance Level: Needs Improvement");
        }
        
        report.append("\n**************************************************\n");
        System.out.println(report.toString());
    }
}
