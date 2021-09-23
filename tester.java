import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class tester {
    public static void main(String[] arg) {
        PriorityQueue q = new PriorityQueue();
        q.push(6, 9);

        /**
         * location.put(69, 10); heap.add(makePair(2, 69));
         * System.out.println(q.Priority(6)); System.out.println(q.getPriority(10));
         * System.out.println(q.getPriority(0)); q.push(1, 10); q.push(6, 9); q.push(10,
         * 8); q.push(13, 7); q.push(8, 6); q.push(59, 5); q.push(45, 4); q.push(70, 3);
         * q.push(56, 2); q.push(30, 1); q.push(1, 10); q.printMap(); q.printHeap();
         * q.printMap(); q.printHeap(); q.changePriority(32,1); q.printMap();
         * q.printHeap(); System.out.println(q.topPriority());
         */

    }

    public static Pair<Integer, Integer> makePair(int priority, int element) {
        Pair<Integer, Integer> p1 = new Pair<>(priority, element);
        return p1;
    }
}