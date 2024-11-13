import java.util.*;

class Process {
    int number;
    int[] pid;
    int[] AT;
    int[] BT;
    int[] CT;
    int[] RT;
    int[] TAT;
    int[] WT;
    int[] priority;
    List<Integer> executionOrder; // Single list to store execution order
    int quantum; // Time quantum for Round Robin

    // Constructor
    public Process(int n) {
        number = n;
        pid = new int[n];
        AT = new int[n];
        BT = new int[n];
        CT = new int[n];
        RT = new int[n];
        TAT = new int[n];
        WT = new int[n];
        priority = new int[n];
        executionOrder = new ArrayList<>();
    }

    // Method to get input for processes
    public void get() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < number; i++) {
            System.out.println("Enter pid for " + (i + 1) + "th process :");
            pid[i] = scanner.nextInt();
            System.out.println("Enter Arrival Time for " + (i + 1) + "th process :");
            AT[i] = scanner.nextInt();
            System.out.println("Enter Burst Time for " + (i + 1) + "th process :");
            BT[i] = scanner.nextInt();
            System.out.println("Enter Priority for " + (i + 1) + "th process (lower number means higher priority):");
            priority[i] = scanner.nextInt();
            RT[i] = BT[i]; // Initial remaining time is the burst time
        }
    }

    // Method to display process information
    public void display() {
        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
        for (int i = 0; i < number; i++) {
            System.out.println(pid[i] + "\t" + AT[i] + "\t" + BT[i] + "\t" + CT[i] + "\t" + TAT[i] + "\t" + WT[i]);
        }
    }

    // Method to display execution order
    public void displayExecutionOrder() {
        System.out.println("Execution Order of Processes:");
        for (int i : executionOrder) {
            System.out.println("Process " + (i + 1) + " (PID: " + pid[i] + ")");
        }
    }

    // Method to sort processes based on Arrival Time
    public void sort() {
        for (int i = 0; i < number - 1; i++) {
            for (int j = 0; j < number - i - 1; j++) {
                if (AT[j] > AT[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    // Helper method to swap process data
    private void swap(int i, int j) {
        int temp;
        temp = pid[i]; pid[i] = pid[j]; pid[j] = temp;
        temp = AT[i]; AT[i] = AT[j]; AT[j] = temp;
        temp = BT[i]; BT[i] = BT[j]; BT[j] = temp;
        temp = RT[i]; RT[i] = RT[j]; RT[j] = temp;
        temp = priority[i]; priority[i] = priority[j]; priority[j] = temp;
    }

    // FCFS scheduling algorithm
    public void fcfs() {
        executionOrder.clear();
        CT[0] = AT[0] + BT[0]; // Completion time for first process
        executionOrder.add(0);
        for (int i = 1; i < number; i++) {
            if (CT[i - 1] > AT[i]) {
                CT[i] = BT[i] + CT[i - 1];
            } else {
                CT[i] = BT[i] + AT[i];
            }
            executionOrder.add(i);
        }

        // Calculate Waiting and Turnaround Time for each process
        for (int i = 0; i < number; i++) {
            TAT[i] = CT[i] - AT[i];
            WT[i] = TAT[i] - BT[i];
        }
    }

    // SJF Preemptive scheduling algorithm
    public void sjfPreemptive() {
        executionOrder.clear();
        int complete = 0, time = 0, minm = Integer.MAX_VALUE;
        int shortest = -1, finishTime;
        boolean check = false;

        while (complete != number) {
            for (int j = 0; j < number; j++) {
                if ((AT[j] <= time) && (RT[j] < minm) && RT[j] > 0) {
                    minm = RT[j];
                    shortest = j;
                    check = true;
                }
            }

            if (!check) {
                time++;
                continue;
            }

            if (executionOrder.isEmpty() || executionOrder.get(executionOrder.size() - 1) != shortest) {
                executionOrder.add(shortest);
            }

            RT[shortest]--;
            minm = RT[shortest] == 0 ? Integer.MAX_VALUE : RT[shortest];

            if (RT[shortest] == 0) {
                complete++;
                check = false;
                finishTime = time + 1;
                CT[shortest] = finishTime;
                TAT[shortest] = CT[shortest] - AT[shortest];
                WT[shortest] = TAT[shortest] - BT[shortest];
            }
            time++;
        }
    }

    // Priority Scheduling algorithm
    public void priorityScheduling() {
        executionOrder.clear();
        boolean[] isCompleted = new boolean[number];
        int complete = 0, time = 0;

        while (complete != number) {
            int highestPriority = Integer.MAX_VALUE;
            int selectedProcess = -1;

            for (int i = 0; i < number; i++) {
                if ((AT[i] <= time) && !isCompleted[i] && (priority[i] < highestPriority)) {
                    highestPriority = priority[i];
                    selectedProcess = i;
                }
            }

            if (selectedProcess == -1) {
                time++;
                continue;
            }

            time += BT[selectedProcess];
            CT[selectedProcess] = time;
            TAT[selectedProcess] = CT[selectedProcess] - AT[selectedProcess];
            WT[selectedProcess] = TAT[selectedProcess] - BT[selectedProcess];
            isCompleted[selectedProcess] = true;
            executionOrder.add(selectedProcess);
            complete++;
        }
    }

    // Round Robin scheduling algorithm
    public void roundRobin() {
        executionOrder.clear();
        int time = 0, complete = 0;
        int[] remainingBT = new int[number];
        System.arraycopy(BT, 0, remainingBT, 0, number);

        while (complete != number) {
            boolean done = true;
            for (int i = 0; i < number; i++) {
                if (remainingBT[i] > 0) {
                    done = false;
                    if (remainingBT[i] > quantum) {
                        time += quantum;
                        remainingBT[i] -= quantum;
                    } else {
                        time += remainingBT[i];
                        CT[i] = time;
                        TAT[i] = CT[i] - AT[i];
                        WT[i] = TAT[i] - BT[i];
                        remainingBT[i] = 0;
                        complete++;
                    }
                    executionOrder.add(i);
                }
            }
            if (done) break;
        }
    }

    // Method to calculate and display average Waiting Time and Turnaround Time
    public void calculateAverage() {
        int totalWT = 0;
        int totalTAT = 0;
        for (int i = 0; i < number; i++) {
            totalTAT += TAT[i];
            totalWT += WT[i];
        }
        System.out.println("Average Turnaround Time: " + (double) totalTAT / number);
        System.out.println("Average Waiting Time: " + (double) totalWT / number);
    }
}
