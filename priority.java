import java.util.Scanner;

public class priority {

    public static void main(String[] args) {
        int n, cputime = 0, c = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("----------- PRIORITY --------------");
        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        processs[] p = new processs[n];

        for (int i = 0; i < n; i++) {
            p[i] = new processs();
            System.out.print("Enter AT for P" + i + ": ");
            p[i].AT = sc.nextInt();
            System.out.print("Enter BT for P" + i + ": ");
            p[i].BT = sc.nextInt();
            System.out.print("Enter Priority for P" + i + ": ");
            p[i].pr = sc.nextInt();
        }

        
        while(c<n){
            int ind=-1;
            int mpriority=0;

            for(int i=0;i<n;i++){

                if(p[i].AT <= cputime && ! p[i].done && p[i].pr >= mpriority){
                    ind = i;
                    mpriority = p[i].pr;
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

class processs {
    int AT, BT, CT, TAT, WT ,pr;
    boolean done = false;
}
