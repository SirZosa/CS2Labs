public class Node<T> {
    Object data;
    Node<T> next;

    // Constructor for a new node
    Node(Object data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}