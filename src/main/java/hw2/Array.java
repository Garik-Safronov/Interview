package hw2;

public class Array {

    private final int SIZE = 10;
    private Object[] array = new Object[SIZE];
    private int point = 0;

    public void add(Object item) {
        if(point == array.length-1)
            resize(array.length*2);
        array[point++] = item;
    }

    public Object get(int index) {
        return (Object) array[index];
    }

    public void remove(int index) {
        for (int i = index; i < point; i++)
            array[i] = array[i + 1];
        array[point] = null;
        point--;
    }

    private void resize(int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, point);
        array = newArray;
    }
}
