package Lessons.Lesson_6;
import Other.queue.*;

public class QueuePractice {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        Integer[] arr = {1,2,3,4,4,5,6,7,8,9,10};
        queue.Helper.insert(arr);
        System.out.println(queue);
        appearOnce(queue);
        System.out.println(queue);
    }

    public static int length(Queue<Integer> q) {
        int len = 0;
        int size = 0;

        // Count elements while restoring queue
        Queue<Integer> temp = new Queue<>();
        while (!q.isEmpty()) {
            int val = q.remove();
            temp.insert(val);
            size++;
        }
        // Restore original queue
        while (!temp.isEmpty()) {
            int val = temp.remove();
            q.insert(val);
        }

        return size;
    }

    public static void copy(Queue<Integer> q, Queue<Integer> copy) {
        Queue<Integer> temp = new Queue<>();
        while (!q.isEmpty()) {
            int val = q.remove();
            copy.insert(val);
            temp.insert(val);
        }
        // Restore original queue
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
    }

    public static boolean contains(Queue<Integer> q, int num) {
        boolean found = false;
        Queue<Integer> temp = new Queue<>();
        while (!q.isEmpty()) {
            int val = q.remove();
            if (val == num) found = true;
            temp.insert(val);
        }
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        return found;
    }

    public static boolean isSorted(Queue<Integer> q) {
        if (q.isEmpty()) return true;
        boolean sorted = true;
        Queue<Integer> temp = new Queue<>();
        int prev = q.remove();
        temp.insert(prev);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (curr < prev) sorted = false;
            temp.insert(curr);
            prev = curr;
        }
        // Restore original queue
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        return sorted;
    }

    public static boolean isEqual(Queue<Integer> q1, Queue<Integer> q2) {
        boolean equal = true;
        Queue<Integer> temp1 = new Queue<>();
        Queue<Integer> temp2 = new Queue<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int a = q1.remove();
            int b = q2.remove();
            if (a != b) equal = false;
            temp1.insert(a);
            temp2.insert(b);
        }
        if (!q1.isEmpty() || !q2.isEmpty()) equal = false;
        while (!temp1.isEmpty()) q1.insert(temp1.remove());
        while (!temp2.isEmpty()) q2.insert(temp2.remove());
        return equal;
    }

    public static boolean isEqualRecursive(Queue<Integer> q1, Queue<Integer> q2) {
        if (q1.isEmpty() || q2.isEmpty())
            return q1.isEmpty() && q2.isEmpty();
        int a = q1.remove(),  b = q2.remove();
        return a == b &&  isEqualRecursive(q1, q2);
    }

    public static void moveNumToFront(Queue<Integer> q, int num) {
        int size = length(q);
        Queue<Integer> temp = new Queue<>();
        boolean moved = false;

        for (int i = 0; i < size; i++) {
            int val = q.remove();
            if (!moved && val == num) {
                temp.insert(val); // insert at front of temp
                moved = true;
            } else {
                q.insert(val); // keep others in q
            }
        }

        // Merge temp (num) and q back
        while (!temp.isEmpty()) q.insert(temp.remove());
    }

    public static boolean hasSeries(Queue<Integer> q, int num) {
        boolean found = false;
        Queue<Integer> temp = new Queue<>();
        copy(q, temp);

        if (temp.isEmpty()) return false;

        int prev = temp.remove();
        while (!temp.isEmpty()) {
            int curr = temp.remove();
            if (prev == num && curr == num) {
                found = true;
            }
            prev = curr;
        }
        return found;
    }

    public static void appearOnce(Queue<Integer> q) {
        Queue<Integer> temp = new Queue<>();
        while (!q.isEmpty()) {
            int val = q.remove();
            if (!contains(temp,val))
                temp.insert(val);
        }
        while (!temp.isEmpty())
            q.insert(temp.remove());
    }
}
