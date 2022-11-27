
public class LinkedList {
	Node head;
	Node tail;
	private int size;
	
	class Node{
		int data;
		Node next;
	}

	public int getLength() {
		return size;
	}
	public void add(int data) {
		Node n = new Node();
		n.data = data;
	 if (head == null && tail == null) {
		 head=n;
		 tail=n;
//		 tail.next = null;
	 }
	 else {
		 tail.next = n;
		 tail = tail.next;
	 }
	}
	public void removeFront() {
		if (head == null || tail == null) {
			System.out.println("List is empty");
		}
		else {
			head = head.next;
		}
	}
}
