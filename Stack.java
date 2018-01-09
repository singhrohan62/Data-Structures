import  java.util.*;

class Stack{
  
  private int top=-1;
  private int maxSize;
  private int[] stackArray;
  
  public Stack(int s){
    maxSize = s;
    stackArray = new int[maxSize];
    
  }
  
  public void push(int d){
    if(top==maxSize-1)
    System.out.println("Overflow!");
    else
    top = top + 1;
    stackArray[top] = d;
    
  }
  
  public int pop(){
    if(top==-1){
    System.out.println("Underflow!");
    return -1;
    }
    return stackArray[top--];
  }
  
  public int peep(){
    if(top==-1){
    System.out.println("No element exists!");
    return -1;
    }
    return stackArray[top];
  }
  
  public boolean isEmpty(){
    return (top == -1);
  }
  
  public boolean searchifExists(int d){
  int i=0;
  while(i<=top){
    if(stackArray[i]==d){
      System.out.println("Yes, the number exists and its index is : "+i);
    return true;
    }
    else
      i++;    
  }
    return false;
 }
  public void display(){
  int i;
  for(i=0;i<=top;i++){
    System.out.print(stackArray[i] + " ");
  }
}
  
}



class test{
  
  public static void main(String args[]){
    Scanner ip = new Scanner(System.in);
    Stack obj = new Stack(5);
    System.out.println("[1].Enter 1 to push in the stack.");
    System.out.println("[2].Enter 2 to pop from the stack.");
    System.out.println("[3].Enter 3 to peep in the stack.");
    System.out.println("[4].Enter 4 to display elements in the stack.");
    System.out.println("[5].Enter 5 to find if a number exists in the stack.");
    System.out.println("[6].Enter 6 to exit.");
    int v,res;
    while(true){
       res = ip.nextInt();    
       switch(res){
           case 1:
           obj.push(v = ip.nextInt());
           break;
           
           case 2:
           System.out.println(obj.pop());          
           break;
           
           case 3:
           System.out.println(obj.peep());          
           break;
           
           case 4:
          obj.display();
    	 	   break;
    	 	 
           case 5:
           System.out.println(obj.searchifExists(v = ip.nextInt()));
           break;

    	   case 6:
    	   break;
    	   
    	   default:
    	   System.out.println("You entered a wrong input !");
    	   
       }
       
       if(res==6)
       break;
    }
       
  }
} 

