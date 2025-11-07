import java.util.*;

public class fifo {
    public static void main(String[] args) {
        int[] pages = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int capacity = 3;

        Queue<Integer> memory = new LinkedList<>();
        int pageFaults = 0;

        System.out.println("Page\tMemory\t\tPage Fault");

        for (int page : pages) {
            boolean fault = false;

            if (!memory.contains(page)) {
                fault = true;
                pageFaults++;

                if (memory.size() == capacity) {
                    memory.poll(); // remove oldest page
                }

                memory.offer(page); // add new page
            }

            System.out.printf("%d\t%s\t%s\n", page, memory, fault ? "Yes" : "No");
        }

        System.out.println("\nTotal Page Faults: " + pageFaults);
    }
}
