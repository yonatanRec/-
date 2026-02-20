package Other.stack;

import Other.node.Node;

public class Stack<T> {

    private Node<T> first;

    public Stack()
    {
        this.first = null;
    }

    public Stack(T[] x){
        this.first = new Node<>(x);
    }

    public Stack(T x){
        this.first = new Node<>(x);
    }

    public boolean isEmpty()
    {
        return this.first == null;
    }

    public void push(T x)
    {
        this.first = new Node<>(x, this.first);
    }



    public T pop()
    {
        T x = this.first.getValue();
        this.first = this.first.getNext();
        return x;
    }

    public T top()
    {
        return this.first.getValue();
    }



    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("top -> ");
        Node<T> pos = this.first;
        while (pos != null)
        {
            str.append(pos.getValue()).append(" ");
            pos = pos.getNext();
        }
        return str.toString();
    }








    public final Helper Helper =  new Helper();
    public class Helper{
        public void push(T[] arr){
            for (T item: arr)
                Stack.this.push(item);
        }

        public void push(Stack<T> stack){
            Stack<T> copy = stack.Helper.copy();
            for (int i = copy.Helper.size() - 1; i >= 0; i--) {
                Stack.this.push(copy.Helper.get(i));
            }
        }

        public int size(){
            int size = 0;
            Node<T> node = Stack.this.first;
            while(node.hasNext()){
                size++;
                node = node.getNext();
            }
            return size;
        }

        public T get(int index){
            Node<T> node = Stack.this.first;
            for(int i = 0; i < index; i++){
                node = node.getNext();
            }
            return node.getValue();
        }

        public Stack<T> copy(){
            return copy(size());
        }

        public Stack<T> copy(int endIndex){
            return copy(0,endIndex);
        }

        public Stack<T> copy(int startIndex, int endIndex){
            Stack<T> copy = new Stack<>();
            for (int i = endIndex - 1; i >= startIndex; i--) {
                copy.push(get(i));
            }
            return copy;
        }

        public Stack<T> copyReverse() {
            return copyReverse(size());
        }

        public Stack<T> copyReverse(int endIndex) {
            return copyReverse(0, endIndex);
        }

        public Stack<T> copyReverse(int startIndex, int endIndex) {
            Stack<T> copy = new Stack<>();
            for (int i = startIndex; i < endIndex; i++) {
                copy.push(get(i));
            }
            return copy;
        }

        public T bottom(){
            return get(Stack.this.Helper.size() - 1);
        }

        public void insert(T item, int index) {
            Stack<T> temp = copy(index,size());
            temp.push(item);
            temp.Helper.push(copy(index));
            first = temp.first;

        }
    }
}