class ArrayList {
    private Object[] list;
    private int size;
    private int capacity;

    public ArrayList(int capacity) {
        this.capacity = capacity;
        list = new Object[capacity];
        size = 0;
    }

    public void insert(int index, Object element) {
        if (size == capacity) {
            System.out.println("Список переполнен");
        } else if (index < 0 || index > size) {
            System.out.println("Неверный индекс.");
        } else {
            for (int i = size; i > index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = element;
            size++;
        }
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Неверный индекс.");
            return null;
        } else {
            Object removedElement = list[index];
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            list[--size] = null;
            return removedElement;
        }
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        if (size == 0) {
            System.out.println("Список пуст.");
        } else {
            System.out.print("Элементы списка: ");
            for (int i = 0; i < size; i++) {
                System.out.print(list[i] + " ");
            }
            System.out.println();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(10);

        list.insert(0, "a");
        list.insert(1, "b");
        list.insert(2, "c");

        list.print();

        list.insert(1, "d");
        list.print();

        list.remove(2);
        list.print();

        int index = list.indexOf("d");
        System.out.println(index);

        System.out.println(list.isEmpty());
    }
}
