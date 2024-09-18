class ArraySet {
    private Object[] set;
    private int size;
    private int capacity;

    public ArraySet(int capacity) {
        this.capacity = capacity;
        set = new Object[capacity];
        size = 0;
    }

    public void add(Object element) {
        if (contains(element)) {
            System.out.println("Элемент уже присутствует в множестве.");
            return;
        }

        if (size == capacity) {
            System.out.println("Множество переполнено! Невозможно добавить элемент.");
        } else {
            set[size++] = element;
        }
    }

    public void delete(Object element) {
        int index = indexOf(element);
        if (index == -1) {
            System.out.println("Элемент не найден в множестве.");
        } else {
            for (int i = index; i < size - 1; i++) {
                set[i] = set[i + 1];
            }
            set[size--] = null;
        }
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    private int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (set[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Множество пусто.");
        } else {
            System.out.print("Элементы множества: ");
            for (int i = 0; i < size; i++) {
                System.out.print(set[i] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArraySet set = new ArraySet(10);

        set.add("Первый");
        set.add("Второй");
        set.add("Третий");

        set.print();

        set.add("Второй");

        set.delete("Второй");
        set.print();

        System.out.println("Множество содержит 'Первый'? " + set.contains("Первый"));
        System.out.println("Множество содержит 'Второй'? " + set.contains("Второй"));

        System.out.println("Множество пусто? " + set.isEmpty());

        set.delete("Первый");
        set.delete("Третий");

        System.out.println("Множество пусто? " + set.isEmpty());
    }
}
