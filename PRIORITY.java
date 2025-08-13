import java.util.*;

class Process {
    int id,at, bt, ct, tat, wt,p;
    boolean executed = false;
}

public class PRORITY {
    public static void main(String[] args) {
        int n, cput = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("----------- PRIORITY SCHEDULING  -------");
        System.out.print("Enter Number of Processes: ");
        n = sc.nextInt();

        Process[] redq = new Process[n];
        for (int i = 0; i < n; i++) {
            redq[i] = new Process();
            redq[i].id = i+1;
            System.out.print("Enter AT for P" + (i + 1) + ": ");
            redq[i].at = sc.nextInt();
            System.out.print("Enter BT for P" + (i + 1) + ": ");
            redq[i].bt = sc.nextInt();
            System.out.print("Enter Priority for P" + (i + 1) + ": ");
            redq[i].p = sc.nextInt();
        }

        int completed = 0;
        while (completed < n) {
            int idx = -1;
            int maxp = 0;

            for (int i = 0; i < n; i++) {
                if (!redq[i].executed && redq[i].at <= cput && redq[i].p > maxp) {
                    maxp = redq[i].p;
                    idx = i;
                }
            }



            if (idx != -1) {
                cput += redq[idx].bt;
                redq[idx].ct = cput;
                redq[idx].tat = redq[idx].ct - redq[idx].at;
                redq[idx].wt = redq[idx].tat - redq[idx].bt;
                redq[idx].executed = true;
                completed++;
            } else {
                cput++;
            }
        }
        


                System.out.println("\n-------------------- Process Details --------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", "PID", "AT", "BT", "P", "CT", "TAT", "WT");
        for (Process proc : redq) {
            System.out.printf("%-10d%-10d%-10d%-10d%-10d%-10d%-10d\n",
                    proc.id, proc.at, proc.bt,proc.p, proc.ct, proc.tat, proc.wt);
        }   

        
    }
}
