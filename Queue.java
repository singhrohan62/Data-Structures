import java.util.*;

class queuell{

	Node head;
	Node rear;
	
	static class Node{
		int data;
		Node next;
		//int size = -1;

		Node(int d){
			data = d;
			next = null;
		}
	}

	public void enque(int d){
		Node newNode = new Node(d);
		newNode.next = rear;
		rear = newNode; 
		
	}

	public void deque(){
			head = head.next;		
	}

	public void display(){
		Node tmp = head;
		while(tmp.next!=null){
			System.out.println(tmp.data);
		}
	}

	public static void main(String[] args) {
		queuell obj = new queuell();

		obj.enque(3);
		obj.enque(4);
		obj.enque(5);
		obj.display();
		obj.deque();
		obj.deque();
	}

}