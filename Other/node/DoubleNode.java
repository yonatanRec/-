package Other.node;

public class DoubleNode<T> {
    private T value;
    private DoubleNode<T> right;
    private DoubleNode<T> left;

    // Constructors
    public DoubleNode(T value) {
        this.value = value;
        this.right = null;
        this.left = null;


    }

    public DoubleNode(T value, DoubleNode<T> right, DoubleNode<T> left) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    // Empty node constructor
    public DoubleNode() {
        this.value = null;
        this.right = null;
        this.left = null;
    }

    // Getters
    public T getValue() {
        return this.value;
    }

    public DoubleNode<T> getRight() {
        return this.right;
    }

    public DoubleNode<T> getLeft() {
        return this.left;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasLeft() {
        return left != null;
    }

    // Setters
    public void setValue(T value) {
        this.value = value;
    }

    public void setRight(DoubleNode<T> right) {
        this.right = right;
    }

    public void setLeft(DoubleNode<T> left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return value + "";
    }

    public String fullStringForward() {
        return value + (hasRight() ? " ⇄ " + right.fullStringForward() : "");
    }

    public String fullStringBackward() {
        return value + (hasLeft() ? " ⇄ " + left.fullStringBackward() : "");
    }

    // ================= HELPER =================

    public final Helper Helper = new Helper();

    public class Helper {

        // Add element at front (mutates DoubleNode.this)
        public void add(T x) {
            DoubleNode<T> newNode =
                    new DoubleNode<>(DoubleNode.this.value,
                            DoubleNode.this.right,
                            DoubleNode.this);

            if (DoubleNode.this.right != null)
                DoubleNode.this.right.left = newNode;

            DoubleNode.this.value = x;
            DoubleNode.this.right = newNode;
        }

        // Get size of list
        public int size() {
            int count = 1;
            DoubleNode<T> node = DoubleNode.this;
            while (node.hasRight()) {
                count++;
                node = node.right;
            }
            return count;
        }

        // Get value at index
        public T getValue(int index) {
            DoubleNode<T> node = DoubleNode.this;
            for (int i = 0; i < index; i++) {
                node = node.right;
            }
            return node.value;
        }

        public DoubleNode<T> get(int index) {
            DoubleNode<T> node = DoubleNode.this;
            for (int i = 0; i < index; i++) {
                node = node.right;
            }
            return node;
        }

        // Get last node
        public DoubleNode<T> last() {
            DoubleNode<T> node = DoubleNode.this;
            while (node.hasRight()) {
                node = node.right;
            }
            return node;
        }

        // Get bottom value
        public T bottom() {
            return last().value;
        }
    }
}
