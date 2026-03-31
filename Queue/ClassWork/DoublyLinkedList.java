class DoublyLinkedList {

    // Node class
    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    Node head = null;
    Node tail = null;

    // Insert at front
    public void insertFront(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at rear
    public void insertRear(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Remove from front
    public void removeFront() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) { // only one node
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    // Remove from rear
    public void removeRear() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) { // only one node
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    // Display list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertFront(10);
        dll.insertFront(5);
        dll.insertRear(20);
        dll.insertRear(30);

        System.out.print("List: ");
        dll.display();

        dll.removeFront();
        System.out.print("After removing front: ");
        dll.display();

        dll.removeRear();
        System.out.print("After removing rear: ");
        dll.display();
    }
}