import java.util.*;

 class Node{
 	int data;
 	Node left;
 	Node right;
 	
 	Node(int d){
 		data = d;
 		left = null;
 		right = null;
 	}
 }

 class BinarySearchTree{

 	static Node root;

 	void Insert(int id){
 
 				Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
 			

 	}

 	boolean Find(int n){
 		Node current = root;
 		while(current!=null){
 			if(current.data==n){
 				return true;
 			}
 			else if(current.data>n)
 				current = current.left;
 			else
 				current = current.right;
 		}
 		return false;
 	}

 	 Node deleteRec(Node root, int key)
    {
        if (root == null)  return root;
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
        else
        {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

     int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

 	void Display(Node root){
 		if(root!=null){
			Display(root.left);
			System.out.print(" " + root.data);
			Display(root.right);
		}
 	}

 	void PreDisplay(Node root){
 		if(root!=null){
 			System.out.print(" " + root.data);
			PreDisplay(root.left);			
			PreDisplay(root.right);
		}
 	}

 	void PostDisplay(Node root){
 		if(root!=null){
			PostDisplay(root.left);			
			PostDisplay(root.right);
 			System.out.print(" " + root.data);
		}
 	}

 	void rightRotate(){
 		Node x = root.left;
 		Node y = x.right;
 		x.right = root;
 		root.left = y;
 		root = x;
 	}

 	void leftRotate(){
 		Node x = root.right;
 		Node y = x.left;
 		x.left = root;
 		root.right = y;
 		root = x;
 	}

 	void printLnode(Node node){
 		  /*if(node == null)       
        return;									[BOTH CODES ARE RUNNING SUCCESSFULLY]
       if(node.left == null && node.right==null)      
          System.out.println(node.data); 
       printLnode(node.left); 
       printLnode(node.right); */
 		if(node == null)       
        return;
 		if(node.left!=null||node.right!=null){
 			printLnode(node.left);
 			printLnode(node.right);
 		}
 		else if(node.left==null && node.right==null){
 			System.out.println(node.data+" ");
 		}

 		
 	}

 	public static void main(String[] args) {
 		BinarySearchTree obj = new BinarySearchTree();
 		Scanner ip = new Scanner(System.in);
 		int res,v;
 		System.out.println("Press 1 to insert a node in tree.");
 		System.out.println("Press 2 to search a node in tree.");
 		System.out.println("Press 3 to display tree in Inorder form .");
 		System.out.println("Press 4 to delete a node in tree.");
 		System.out.println("Press 5 to display tree in Preorder form.");
 		System.out.println("Press 6 to display tree in Postorder form.");
 		System.out.println("Press 7 to rotate the tree towards right.");
 		System.out.println("Press 8 to rotate the tree towards left.");
 		System.out.println("Press 9 to exit.");
 		System.out.println("Press 10 to print leaf node.");

 		while(true){

 			res = ip.nextInt();

 			switch(res){
 				case 1:
 				System.out.println("Enter its data : ");
 				obj.Insert(v=ip.nextInt());
 				break;

 				case 2:
 				System.out.println("Enter its data : ");
 				
 				System.out.println(obj.Find(v=ip.nextInt()));
 				break;

 				case 3:
 				obj.Display(root);
 				break;

 				case 4:
 				System.out.println("Enter its data : ");
 				obj.deleteRec(root,v=ip.nextInt());
 				break;

 				case 5:
 				obj.PreDisplay(root);
 				break;

 				case 6:
 				obj.PostDisplay(root);
 				break;

 				case 7:
 				System.out.println("Preorder form of BST before right rotation : ");
 				System.out.println();
 				obj.PreDisplay(root);
 				System.out.println();
 				System.out.println();
 				obj.rightRotate();
 				System.out.println("Preorder form of BST after right rotation : ");
 				System.out.println();
 				obj.PreDisplay(root);
 				break;

 				case 8:
 				System.out.println("Preorder form of BST before left rotation : ");
 				System.out.println();
 				obj.PreDisplay(root);
 				System.out.println();
 				System.out.println();
 				obj.leftRotate();
 				System.out.println("Preorder form of BST after left rotation : ");
 				System.out.println();
 				obj.PreDisplay(root);
 				break;

 				case 9:
 				break;

 				case 10:
 				obj.printLnode(root);
 				break;

 				default:
 				System.out.println("Enter a valid option!");
 			}
 			if(res==9)
 				break;
 		}
 	}

 }