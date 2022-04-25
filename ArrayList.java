public class ArrayList<E> {
    // Instance vars
    private int capacity;
    public E[] data;
    public int size = 0;

    // Constructors
    public ArrayList(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }
    public ArrayList() {
        capacity = 16;
        data = (E[]) new Object[capacity];
    }

    // Methods
    public int size() {
        return size;
    }

    public E get(int i) {
        return data[i];
    }

    public void set(int i, E e) {
        data[i] = e;
    }

    public void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal Index: " + i);
        }
    }

    public void add(int i, E e) { // O(n)
        checkIndex(i, size + 1);
        if (size == data.length) {
            E[] temp = (E[]) new Object[data.length * 2];
            for (int k = 0; k < size; k++) {
                temp[k] = data[k];
            }
            data = temp;
        }
        for (int k = size - 1; k > i - 1; k--) {
            data[k + 1] = data[k];
        }
        data[i] = e;
        size++;
    }

    public void remove(int i) { // O(n)
        checkIndex(i, size);
        for (int k = i; k < size - 1; k++) {
            data[k] = data[k + 1];
        }
        data[size - 1] = null;
        size--;
    }

    public void push(E e) { // WORST: O(n), AVG O(1)
        if (size == data.length) {
            E[] temp = (E[]) new Object[data.length * 2];
            for (int k = 0; k < size; k++) {
                temp[k] = data[k];
            }
            data = temp;
        }
        data[size] = e;
        size++;
    }
    public void print() {
        System.out.print("[");
        for (int k = 0; k < size - 1; k++) {
            System.out.print(data[k] + ", ");
        }
        System.out.println(data[size - 1] + "]");
    }
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(0, 0);
        test.push(1);
        test.remove(1);
        test.print();
    }
}