public class ArrayQueue<E> {
    // Instance vars
    private int capacity;
    private E[] data;
    private int size = 0;
    private int f = 0;

    // Constructors 
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }
    public ArrayQueue() {
        capacity = 1000;
        data = (E[]) new Object[capacity];
    }

    // Methods
    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        return data[f];
    }

    // New front = (front + 1) % length
    public E dequeue() { // O(1)
        if (isEmpty()) {
            return null;
        }
        E temp = data[f];
        data[f] = null;
        f = (f + 1) % data.length; // re-adjust front
        size--;
        return temp;
    }

    // New rear = (front + size) % length
    public void enqueue(E e) { // O(1)
        if (size == data.length) {
            E[] temp = (E[]) new Object[data.length * 2];
            int curFront = f;
            for (int k = 0; k < size; k++) {
                temp[k] = data[curFront % data.length];
                curFront++;
            }
            f = 0;
            data = temp;
        }
        data[(f + size) % data.length] = e; // Add data to rear
        size++;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            int curFront = f;
            for (int k = 0; k < size - 1; k++) {
                System.out.print(data[curFront % data.length] + ", ");
                curFront++;
            }
            System.out.println(data[curFront % data.length] + "]");
        }
    }
    public static void main(String[] args) {
        ArrayQueue<Integer> test = new ArrayQueue<>();
        test.enqueue(0);
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        test.dequeue();
        test.print();
    }
}
