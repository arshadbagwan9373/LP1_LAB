import java.util.concurrent.Semaphore;




public class ReaderWriter {

    static final Semaphore mutex = new Semaphore(1);
    static final Semaphore wlock = new Semaphore(1);
    static int readcount=0;

    static void read(String rname) throws InterruptedException {

        readcount++;
        mutex.acquire();

        if (readcount==1){ wlock.acquire();}

        mutex.release();
        System.out.println("Reader --"+ rname + "  Reading......");
        Thread.sleep(10);
        System.out.println("Reader "+ rname + "   Done >>>>>>>");
        readcount--;
        
        mutex.acquire();
        if(readcount==0){ wlock.release();}

        mutex.release();

    }


    static void write(String wname ) throws InterruptedException {
        wlock.acquire();
        System.out.println("Writer -- "+ wname+"  Writing.....");
        Thread.sleep(10);
        System.out.println("Writing Done >>>>>");
        wlock.release();

    }

    public static void main(String[] args) {

        new reader("Arshad").start();
        new reader("Mansi").start();
        new writer("Vedant").start();
        new writer("Chinmay").start();
        
    }
    
}

class reader extends Thread{
    public reader(String name){
        super(name);
    }

  public void run(){
    try {
        ReaderWriter.read(getName());
    } catch (Exception e) {
    }
  }


}

class writer extends Thread{
    public writer(String name){
        super(name);

    }

    public void run(){
        try {
            ReaderWriter.write(getName());
        } catch (Exception e) {
        }
    }
}
