import java.util.Scanner;

public class EmployeeEvaluation {
    private static Scanner scanner = new Scanner(System.in);
    private static final int THRESHOLD_GOOD = 38;
    private static final int THRESHOLD_AVERAGE = 25;
    private static final int MAX_SCORE = 50;

    public static void printEvaluationCriteria() {
    System.out.println("\n********** Employee Evaluation Criteria **********\n");
    System.out.println("| Category          | Criteria Impact (Negative)             | Criteria Impact (Positive)                  |");
    System.out.println("|-------------------|--------------------------------------- |---------------------------------------------|");
    System.out.println("| Punctuality       | 3 'No' -> Needs improvement            | 3+ 'Yes' -> Highly reliable and punctual    |");
    System.out.println("| Teamwork          | 2 'No' -> Lack of collaboration        | 3+ 'Yes' -> Great team player and contributor|");
    System.out.println("| Productivity      | 2 'No' -> Needs motivation             | 3+ 'Yes' -> Eligible for performance bonus  |");
    System.out.println("| Communication     | 2 'No' -> Training recommended         | 3+ 'Yes' -> Excellent communication skills  |");
    System.out.println("| Problem Solving   | 2 'No' -> Lacks problem-solving skills | 3+ 'Yes' -> Considered for promotion        |");
    System.out.println("| Adaptability      | 2 'No' -> Struggles with change        | 3+ 'Yes' -> Highly adaptable and flexible   |");
    System.out.println("| Leadership        | 2 'No' -> Needs leadership training    | 3+ 'Yes' -> Potential for managerial role   |");
    System.out.println("| Work Ethic        | 2 'No' -> Serious action required      | 3+ 'Yes' -> Exemplary work ethic            |");
    System.out.println("| Technical Ability | 2 'No' -> Requires technical upskilling| 3+ 'Yes' -> Core contributor in projects    |");
    System.out.println("| Time Management   | 2 'No' -> Affects deadlines            | 3+ 'Yes' -> Excellent time management       |");
    System.out.println("\n**************************************************\n");
}

public static int askQuestion(String category, String question, String alternativeQuestion) {
    System.out.print("\n[" + category + "] " + question + " (y/n): ");
    String response = scanner.next().trim().toLowerCase();
    if (response.startsWith("y")) {
        return 1;
    } else {
        System.out.println("Primary response was 'no'. Asking alternative question...");
        System.out.print("[" + category + "] " + alternativeQuestion + " (y/n): ");
        response = scanner.next().trim().toLowerCase();
        return response.startsWith("y") ? 1 : 0;
    }
}

