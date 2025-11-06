import java.util.*;

class fcfs {
    public static void main(String args[]) {
        int n, cputime = 0, c = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("----------- FCFS --------------");
        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        Process[] p = new Process[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Process();
            System.out.print("Enter AT for P" + i + ": ");
            p[i].AT = sc.nextInt();
            System.out.print("Enter BT for P" + i + ": ");
            p[i].BT = sc.nextInt();
        }

        while (c < n) {
            boolean executed = false;
            for (int i = 0; i < n; i++) {
                if (p[i].AT <= cputime && !p[i].done) {
                    cputime += p[i].BT;
                    p[i].CT = cputime;
                    p[i].TAT = p[i].CT - p[i].AT;
                    p[i].WT = p[i].TAT - p[i].BT;
                    p[i].done = true;
                    c++;
                    executed = true;
                    System.out.println("PROCESS P" + i + " Executed...");
                    break;
                }
            }
            if (!executed) cputime++;
        }

        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "PID", "AT", "BT", "CT", "TAT", "WT");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s %-10d %-10d %-10d %-10d %-10d\n",
                    "P" + i, p[i].AT, p[i].BT, p[i].CT, p[i].TAT, p[i].WT);
        }
    }
}

class Process {
    int AT, BT, CT, TAT, WT;
    boolean done = false;
}