import java.util.*;

class stackLL{

	  public static void main(String args[]){
    Scanner ip = new Scanner(System.in);
    fn obj = new fn();
    System.out.println("[1].Enter 1 to push in the stack.");
    System.out.println("[2].Enter 2 to pop from the stack.");
    System.out.println("[3].Enter 3 to peep in the stack.");
    System.out.println("[4].Enter 4 to display elements in the stack.");
    System.out.println("[5].Enter 5 to exit.");
    int v,res;
    while(true){
       res = ip.nextInt();    
       switch(res){
           case 1:
           obj.push(new Integer(v = ip.nextInt()));
           break;
           
           case 2:
           obj.pop();          
           break;
           
           case 3:
           obj.peek();          
           break;
           
           case 4:
    	 	 obj.display();
    	 	 break;
    	 	 
    	   case 5:
    	   break;
    	   
    	   default:
    	   System.out.println("You entered a wrong input !");
    	 //  break;
       }
       
       if(res==5)
       break;
    }
       
  }

}

class fn{

	Node head;
	int top = -1;
	static class Node{
		Object data;
		Node next;
		int top = -1;

		Node(Object ele){
			data = ele;
			next = null;
		}

	}

	public  void push(Object ele){
		Node newNode = new Node(ele);
		newNode.next = head;
		head =  newNode;		
		top++;
	}

	public void pop(){
		if(top==-1)
		{
			System.out.println("Underflow!");
		}
		 
		 head = head.next;
		 top--;
	}

	public void peek(){
		if(top==-1)
		{
			System.out.println("Underflow!");
		}

		System.out.println(head.data);
	}

	public  void display(){
		Node temp = head;
		//System.out.println(head.data);
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

}