    public static int evaluateCategory(String category, String[] questions, String[] alternativeQuestions, String negativeRemark, String positiveRemark, StringBuilder report) {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            score += askQuestion(category, questions[i], alternativeQuestions[i]);
        }
        if (score < 3) {
            report.append(String.format("| %-18s | %-40s |\n", category, negativeRemark));
        } else {
            report.append(String.format("| %-18s | %-40s |\n", category, positiveRemark));
        }
        return score;
    }

    public static void main(String[] args) {
        printEvaluationCriteria();
        System.out.println("\n********** Employee Evaluation System **********\n");

        int totalScore = 0;
        StringBuilder report = new StringBuilder();
        report.append("\n********** Final Evaluation Report **********\n");
        report.append("| Category          | Remark                                  |\n");
        report.append("|-------------------|-------------------------------------------|\n");

        totalScore += evaluateCategory("Punctuality",
            new String[]{"Does the employee arrive on time regularly?", "Does the employee meet deadlines consistently?", "Does the employee inform management when running late?", "Does the employee avoid unnecessary breaks?", "Does the employee return from breaks on time?"},
            new String[]{"Does the employee make up for lost time?", "Does the employee communicate delays?", "Does the employee plan schedules effectively?", "Does the employee compensate for delays?", "Does the employee adhere to time policies?"},
            "Needs improvement", "Highly reliable and punctual", report);

        totalScore += evaluateCategory("Teamwork",
            new String[]{"Does the employee collaborate well with colleagues?", "Does the employee contribute to team discussions?", "Does the employee support team members when needed?", "Does the employee share responsibilities fairly?", "Does the employee help resolve team conflicts?"},
            new String[]{"Does the employee try to improve collaboration?", "Does the employee respect different opinions?", "Does the employee acknowledge team efforts?", "Does the employee promote team harmony?", "Does the employee offer constructive feedback?"},
            "Lack of collaboration", "Great team player and contributor", report);

        totalScore += evaluateCategory("Productivity",
            new String[]{"Does the employee complete tasks efficiently?", "Does the employee show initiative in work?", "Does the employee handle workload effectively?", "Does the employee prioritize tasks properly?", "Does the employee avoid procrastination?"},
            new String[]{"Does the employee manage time well?", "Does the employee look for process improvements?", "Does the employee meet expected targets?", "Does the employee plan daily tasks?", "Does the employee stay focused?"},
            "Needs motivation", "Eligible for performance bonus", report);

        totalScore += evaluateCategory("Communication",
            new String[]{"Does the employee communicate effectively?", "Does the employee provide clear and concise reports?", "Does the employee listen actively to others?", "Does the employee convey ideas clearly?", "Does the employee adapt communication style appropriately?"},
            new String[]{"Does the employee clarify misunderstandings?", "Does the employee respond professionally?", "Does the employee engage in constructive discussions?", "Does the employee confirm understanding?", "Does the employee maintain open communication?"},
            "Training recommended", "Excellent communication skills", report);

        totalScore += evaluateCategory("Problem Solving",
            new String[]{"Does the employee handle challenges well?", "Does the employee propose effective solutions?", "Does the employee remain calm under pressure?", "Does the employee approach problems analytically?", "Does the employee seek innovative solutions?"},
            new String[]{"Does the employee take responsibility for errors?", "Does the employee seek advice when needed?", "Does the employee learn from past mistakes?", "Does the employee experiment with options?", "Does the employee evaluate alternatives carefully?"},
            "Lacks problem-solving skills", "Considered for promotion", report);

        totalScore += evaluateCategory("Adaptability",
            new String[]{"Does the employee adapt to new situations easily?", "Does the employee accept changes positively?", "Does the employee learn new skills when needed?", "Does the employee manage shifting priorities?", "Does the employee handle ambiguity well?"},
            new String[]{"Does the employee work well in different environments?", "Does the employee adjust to team needs?", "Does the employee remain flexible under pressure?", "Does the employee seek new learning opportunities?", "Does the employee embrace new tools and methods?"},
            "Struggles with change", "Highly adaptable and flexible", report);

        totalScore += evaluateCategory("Leadership",
            new String[]{"Does the employee take initiative in tasks?", "Does the employee mentor others?", "Does the employee motivate team members?", "Does the employee demonstrate accountability?", "Does the employee resolve team issues?"},
            new String[]{"Does the employee demonstrate decision-making skills?", "Does the employee handle responsibility well?", "Does the employee inspire confidence?", "Does the employee align team goals?", "Does the employee delegate effectively?"},
            "Needs leadership training", "Potential for managerial role", report);

        totalScore += evaluateCategory("Work Ethic",
            new String[]{"Does the employee demonstrate integrity?", "Does the employee take ownership of tasks?", "Does the employee meet commitments consistently?", "Does the employee avoid unethical behavior?", "Does the employee remain committed during challenges?"},
            new String[]{"Does the employee show dedication?", "Does the employee uphold company values?", "Does the employee handle responsibilities professionally?", "Does the employee promote ethical practices?", "Does the employee stay motivated without supervision?"},
            "Serious action required", "Exemplary work ethic", report);

        totalScore += evaluateCategory("Technical Ability",
            new String[]{"Does the employee demonstrate required technical skills?", "Does the employee troubleshoot technical issues effectively?", "Does the employee learn new tools or technologies?", "Does the employee write clean and efficient code?", "Does the employee follow technical best practices?"},
            new String[]{"Does the employee assist others with technical problems?", "Does the employee stay updated with technology trends?", "Does the employee seek technical feedback?", "Does the employee participate in code reviews?", "Does the employee document technical work well?"},
            "Needs technical upskilling", "Core contributor in projects", report);

        totalScore += evaluateCategory("Time Management",
            new String[]{"Does the employee complete tasks within deadlines?", "Does the employee prioritize urgent tasks effectively?", "Does the employee manage multiple tasks well?", "Does the employee avoid unnecessary delays?", "Does the employee plan ahead for tasks?"},
            new String[]{"Does the employee meet daily targets?", "Does the employee use scheduling tools effectively?", "Does the employee avoid last-minute rushes?", "Does the employee stay organized under pressure?", "Does the employee adjust plans to stay on track?"},
            "Affects deadlines", "Excellent time management skills", report);

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
