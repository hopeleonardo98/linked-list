package esperanca;

import java.util.Optional;

public class LinkedList<T> {
    private Node<T> head;
    private final int FIRST_ELEMENT = 0;
    private final int NOT_FOUND = -1;
    private static int size = 0;

    public LinkedList() {
        this.head = null;
    }

    public int lastIndexOf(Node<T> node) {
        if (isNotEmpty()) {
            int count = 0;
            int index = 0;
            Node<T> aux = this.head;

            while (count < size) {
                if (aux.equals(node)) {
                    index = count;
                }
                else {
                    aux = aux.getNext();
                }
                count++;
            }
            return index;
        }
        return NOT_FOUND;
    }
    public int firstIndexOf(Node<T> node) {
        if (isNotEmpty()) {
            int index = 0;
            Node<T> aux = this.head;

            while (index < size) {
                if (aux.equals(node)) {
                    return index;
                }
                else {
                    aux = aux.getNext();
                }
                index++;
            }
        }
        return NOT_FOUND;
    }

    public void removeByIndex(int index) {
        if (isNotEmpty() && validIndex(index)) {
            if (index == FIRST_ELEMENT) {
                removeFirst();
            }
            else if (index == size-1) {
                removeLast();
            }
            else {
                Node<T> aux = this.head.getNext();
                Node<T> previous = this.head;
                int count = 1;

                while (count <= index) {
                    if (index == count) {
                        previous.setNext(aux.getNext());
                    }
                    else {
                        previous = aux;
                        aux = aux.getNext();
                    }
                    count++;
                }
            }
            size--;
        }
    }

    public void addByIndex(Node<T> node, int index) {
        if (isNotEmpty() && validIndex(index)) {
            if (index == FIRST_ELEMENT) {
                addFirst(node);
            }
            else {
                Node<T> aux = this.head.getNext();
                Node<T> previous = this.head;
                int count = 1;

                while (count <= index) {
                    if (index == count) {
                        node.setNext(previous.getNext());
                        previous.setNext(node);
                    }
                    else {
                        previous = aux;
                        aux = aux.getNext();
                    }
                    count++;
                }
            }
            size++;
        }
    }

    public Optional<Node<T>> getByIndex(int index) {
        if (isNotEmpty() && validIndex(index)) {
            if (index == FIRST_ELEMENT) {
                return getFirst();
            }
            else if (index == size-1) {
                return getLast();
            }
            else {
                Node<T> aux = this.head.getNext();
                int count = 1;

                while (aux.getNext() != null) {
                    if (index == count) {
                        return Optional.of(aux);
                    }
                    else {
                        aux = aux.getNext();
                        count++;
                    }
                }
            }
        }
        return Optional.empty();
    }

    private boolean validIndex(int index) {
        return ((index >= 0) && (index < size));
    }

    public int getSize() {
        return size;
    }

    public void removeFirst() {
        if (isNotEmpty()) {
            this.head = this.head.getNext();
            size--;
        }
    }

    public void removeLast() {
        if (isNotEmpty()) {
            Node<T> aux = this.head;
            Node<T> previous = this.head;

            while (aux.getNext() != null) {
                previous = aux;
                aux = aux.getNext();
            }
            previous.setNext(null);
            size--;
        }
    }
    public Optional<Node<T>> getFirst() {
        return isNotEmpty() ? Optional.of(this.head) : Optional.empty();
    }

    public Optional<Node<T>> getLast() {
        if (isNotEmpty()) {
            Node<T> aux = this.head;

            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            return Optional.of(aux);
        }
        else {
            return Optional.empty();
        }
    }

    public void addFirst(Node<T> node) {
        if (isEmpty()) {
            this.head = node;
            this.head.setNext(null);
        }
        else {
            node.setNext(this.head);
            this.head = node;
        }
        size++;
    }

    public void addLast(Node<T> node) {
        if (isEmpty()) {
            this.head = node;
            this.head.setNext(null);
        }
        else {
            Node<T> aux = this.head;

            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(node);
            aux.getNext().setNext(null);
        }
        size++;
    }

    public void print() {
        if (isNotEmpty()) {
            Node<T> aux = this.head;

            System.out.println(aux.getValue());
            while (aux.getNext() != null) {
                aux = aux.getNext();
                System.out.println(aux.getValue());
            }
        }
        else {
            System.out.println("List is empty");
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean isNotEmpty() {
        return this.head != null;
    }
}
