package Other.queue;
import Other.node.Node;
public class Queue<T> {
    private Node<T> first;
    private Node<T> last;

    public Queue() {
        this.first = null;
        this.last = null;
    }

    public Queue(T x) {
        this.first = new Node<>(x);
        this.last = first.Helper.getLast(); // tail is just the node itself
    }

    // Array constructor
    public Queue(T[] arr) {
        this.first = new Node<>(arr); // builds linked list
        this.last = first.Helper.getLast();       // last node from Node.tail
    }

    public void insert(T x){
        Node<T> temp = new Node<>(x);
        if(first == null)
            first = temp;
        else
            last.setNext(temp);
        last = temp;
    }

    public T remove(){
        T x = first.getValue();
        first = first.getNext();
        if (first == null)
            last = null;
        return x;
    }

    public T head(){
        return first.getValue();
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public  String toString() {
        StringBuilder s = new StringBuilder("[");
        Node<T> p = this.first;
        while (p != null) {
            s.append(p.getValue().toString());
            if (p.getNext() != null)
                s.append(",");
            p = p.getNext();
        }
        s.append("]");
        return s.toString();
    }



    public final Helper Helper = new Helper();
    public class Helper {

        // Insert array into queue
        public void insert(T[] arr){
            for (T item : arr)
                Queue.this.insert(item);
        }

        // Insert all items of another queue (preserves order)
        public void insert(Queue<T> queue){
            Queue<T> copy = queue.Helper.copy();
            int size = copy.Helper.size();
            for (int i = 0; i < size; i++) {
                Queue.this.insert(copy.Helper.get(i));
            }
        }

        // Count number of nodes
        public int size(){
            int count = 0;
            Node<T> node = Queue.this.first;
            while (node.hasNext()){
                count++;
                node = node.getNext();
            }
            return count;
        }

        // Get item at index
        public T get(int index){
            Node<T> node = Queue.this.first;
            for (int i = 0; i < index; i++){
                node = node.getNext();
            }
            return node.getValue();
        }

        // Copy full queue
        public Queue<T> copy(){
            return copy(size());
        }

        // Copy [0, endIndex)
        public Queue<T> copy(int endIndex){
            return copy(0, endIndex);
        }

        // Copy [startIndex, endIndex)
        public Queue<T> copy(int startIndex, int endIndex){
            Queue<T> copy = new Queue<>();
            for (int i = startIndex; i < endIndex; i++){
                copy.insert(get(i));
            }
            return copy;
        }

        // Reverse copy full queue
        public Queue<T> copyReverse(){
            return copyReverse(size());
        }

        public Queue<T> copyReverse(int endIndex){
            return copyReverse(0, endIndex);
        }

        public Queue<T> copyReverse(int startIndex, int endIndex){
            Queue<T> copy = new Queue<>();
            for (int i = endIndex - 1; i >= startIndex; i--){
                copy.insert(get(i));
            }
            return copy;
        }

        // Return last element
        public T last(){
            return get(size() - 1);
        }

        // Insert item at a specific index
        public void insert(T item, int index){
            Queue<T> before = copy(0, index);
            Queue<T> after  = copy(index, size());

            before.insert(item);
            before.Helper.insert(after);

            Queue.this.first = before.first;
            Queue.this.last  = before.last;
        }
    }



}
