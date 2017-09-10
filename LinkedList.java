import java.util.*;

class LinkedList{

	Node head;

	static class Node{
		int data;
		Node next;

		Node(int d){
			data = d;
			next = null;
		}

	}

	public void addtofront(int d){
		Node temp = new Node(d);
			temp.next = head;
			head = temp;
	}

	public void addtorear(int d){
		Node newNode = new Node(d);
		Node temp = head;
		while(temp.next!=null)
			temp = temp.next;
		temp.next = newNode;
	}

	public void traverse(){

		Node temp = head;
		while(temp!=null){
			System.out.println(temp.data+" ");
			temp = temp.next;
		}
	}


	public void removefront(){
		head = head.next;
	}

	public void removerear(){
		Node temp = head;
		while(temp.next.next!=null)
			temp = temp.next;
			temp.next = null;
	}

	public void addtoindex(int index,int d){
		if(index==0){
			Node temp = new Node(d);
			temp.next = head;
			head = temp;
		}
		else{
			
		}
	}

	public void reverse(){
		Node prev = null;
		Node nex = null;
		Node curr = head;
		while(curr!=null){
			nex = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nex;
		}
		head = prev;
	}
	
	public void removedata(int d){
	
	  Node prevNode = head;
	  if(head.data==d)
	  {
	    head = head.next;
	  }
	  while(prevNode.next!=null)
	  {	     
	     if(prevNode.next.data==d)
	     prevNode.next = prevNode.next.next;
	     else
	     prevNode = prevNode.next;	  
	  }
	  
	 // if(prevNode.next==null && prevNode.data==d)
	  //removerear();
	
	}

	  public void swap(int a,int b){
	  	 Node preva = null;
	  	 Node curra = head;
	  	 

	  	 if(a==b) return ;

	  	 while(curra != null && curra.data!=a){
	  	 	preva = curra;
	  	 	curra = curra.next;
	  	 }

	  	 Node prevb = null;
	  	 Node currb = head;

	  	 while(currb != null && currb.data != b){
	  	 	prevb = currb;
	  	 	currb = currb.next;
	  	 }

	  	 if(curra== null||currb==null) return;

	  	 if(preva!=null){
	  	 	preva.next = currb;
	  	 }
	  	 else
	  	 	head = curra;
	  	 if(prevb!=null){
	  	 	prevb.next = curra;
	  	 }
	  	 else
	  	 	currb = head;

	  	 Node temp = curra.next;
	  	 curra.next = currb.next;
	  	 currb.next = temp;

	  }

	public static void main(String[] args) {
		LinkedList LList = new LinkedList();
		Scanner ip = new Scanner(System.in);
		/*LList.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		LList.head.next = second;
		second.next = third;*/

		System.out.println("[1].Enter 1 to add element in front.");
		System.out.println("[2].Enter 2 to add element in rear.");
		System.out.println("[3].Enter 3 to display all elements.");
		System.out.println("[4].Enter 4 to remove an element in front.");
		System.out.println("[5].Enter 5 to remove an element in rear.");
		System.out.println("[6].Enter 6 to exit.");
		System.out.println("[7].Enter 7 to remove an element if data is given.");
		System.out.println("[8].Enter 8 to reverse the linked list.");
		System.out.println("[9].Enter 9 to swap two nodes.");
		int op,v,v2;
		while(true){
			op = ip.nextInt();

			switch(op){
				case 1:
				LList.addtofront(v=ip.nextInt());
				break;

				case 2:
				LList.addtorear(v=ip.nextInt());
				break;

				case 3:
				LList.traverse();
				break;

				case 4:
				LList.removefront();
				break;

				case 5:
				LList.removerear();

				case 6:
				break;
				
				case 7:
				System.out.println("Enter the number : ");				
				LList.removedata(v = ip.nextInt());
				break;				

				case 8:
				LList.reverse();
				LList.traverse();
				break;
				
				case 9:
				System.out.println("Enter the numbers : ");
				LList.swap(v=ip.nextInt(),v2=ip.nextInt());
				LList.traverse();
				//System.out.println("Error in method!");
				break;

				default:
				System.out.println("You entered a wrong option");
				break;
			}
			   if(op==6)
			   	break;
		}
		

	}



}
