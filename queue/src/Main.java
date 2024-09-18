class ArrayQueue {
    private Object[] queue;
    private int size;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        size = 0;
    }

    public void enqueue(Object element) {
        if (size == capacity) {
            System.out.println("Очередь переполнена");
        } else {
            queue[size++] = element;
        }
    }

    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return null;
        } else {
            Object firstElement = queue[0];
            for (int i = 1; i < size; i++) {
                queue[i - 1] = queue[i];
            }
            queue[size--] = null;
            return firstElement;
        }
    }

    public Object first() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return null;
        } else {
            return queue[0];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Очередь пуста.");
        } else {
            System.out.print("Элементы очереди: ");
            for (int i = 0; i < size; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue("Первый");
        queue.enqueue(2);
        queue.enqueue(3.14);

        queue.print();

        System.out.println(queue.first());

        System.out.println(queue.dequeue());

        queue.print();

        System.out.println(queue.isEmpty());
    }
}
