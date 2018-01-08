import java.util.*;

class AVL{

	class Node{
	int data;
	int height;
	Node left;
	Node right;

	  Node(int d){
	  	data = d;
	  	left = null;
	  	right = null;
	  }
	}

	  static Node root;
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		
		AVL obj = new AVL();
		int res,v;
		System.out.println("1.Insert.");
		System.out.println("2.Display.");
		System.out.println("3.Exit.");
		System.out.println("4.Height.");
		System.out.println("5.Preorder Display.");

		while(true){
			res = ip.nextInt();
			switch(res){
				case 1:
				System.out.print("Enter data : ");
				root = obj.insert(root,v=ip.nextInt());
				break;

				case 2:
				obj.Inorder(root);
				break;

				case 3:
				break;

				case 4:
				System.out.println(obj.height(root));
				break;

				case 5:
				obj.Preorder(root);
				break;

				default:
				System.out.println("Enter a valid option!");
			}
			if(res==3)
				break;
		}
	}


public  Node insert(Node node,int d){
		if(node==null)
		 node = new Node(d);

		else if(node.data>d)
			node.left = insert(node.left,d);

		else if(node.data<d)
			node.right = insert(node.right,d);
		else
			return node;

		node.height = 1 + max(height(node.left),height(node.right));

		int bal = balanceFactor(node);

		if(bal>1 && d<node.left.data)
			return RightRotate(node);
		if(bal<-1 && d>node.right.data)
			return LeftRotate(node);
		if(bal>1 && d>node.left.data){
			node.left = LeftRotate(node.left);
			return RightRotate(node);
		}
		if(bal<-1 && d<node.right.data){
			node.right = RightRotate(node.right);
			return LeftRotate(node);
		}

		return node;
	}

	public static Node RightRotate(Node node){
		Node x = node.left;
		Node y = x.right;
		x.right = node;
		node.left = y;
		node = x;
		x.height = max(height(node.left),height(node.right))+1;
		y.height = max(height(node.left),height(node.right))+1;
		return x;
	}

	public static Node LeftRotate(Node node){
		Node x = node.right;
		Node y = x.left;
		x.left = node;
		node.right = y;
		node = x;
		x.height = max(height(node.left),height(node.right))+1;
		y.height = max(height(node.left),height(node.right))+1;
		return x;
	}

	public static int max(int a,int b){
		int q = (a<b)?b:a;
		return q;
	}

	public static int height(Node node){
		if(node==null)
			return 0;
		else
			return node.height;
	}

	public static int balanceFactor(Node node){
		if(node==null)
			return 0;
		else
			return height(node.left) - height(node.right);
	}	
		public static void Inorder(Node node){
		if(node!=null){
			Inorder(node.left);
			System.out.print(node.data + " ");
			Inorder(node.right);
		}
	}

		public static void Preorder(Node node){
		if(node!=null){
			System.out.print(node.data + " ");
			Preorder(node.left);
			Preorder(node.right);
		}
	}


}