
import java.util.*;


public class ArrayList1{

	public static void main(String args[]){
		int arr[]=new int[100];
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the size of Array");
		int size = scan.nextInt();
		if(size>100 || size<0){
			System.out.println("Array size incompatible");
			return;
			}
		System.out.println("Enter the numbers");
		
		for(int i=0;i<size;i++)	
			arr[i] = scan.nextInt();
		
		ArrayFunction1 a = new ArrayFunction1(arr,size);
		int c=1;
		while(c==1){
		
			System.out.println("1. Add to Front");
			System.out.println("2. Add to Rear");
			System.out.println("3. Add in between");
			System.out.println("4. Size");
			System.out.println("5. Check whether empty");
			System.out.println("6. Delete front");
			System.out.println("7. Delete rear");
			System.out.println("8. Delete in between");
			System.out.println("9. Display");
			System.out.println();
			
			int select = scan.nextInt();
			int element,position;

		
			switch(select){
				case 1: System.out.println("Enter the number to add to front");
					element = scan.nextInt();
					a.addToFront(element);
					a.display();
					break;
				case 2: System.out.println("Enter the element to add to rear");
					element = scan.nextInt();
					a.addToRear(element);
					a.display();
					break;
				case 3: System.out.println("Enter the index to add");
					position = scan.nextInt();
					System.out.println("Enter the number to add");
					element = scan.nextInt();
					a.add(position,element);
					a.display();
					break;
				case 4: System.out.println("The size of array is "+a.size());
					break;
				case 5: if(a.isEmpty())
						System.out.println("Array is empty");
					else 
						System.out.println("Array is not empty");
					break;
				case 6: System.out.println("The number deleted was: "+a.deleteFront());
					a.display();
					break;
				case 7: System.out.println("The number deleted was: " +a.deleteRear());
					a.display();
					break;
				case 8: System.out.println("Enter the index to delete");
					position = scan.nextInt();
					System.out.println("The number deleted was: "+a.delete(position));
					a.display();
					break;
				case 9: a.display();
					break;
				default: System.out.println("Unrecognized operation");	
			}
			System.out.println();
			System.out.println("Press 1 to continue or 0 to exit");
			c = scan.nextInt();
					
		}
		
	
	}

}

