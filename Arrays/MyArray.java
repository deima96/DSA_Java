package Arrays;

import java.util.Arrays;

class MyArray {
    private int size;
    private Object[] data;
    private int capacity;

    MyArray() {
        size = 0;
        capacity = 1;
        data = new Object[1];
    }

    public Object get(int index) {
        return data[index];
    }

    public void push(Object value) {
        if (capacity == size) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity *= 2;
        }
        data[size] = value;
        size++;
    }

    public Object pop() {
        Object pop_data = data[size - 1];
        size--;
        return pop_data;
    }

    public Object delete(int index) {
        Object delete_data = data[index];
        shiftItems(index);

        return delete_data;
    }

    public void shiftItems(int index) {

        while (index < size - 1) {
            data[index] = data[index + 1];
            index++;
        }

        data[size - 1] = null;
        size--;
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArray arr = new MyArray();
        arr.push(1);
        arr.push(2);

        System.out.println(arr.size);
        System.out.println(arr.capacity);

        arr.printArray();
        arr.delete(1);
        arr.printArray();
    }
}