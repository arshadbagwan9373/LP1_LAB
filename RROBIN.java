import java.util.*;
class Pr{
int id,at,ct,tat,wt,bt;
int remain_exe;
boolean executed = false;
}
class RROBIN{
public static void main(String args[])
{
int n,w,t ,cputime,ncp,tq;
Scanner sc = new Scanner(System.in);
System.out.println("---- ROUND ROBIN ------\n");
System.out.println("Enter number of Proceses :");
n= sc.nextInt();
System.out.println("Enter Time Quantum :");
tq= sc.nextInt();

Pr[] q = new Pr[n];

for(int i=0;i<n;i++){
    q[i] = new Pr();
    q[i].id = i+1;
    System.out.print("Enter Arrival Time of P"+ (i+1)+" :");
    q[i].at = sc.nextInt();
    System.out.print("Enter Burst Time of P"+ (i+1)+" :");      //getting details pf processes
    q[i].bt = sc.nextInt();
    q[i].remain_exe=q[i].bt;

}
ncp = 0;
cputime=0;
w=0;
t=0;
while(ncp < n){
for(int i =0;i<n;i++){

    if( ! q[i].executed){
    
    if(q[i].at <= cputime){
       if(q[i].remain_exe < tq){
           cputime+=q[i].remain_exe;
           q[i].remain_exe = 0 ; 
           
       }else{
       q[i].remain_exe = q[i].remain_exe - tq ;
       cputime+=tq;
       
       }
       if(q[i].remain_exe <= 0){ 
       q[i].executed=true; 
       q[i].ct = cputime;
       q[i].tat = q[i].ct - q[i].at;
       q[i].wt = q[i].tat - q[i].bt;
       ncp ++;}
    }
    
    }
    }}
System.out.println("\n-------------------- Process Details --------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "PID", "AT", "BT", "CT", "TAT", "WT");
        for (Pr proc : q) {
            System.out.printf("%-10d%-10d%-10d%-10d%-10d%-10d\n",
                    proc.id, proc.at, proc.bt, proc.ct, proc.tat, proc.wt);
        } 
        for(int j=0;j<n;j++){
            w += q[j].wt;
            t += q[j].tat;
        }
        System.out.println("-------- Avg Waiting Time is "+(w/n)+" --------------");
        System.out.println("-------- Avg Turn Around Time is "+(t/n)+" --------------");
}
}
