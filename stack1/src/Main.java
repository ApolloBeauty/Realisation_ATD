class ObjectStack {
    private Object[] stack;
    private int size;
    private int capacity;

    public ObjectStack(int capacity) {
        this.capacity = capacity;
        stack = new Object[capacity];
        size = 0;
    }

    public void push(Object element) {
        if (size == capacity) {
            System.out.println("Стек переполнен");
        } else {
            stack[size++] = element;
        }
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Стек пуст");
            return null;
        } else {
            Object element = stack[--size];
            stack[size] = null;
            return element;
        }
    }

    public Object last() {
        if (isEmpty()) {
            System.out.println("Стек пуст!");
            return null;
        } else {
            return stack[size - 1];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Стек пуст.");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        ObjectStack stack = new ObjectStack(5);

        stack.push("Первый");
        stack.push(2);
        stack.push(3.14);

        stack.print();  // 2 3.14 

        System.out.println(stack.last());  // 3.14

        System.out.println(stack.pop());  // 3.14

        stack.print();  // Первый 2 

        System.out.println(stack.isEmpty());  // false
    }
}
