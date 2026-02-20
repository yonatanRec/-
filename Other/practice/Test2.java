package Other.practice;
import Other.queue.*;
import Other.node.*;
public class Test2 {
    public static void main(String[] args) {
        Call[] calls = {
                new Call(1, "Customer-1"),
                new Call(1, "Customer-2"),
                new Call(2, "Customer-3"),
                new Call(1, "Customer-4"),
                new Call(2, "Customer-5")
        };
        Queue<Call> lst = new Queue<>(calls);
        System.out.println(lst);
        System.out.println(getMostUrgent(lst));
        System.out.println(lst);
    }

    public static <T> int size(Queue<T> q) {
        Queue<T> temp = new Queue<>();
        int size = 0;
        while (!q.isEmpty()) {
            temp.insert(q.remove());
            size++;
        }
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        return size;
    }

    public static int queSum(Queue<Integer> q) {
        int sum = 0;
        Queue<Integer> temp = new Queue<>();
        while (!q.isEmpty()) {
            int value = q.head();
            sum += value;
            temp.insert(q.remove());
        }
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        return sum;
    }

    public static boolean exist(Queue<Integer> q, int n) {
        Queue<Integer> temp = new Queue<>();
        boolean found = false;
        while (!q.isEmpty()) {
            int value = q.head();
            if (value == n) {
                found = true;
            }
            temp.insert(q.remove());
        }
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        return found;
    }

    public static Queue<Integer> copySubQueue(Queue<Integer> q, int k) {
        Queue<Integer> temp = new Queue<>();
        Queue<Integer> copy = new Queue<>();
        for (int i = 0; i < k && !q.isEmpty(); i++) {
            int val = q.head();
            copy.insert(val);
            temp.insert(q.remove());
        }
        while (!q.isEmpty()) {
            temp.insert(q.remove());
        }
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        return copy;
    }

    public static Queue<Integer> difference(Queue<Integer> q) {
        Queue<Integer> temp = new Queue<>();
        Queue<Integer> diff = new Queue<>();
        while (!q.isEmpty()) {
            int val1 = q.head();
            temp.insert(q.remove());
            if (!q.isEmpty()) {
                int val2 = q.head();
                diff.insert(val1 - val2);
            }
        }
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        return diff;
    }

    public static <T> Queue<T> copy(Queue<T> q) {
        Queue<T> temp = new Queue<>();
        Queue<T> copy = new Queue<>();
        while (!q.isEmpty()) {
            T val = q.head();
            temp.insert(q.remove());
            copy.insert(val);
        }
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        return copy;
    }

    public static String getMostUrgent(Queue<Call> qu){
        Queue<Call> temp = new Queue<>();
        int urgency = -1;
        String mostUrgent = "";
        while (!qu.isEmpty()) {
            int currUrgency = qu.head().getPriority();
            if (currUrgency > urgency) {
                urgency = currUrgency;
                mostUrgent = qu.head().getServiceNumber();
            }
            temp.insert(qu.remove());
        }
        while (!temp.isEmpty()) {
            if (temp.head().getServiceNumber().equals(mostUrgent)) {
                temp.remove();
            }
            else
                qu.insert(temp.remove());
        }
        return mostUrgent;
    }


    public static boolean bounded(Node<Integer> lst) {
        Node<Integer> pos = lst;
        int max = Integer.MIN_VALUE, first = lst.getValue();
        int min = Integer.MAX_VALUE, last = pos.getValue();
        while (pos != null) {
            if (pos.getValue() > max) {
                max = pos.getValue();
            }
            if (pos.getValue() < min) {
                min = pos.getValue();
            }
            last = pos.getValue();
            pos = pos.getNext();
        }
        if (max > first && max > last)
            return false;
        return min >= first || min >= last;
    }

    public static void removeAbove(Node<Product> lst, int maxPrice){
        Node<Product> pos = lst;
        while(pos.hasNext()){
            if(pos.getValue().getPrice() > maxPrice){
                pos.setNext(pos.getNext().getNext());
                pos.setValue(pos.getNext().getValue());
            }
            pos = pos.getNext();
        }
        if (pos.getValue().getPrice() > maxPrice){
            pos.setNext(null);
            pos.setValue(null);
        }
    }

}


class Call{
    private int priority;
    private String serviceNumber;

    public Call(int priority, String serviceNumber) {
        this.priority = priority;
        this.serviceNumber = serviceNumber;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    @Override
    public String toString() {
        return serviceNumber + " Priority: " +  priority;
    }
}

class Product{
    private int price;
    private String name;

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}