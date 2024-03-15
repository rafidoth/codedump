import java.util.ArrayList;
import java.util.Scanner;

public class LinkedList {
	Node head = null;
	int size = 0;
	static class Node{
		int data;
		Node next = null;
		
		public Node(int value) {
			this.data = value;
			this.next = null;
		}
	}
	
	void addFront(int value) {
		Node tempNode = new Node(value);
		tempNode.next = head;
		head = tempNode;
		size++;
	}
	
	void addAny(int value, int pos) {
		if(pos<1) {
			return;
		}else if(pos == 1) {
			addFront(value);
			return;
		}else {
			Node i = head;
			Node newNode = new Node(value);
			while(--pos > 1) {
				if(i==null) {
					System.out.println("Invalid Operation");
					return;
				}
				i = i.next;
			}
			newNode.next = i.next;
			i.next = newNode;
			size++;
		}
	}
	
	void addLast(int value) {
		Node newNode = new Node(value);
		Node i = head;
		if(i==null) {
			head = newNode;
		}else {
			while(i.next!=null) {
				i=i.next;
			}
			i.next = newNode;
		}
		size++;
	}
	
	int deleteFirst() {
		int val = head.data;
		if(head!=null) {
			head = head.next;
		}
		return val;
	}
	
	int deleteLast() {
		if(head == null) {
			return -1;
		}
		int val = head.data;
		if(head.next == null) {
			head = null;
		}else {
			Node tempNode =head;
			while(tempNode.next.next!=null) {
				tempNode= tempNode.next;
			}
			val = tempNode.next.data;
			tempNode.next =null;
		}
		
		return val;
	}
	
	int deleteAny(int pos) {
		int val;
		if(pos ==1) {
			val = deleteFirst();
		}else {
			Node tempNode = head;
			for(int i = 2; i<pos;i++) {
				tempNode = tempNode.next;
			}
			val = tempNode.next.data;
			tempNode.next = tempNode.next.next;
		}
		return val;
		
	}
	
	void updateFirst(int newValue) {
		head.data = newValue;
	}
	void updateLast(int newValue) {
		if(head!=null) {
			Node i = head;
			while(i.next != null) {
				i= i.next;
			}
			i.data = newValue;
		}
	}
	
	void updateAny(int val, int pos) {
		if(pos==1) {
			updateFirst(val);
		}else {
			Node j = head;
			for(int i= 1;i<pos;i++) {
				j = j.next;
			}
			j.data = val;
		}
	}
	
	void display() {
		Node tempNode = head;
		while(tempNode!=null) {
			System.out.print(tempNode.data+ " ");
			tempNode = tempNode.next;
		}
		System.out.println();
	}
	
	int getSize() {
		return this.size;
	}
	
	boolean isEmpty() {
		if(head==null) {
			return true;
		}else return false;
	}
	
	void reverseLinkedList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Node iNode = head;
		while(iNode!=null) {
			list.add(iNode.data);
			iNode = iNode.next;
		}
		for(int i = list.size()-1;i>=0;i--) {
			System.err.print(list.get(i)+ " ");
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedList ll = new LinkedList() ;
		int choice;
		do {
			System.out.println("Press 0 to show menu");
			
			choice = in.nextInt();
			switch(choice) {
			 	case 0:
			 		System.out.println("Singly Linked List\nSelect options");
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
					ll.addFront(in.nextInt());
					break;
				case 2:
					ll.addLast(in.nextInt());
					break;
				case 3:
					ll.addAny(in.nextInt(), in.nextInt());
					break;
				case 4: 
					ll.deleteFirst();
					break;
				case 5:
					ll.deleteLast();
					break;
				case 6:
					ll.deleteAny(in.nextInt());
					break;
				case 7:
					ll.updateFirst(in.nextInt());
					break;
				case 8:
					ll.updateLast(in.nextInt());
					break;
				case 9:
					ll.updateAny(in.nextInt(), in.nextInt());
					break;
				case 10:
					ll.display();
					break;
				case 11:
					System.out.println(ll.isEmpty());
					break;
				case 12:
					ll.reverseLinkedList();
					break;
				case 13: 
					in.close();
					return;
				default: System.out.println("Invalid input");
			}
			
		}while(choice!=13);
		
		in.close();
		
	}
}
