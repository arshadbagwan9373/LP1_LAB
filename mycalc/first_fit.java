import java.util.Scanner;

public class first_fit {

    public static void main(String args[]) {
     int  np,nb;

        Scanner sc = new Scanner(System.in);

        System.out.println("----------- FIRST FIT --------------");
        System.out.print("Enter number of processes: ");
        np = sc.nextInt();
        System.out.print("Enter Nuber of Blocks: ");
        nb = sc.nextInt();
        

        p[] processes = new p[np];
        b[] blocks = new b[nb];

        for (int i = 0; i < np; i++) {
            processes[i] = new p();
            System.out.println("Enter process "+i+" size");
            processes[i].size = sc.nextInt();
            processes[i].pid=i;
        }

        for (int i = 0; i < nb; i++) {
            blocks[i] = new b();
            System.out.println("Enter block "+i+" size");
            blocks[i].size = sc.nextInt();
            blocks[i].bid=i;
        }


        for(int i=0;i<np;i++){
            
            for(int j=0;j<nb;j++){

                if(processes[i].size <= blocks[j].size && ! processes[i].allocated){
                    processes[i].allocated=true;
                    processes[i].blkno = j;
                    blocks[j].size-=processes[i].size;
                }

            }


        }
        System.out.printf("%-10s %-10s %-10s\n", "PID","Allocated bloack","Allocated");
        for (int i = 0; i < np; i++) {

            System.out.printf("%-10s %-10s %-10s\n",processes[i].pid ,processes[i].blkno,processes[i].allocated );
            
        }


    }
    
}


class p{
    int pid,size,blkno;
    boolean allocated=false;
}

class b{
    int bid,size;
}
