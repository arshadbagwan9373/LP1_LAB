import java.util.Scanner;

public class sjf {

    public static void main(String[] args) {
        int n, cputime = 0, c = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("----------- SJF --------------");
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

        
        while(c<n){
            int ind=-1;
            int minbt=100;

            for(int i=0;i<n;i++){

                if(p[i].AT <= cputime && ! p[i].done && p[i].BT <= minbt){
                    ind = i;
                    minbt = p[i].BT;
                }
                
            }

            if(ind!=-1){

                cputime += p[ind].BT;
                p[ind].CT = cputime;
                p[ind].TAT = p[ind].CT - p[ind].AT;
                p[ind].WT = p[ind].TAT - p[ind].BT;
                p[ind].done = true;
                c++;
                System.out.println("PROCESS P" + ind + " Executed...");

            }else{
                cputime++;
            }
            

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
