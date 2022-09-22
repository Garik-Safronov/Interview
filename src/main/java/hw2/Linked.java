package hw2;

public class Linked<E> {

    private Node<E> firstElement;
    private Node<E> lastElement;
    private int size;

    static class Node<E> {
        E item;
        Node<E> next;
        Node<E> previous;

        public Node(E item, Node<E> previous, Node<E> next) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    public void add(E value) {
        Node<E> last = lastElement;
        Node<E> newNode = new Node<>(value, null, null);
        lastElement = newNode;
        if (last == null){
            firstElement = newNode;
        } else {
            last.next = newNode;
        }
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }
        current.next = null;
        size--;
        return true;
    }

    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}