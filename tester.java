import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class tester {
    public static void main(String[] arg) {
        PriorityQueue q = new PriorityQueue();
        HashMap<Integer, Integer> location = new HashMap<>();
        ArrayList<Pair<Integer, Integer>> heap = new ArrayList<>();
        location.put(10, 0);
        location.put(9, 1);
        location.put(8, 2);
        location.put(7, 3);
        location.put(6, 4);
        location.put(5, 5);
        location.put(4, 6);
        location.put(3, 7);
        location.put(2, 8);
        location.put(1, 9);

        heap.add(makePair(1, 10));
        heap.add(makePair(6, 9));
        heap.add(makePair(10, 8));
        heap.add(makePair(13, 7));
        heap.add(makePair(8, 6));
        heap.add(makePair(59, 5));
        heap.add(makePair(45, 4));
        heap.add(makePair(70, 3));
        heap.add(makePair(56, 2));
        heap.add(makePair(30, 1));

        q.setLocation(location);
        q.setHeap(heap);
        q.printMap();
        q.printHeap();
        q.push(7, 777);
        q.printMap();
        q.printHeap();
        /**
         * location.put(69, 10); heap.add(makePair(2, 69));
         * System.out.println(q.Priority(6)); System.out.println(q.getPriority(10));
         * System.out.println(q.getPriority(0));
         * 
         * 
         * q.printMap(); q.printHeap(); q.changePriority(32,1); q.printMap();
         * q.printHeap(); System.out.println(q.topPriority());
         */

    }

    public static Pair<Integer, Integer> makePair(int priority, int element) {
        Pair<Integer, Integer> p1 = new Pair<>(priority, element);
        return p1;
    }
}