
import java.util.*;

public class robin {

    public static void main(String args[]) {
        int cputime=0,c=0,n,tq;

    Scanner sc = new Scanner(System.in);

    System.out.println("----------- ROUND ROBIN --------------");
        System.out.print("Enter number of processes: ");
        n = sc.nextInt();
        System.out.print("Enter Time quantum: ");
        tq = sc.nextInt();

        Queue<process> p = new LinkedList<>();
        List<process> completed = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter AT for P" + i + ": ");
            int at= sc.nextInt();
            System.out.print("Enter BT for P" + i + ": ");
            int bt = sc.nextInt();
            p.add( new process(i,at, bt) );
    

        }

        while(c<n){
            process p1 = p.poll();
            if(p1.AT <= cputime){
                int exetime = Math.min(p1.Rbt,tq);
                p1.Rbt-=exetime;
                cputime+=exetime;

                if(p1.Rbt==0){
                    p1.CT = cputime;
                    p1.TAT = p1.CT - p1.AT;
                    p1.WT = p1.TAT - p1.BT;
                    completed.add(p1);
                    c++;

                }else{
                    p.add(p1);
                }
            

            }else{
                cputime++;
            }

        }

         System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "PID", "AT", "BT", "CT", "TAT", "WT");
         int i=0;
        for (process pr:completed) {
            System.out.printf("%-10s %-10d %-10d %-10d %-10d %-10d\n",
                    "P"+pr.PID, pr.AT, pr.BT, pr.CT, pr.TAT, pr.WT);
        }

    
    }

}


class process {
    int PID,AT, BT, CT, TAT, WT,Rbt;
    boolean done = false;

    public process(int PID,int AT,int BT){
        this.PID = PID;
        this.AT =AT;
        this.BT = BT;
        this.Rbt = BT;

    }

    
    
}
