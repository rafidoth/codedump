import java.util.Scanner;

public class CircularLinkedList {
    Node head = null;
    int size = 0;

    static class Node {
        int data;
        Node next = null;

        public Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    void addFront(int value) {
        Node tempNode = new Node(value);
        if (head == null) {
            head = tempNode;
            head.next = head;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            tempNode.next = head;
            last.next = tempNode;
            head = tempNode;
        }
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
            for (int j = 1; j < pos - 1; j++) {
                i = i.next;
            }
            if (i == null) {
                System.out.println("Invalid Operation");
                return;
            }
            newNode.next = i.next;
            i.next = newNode;
            size++;
        }
    }

    void addLast(int value) {
        Node tempNode = new Node(value);
        if (head == null) {
            head = tempNode;
            head.next = head;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = tempNode;
            tempNode.next = head;
        }
        size++;
    }

    int deleteFirst() {
        if (head == null) {
            return -1;
        }
        int val = head.data;
        if (head.next == head) {
            head = null;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
        }
        size--;
        return val;
    }

    int deleteLast() {
        if (head == null) {
            return -1;
        }
        int val;
        Node tempNode = head;
        if (head.next == head) {
            val = head.data;
            head = null;
        } else {
            while (tempNode.next.next != head) {
                tempNode = tempNode.next;
            }
            val = tempNode.next.data;
            tempNode.next = head;
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
            for (int i = 1; i < pos - 1; i++) {
                tempNode = tempNode.next;
            }
            val = tempNode.next.data;
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
            Node tempNode = head;
            do {
                tempNode = tempNode.next;
            } while (tempNode.next != head);
            tempNode.data = newValue;
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
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node tempNode = head;
        do {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        } while (tempNode != head);
        System.out.println();
    }

    int getSize() {
        return this.size;
    }

    boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CircularLinkedList cll = new CircularLinkedList();
        int choice;
        do {
            System.out.println("Press 0 to show menu");

            choice = in.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Circular Linked List\nSelect options");
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
                    System.out.println("12: Quit");
                    break;
                case 1:
                    cll.addFront(in.nextInt());
                    break;
                case 2:
                    cll.addLast(in.nextInt());
                    break;
                case 3:
                    cll.addAny(in.nextInt(), in.nextInt());
                    break;
                case 4:
                    cll.deleteFirst();
                    break;
                case 5:
                    cll.deleteLast();
                    break;
                case 6:
                    cll.deleteAny(in.nextInt());
                    break;
                case 7:
                    cll.updateFirst(in.nextInt());
                    break;
                case 8:
                    cll.updateLast(in.nextInt());
                    break;
                case 9:
                    cll.updateAny(in.nextInt(), in.nextInt());
                    break;
                case 10:
                    cll.display();
                    break;
                case 11:
                    System.out.println(cll.isEmpty());
                    break;
                case 12:
                    in.close();
                    return;
                default:
                    System.out.println("Invalid input");
            }

        } while (choice != 12);

        in.close();

    }
}
