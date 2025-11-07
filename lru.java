import java.util.*;

public class lru {
    public static void main(String[] args) {
        int[] pages = {1, 2, 3, 1, 4, 5};
        int capacity = 3;

        List<Integer> memory = new ArrayList<>();
        int pageFaults = 0;

        System.out.println("Page\tMemory\t\tPage Fault");

        for (int page : pages) {
            boolean fault = false;

            if (!memory.contains(page)) {
                fault = true;
                pageFaults++;

                if (memory.size() == capacity) {
                    memory.remove(0); // remove least recently used
                }
            } else {
                memory.remove((Integer) page); // remove and re-add to update usage
            }

            memory.add(page); // add as most recently used
            System.out.printf("%d\t%s\t%s\n", page, memory, fault ? "Yes" : "No");
        }

        System.out.println("\nTotal Page Faults: " + pageFaults);
    }
}
