package QueueDone.DequeBasics;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class GetStarted {
/**
 *  #Double-Ended Queue (Deque)
 * The "Swiss Army Knife" of linear data structures. I implemented the Deque to demonstrate how a single structure
 * can flexibly act as both a Stack (LIFO) and a Queue (FIFO).
 *
 *  Logic: Supports insertion and deletion from both the `front` and the `rear`.
 *  Key Operations:** `addFirst()`, `addLast()`, `removeFirst()`, `removeLast()`.
 *
 * **Applications:
 *     * Sliding Window Maximum:** Optimized O(N) solutions for finding the maximum in every window of size k.
 *     * Undo/Redo Operations:** Maintaining a history of actions with a limit.
 *     * Palindrome Checker:** Comparing ends simultaneously for O(N) validation.
 *
 */
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);  // [1]
        deque.addFirst(2);  // [2,1]
        deque.addLast(3);   // [2,1,3]
        deque.addLast(4);   //[2,1,3,4]
        deque.removeFirst(); // 2 is removed [1,3,4]

        while (!deque.isEmpty()){
            System.out.print(deque.remove());
        }
        System.out.println();
    }

}
