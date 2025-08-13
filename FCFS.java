import java.util.*;

class process{
int id, at,bt, ct,tat,wt;
}

class FCFS{
public static void main(String Args[]){
Scanner sc = new Scanner(System.in);
int n;
int ct,wt=0,tat=0;

ct=0;
System.out.println("CPU SHEDULING ALGORITHM");
System.out.print("Enter Number of processes :");
n = sc.nextInt();
process[] arr = new process[10];
for (int i =0 ; i<n ; i++){
arr[i] = new process();
arr[i].id = i+1;
System.out.print("Enter Arrival time of processes -"+(i+1)+":");
arr[i].at = sc.nextInt();
System.out.print("Enter Burst time of processes -"+(i+1)+":");
arr[i].bt = sc.nextInt();

}

for(int i = 0 ; i<n ; i++){

//-------this is queue--------------

ct+= arr[i].bt;
arr[i].ct = ct;
arr[i].tat = arr[i].ct - arr[i].at ;
arr[i].wt = arr[i].tat-arr[i].bt;
System.out.println("--------------------------------");
System.out.println("Process "+(i+1)+" Executed.....");
}

//----calculate overall

for(int i = 0 ; i<n ; i++){
wt += arr[i].wt;
tat+= arr[i].tat;
}

        System.out.println("\n---------------- Process Details ----------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "PID", "AT", "BT", "CT", "TAT", "WT");
        for (process proc : arr) {
            System.out.printf("%-10d%-10d%-10d%-10d%-10d%-10d\n",
                    proc.id, proc.at, proc.bt, proc.ct, proc.tat, proc.wt);
        }   

System.out.println("--------------//------------------");
System.out.println("Average Waiting Time : "+ (wt/n));
System.out.println("Average TurnAround Time : "+ (tat/n));
System.out.println("--------------//------------------");




}

}
