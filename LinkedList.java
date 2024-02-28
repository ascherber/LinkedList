public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
    }

    public void add(T data) {
        if (head == null) { // If list is empty
            head = new Node<>(data);
        } else {
            Node<T> curr = head;

            while (curr.getNext() != null) { // Iterate to the last node
                curr = curr.getNext();
            }

            curr.setNext(new Node<>(data)); // Add new node to the end of list
        }

        size++;
    }

    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        if (head != null) {
            node.setNext(head);
        }
        head = node;
        size++;
    }

    public boolean remove(T data) {
        if (head == null) {
            return false;
        }
        if (head.getData() == data) { // To remove the head
            head = head.getNext();
            size--;
            return true;
        }
        Node<T> curr = head;
        while (curr.getNext() != null) { // Iterate to find matching node
            if (curr.getNext().getData() == data) {
                curr.setNext(curr.getNext().getNext());
                size--;
                return true;
            }
            curr = curr.getNext();
        }

        return false;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
            size--;
        } else {
            System.out.println("Empty list");
        }
    }

    public void printList() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + " - ");
            curr = curr.getNext();
        }
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }

        return false;
    }

    public int getSize() {
        return size;
    }
}
