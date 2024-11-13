import java.util.*;

public class ProcessScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, n, quantum;

        System.out.print("Enter the number of processes: ");
        n = scanner.nextInt();

        Process p = new Process(n);
        p.get();

        System.out.print("Enter the time quantum for Round Robin scheduling: ");
        quantum = scanner.nextInt();
        p.quantum = quantum;

        do {
            System.out.println("\nChoose the scheduling algorithm:");
            System.out.println("1. First Come First Serve (FCFS)");
            System.out.println("2. Shortest Job First (Preemptive)");
            System.out.println("3. Priority Scheduling (Non-Preemptive)");
            System.out.println("4. Round Robin (Preemptive)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    p.sort();
                    p.fcfs();
                    p.display();
                    p.calculateAverage();
                    p.displayExecutionOrder();
                    break;
                case 2:
                    p.sort();
                    p.sjfPreemptive();
                    p.display();
                    p.calculateAverage();
                    p.displayExecutionOrder();
                    break;
                case 3:
                    p.sort();
                    p.priorityScheduling();
                    p.display();
                    p.calculateAverage();
                    p.displayExecutionOrder();
                    break;
                case 4:
                    p.sort();
                    p.roundRobin();
                    p.display();
                    p.calculateAverage();
                    p.displayExecutionOrder();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
