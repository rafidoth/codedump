import java.util.Scanner;

public class DoublyLinkedList {
    Node head = null;
    int size = 0;

    static class Node {
        int data;
        Node next = null;
        Node prev = null;

        public Node(int value) {
            this.data = value;
            this.next = null;
            this.prev = null;
        }
    }

    void addFront(int value) {
        Node tempNode = new Node(value);
        if (head != null) {
            tempNode.next = head;
            head.prev = tempNode;
        }
        head = tempNode;
        size++;
    }

    void addAny(int value, int pos) {
        if (pos < 1) {
            return;
        } else if (pos == 1) {
            addFront(value);
            return;
        } else {
            Node i = head;
            Node newNode = new Node(value);
            while (--pos > 1) {
                if (i == null) {
                    System.out.println("Invalid Operation");
                    return;
                }
                i = i.next;
            }
            newNode.next = i.next;
            newNode.prev = i;
            if (i.next != null) {
                i.next.prev = newNode;
            }
            i.next = newNode;
            size++;
        }
    }

    void addLast(int value) {
        Node newNode = new Node(value);
        Node i = head;
        if (i == null) {
            head = newNode;
        } else {
            while (i.next != null) {
                i = i.next;
            }
            i.next = newNode;
            newNode.prev = i;
        }
        size++;
    }

    int deleteFirst() {
        if (head == null) {
            return -1;
        }
        int val = head.data;
        if (head.next != null) {
            head.next.prev = null;
        }
        head = head.next;
        size--;
        return val;
    }

    int deleteLast() {
        if (head == null) {
            return -1;
        }
        int val;
        Node tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        val = tempNode.data;
        if (tempNode.prev != null) {
            tempNode.prev.next = null;
        } else {
            head = null;
        }
        size--;
        return val;
    }

    int deleteAny(int pos) {
        int val;
        if (pos == 1) {
            val = deleteFirst();
        } else {
            Node tempNode = head;
            for (int i = 2; i < pos; i++) {
                tempNode = tempNode.next;
            }
            val = tempNode.next.data;
            if (tempNode.next.next != null) {
                tempNode.next.next.prev = tempNode;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
        return val;
    }

    void updateFirst(int newValue) {
        if (head != null) {
            head.data = newValue;
        }
    }

    void updateLast(int newValue) {
        if (head != null) {
            Node i = head;
            while (i.next != null) {
                i = i.next;
            }
            i.data = newValue;
        }
    }

    void updateAny(int val, int pos) {
        if (pos == 1) {
            updateFirst(val);
        } else {
            Node j = head;
            for (int i = 1; i < pos; i++) {
                j = j.next;
            }
            j.data = val;
        }
    }

    void display() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    int getSize() {
        return this.size;
    }

    boolean isEmpty() {
        return head == null;
    }

    void reverseLinkedList() {
        Node tempNode = null;
        Node current = head;
        while (current != null) {
            tempNode = current.prev;
            current.prev = current.next;
            current.next = tempNode;
            current = current.prev;
        }
        if (tempNode != null) {
            head = tempNode.prev;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        int choice;
        do {
            System.out.println("Press 0 to show menu");

            choice = in.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Doubly Linked List\nSelect options");
                    System.out.println("1: add element at first");
                    System.out.println("2: add element at the last");
                    System.out.println("3: add element at any position");
                    System.out.println("4: delete from the first");
                    System.out.println("5: delete from the last");
                    System.out.println("6: delete from any index");
                    System.out.println("7: update the front node");
                    System.out.println("8: update the last node");
                    System.out.println("9: update any position");
                    System.out.println("10: Display the list");
                    System.out.println("11: is the array empty?");
                    System.out.println("12: reverse the list");
                    System.out.println("13: Quit");
                    break;
                case 1:
                    dll.addFront(in.nextInt());
                    break;
                case 2:
                    dll.addLast(in.nextInt());
                    break;
                case 3:
                    dll.addAny(in.nextInt(), in.nextInt());
                    break;
                case 4:
                    dll.deleteFirst();
                    break;
                case 5:
                    dll.deleteLast();
                    break;
                case 6:
                    dll.deleteAny(in.nextInt());
                    break;
                case 7:
                    dll.updateFirst(in.nextInt());
                    break;
                case 8:
                    dll.updateLast(in.nextInt());
                    break;
                case 9:
                    dll.updateAny(in.nextInt(), in.nextInt());
                    break;
                case 10:
                    dll.display();
                    break;
                case 11:
                    System.out.println(dll.isEmpty());
                    break;
                case 12:
                    dll.reverseLinkedList();
                    break;
                case 13:
                    in.close();
                    return;
                default:
                    System.out.println("Invalid input");
            }

        } while (choice != 13);

        in.close();

    }
}
