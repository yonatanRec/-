package Other.node;

public class Node<T> {
    private T value;
    private Node<T> next;

    private int size;

    private Node<T> tail;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.tail = this; // single node is also the tail
        this.size = 1;
    }

    // Value + next node constructor
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
        // If next is null, tail is self; else tail is next's tail
        this.tail = (next == null) ? this : next.tail;
        this.size = 2;
    }

    public T getValue()
    {
        return this.value;
    }

    public Node<T> getNext()
    {
        return this.next;
    }

    public boolean hasNext()
    {
        return (this.next != null);
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    @Override
    public  String toString()
    {
        return this.value + "";
    }

    public String fullString(){
        return this.value + (this.hasNext() ? " → " + this.next.fullString() : "");
    }

    // Empty node constructor
    public Node() {
        this.value = null;
        this.next = null;
        this.tail = this; // default tail is self
        this.size = 0;
    }
    // Array constructor
    public Node(T[] arr) {
        this(); // calls Node()

        if (arr == null || arr.length == 0)
            return;

        this.value = arr[0];
        Node<T> current = this;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node<>(arr[i]);
            current = current.next;
        }

        this.tail = current; // store last node
        this.size = arr.length;
    }

    public int size(){
        return this.size;
    }


    public final Helper Helper = new Helper();

    public class Helper {

        public int length(){
            Node<T> pos = Node.this;
            int count = 0;
            while (pos != null){
                pos = pos.next;
                count++;
            }
            return count;
        }

        // Add single element at front (mutates Node.this)
        public void add(T x) {
            Node<T> newNode = new Node<>(Node.this.getValue(), Node.this.getNext());
            Node.this.setValue(x);
            Node.this.setNext(newNode);
            Node.this.size++;
        }

        // Add array of elements at front (preserve order)
        public void add(T[] arr) {
            for (int i = arr.length - 1; i >= 0; i--) {
                add(arr[i]);
            }
            Node.this.size+=arr.length;
        }

        // Push another Node-based list (like Stack push)
        /*public void push(Node<T> other) {
            Node<T> copy = other.Helper.copy();
            int sz = copy.Helper.size();
            for (int i = sz - 1; i >= 0; i--) {
                add(copy.Helper.get(i));
            }
        }*/


        // Get value at index
        public T getValue(int index) {
            Node<T> node = Node.this;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node.getValue();
        }

        public Node<T> get(int index){
            Node<T> node = Node.this;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node;
        }

        // Copy nodes from startIndex to endIndex (exclusive)
        public Node<T> copy(int startIndex, int endIndex) {
            Node<T> copyHead = null;
            for (int i = endIndex - 1; i >= startIndex; i--) {
                copyHead = new Node<>(getValue(i), copyHead);
            }
            return copyHead;
        }

        public Node<T> copy(int endIndex) {
            return copy(0, endIndex);
        }

        public Node<T> copy() {
            return copy(size());
        }

        // Copy reverse
        public Node<T> copyReverse(int startIndex, int endIndex) {
            Node<T> copyHead = null;
            for (int i = startIndex; i < endIndex; i++) {
                copyHead = new Node<>(getValue(i), copyHead);
            }
            return copyHead;
        }

        public Node<T> copyReverse(int endIndex) {
            return copyReverse(0, endIndex);
        }

        public Node<T> copyReverse() {
            return copyReverse(size());
        }

        //get bottom value
        public T getBottom() {
            return Node.this.tail.getValue();
        }

        // Get bottom Node
        public Node<T> getLast() {
            return Node.this.tail;
        }
    }




}