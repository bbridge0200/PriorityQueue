import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class tester {
    public static void main(String[] arg) {
        PriorityQueue q = new PriorityQueue();
        q.push(0, 3);
        q.push(10, 4);
        q.push(1000, 1);
        q.push(47, 2);
        q.printMap();
        q.printHeap();
    }
}