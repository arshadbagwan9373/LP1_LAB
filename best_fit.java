import java.util.Scanner;

public class best_fit {

    public static void main(String args[]) {
        int np, nb;

        Scanner sc = new Scanner(System.in);

        System.out.println("----------- BEST FIT --------------");
        System.out.print("Enter number of processes: ");
        np = sc.nextInt();
        System.out.print("Enter Number of Blocks: ");
        nb = sc.nextInt();

        p[] processes = new p[np];
        b[] blocks = new b[nb];

        for (int i = 0; i < np; i++) {
            processes[i] = new p();
            System.out.println("Enter process " + i + " size");
            processes[i].size = sc.nextInt();
            processes[i].pid = i;
        }

        for (int i = 0; i < nb; i++) {
            blocks[i] = new b();
            System.out.println("Enter block " + i + " size");
            blocks[i].size = sc.nextInt();
            blocks[i].bid = i;
        }

        // Best Fit Allocation Logic
        for (int i = 0; i < np; i++) {
            int minblk = Integer.MAX_VALUE;
            int blkn = -1;

            for (int j = 0; j < nb; j++) {
                if (processes[i].size <= blocks[j].size && blocks[j].size < minblk) {
                    minblk = blocks[j].size;
                    blkn = j;
                }
            }

            if (blkn != -1) {
                processes[i].allocated = true;
                processes[i].blkno = blocks[blkn].bid;
                blocks[blkn].size -= processes[i].size;
            }
        }

        System.out.printf("%-10s %-10s %-10s\n", "PID","Allocated bloack","Allocated");
        for (int i = 0; i < np; i++) {

            System.out.printf("%-10s %-10s %-10s\n",processes[i].pid ,processes[i].blkno,processes[i].allocated );
            
        }
    }
}

class p {
    int pid, size, blkno;
    boolean allocated = false;
}

class b {
    int bid, size;
}
