#include <bits/stdc++.h>
#include<inttypes.h>

using namespace std;

struct Node
{
	int data;
	Node* both;
};

Node* XOR(Node* a, Node* b)
{
	return (Node*)((uintptr_t)(a) ^ (uintptr_t)(b));
}

class LinkedList{
	
public:
	Node* head;
	LinkedList(int value){
		head->data = value;
		head->both = NULL;
	}
	void addNode(int value){
		Node* newNode = new Node;
		newNode->data = value;
		Node* prev = NULL;
		Node* curr = head;
		Node* next = NULL;

		while (curr != NULL)
		{
			next = XOR(prev, curr->both);
			prev = curr;
			curr = next;
		}
		prev->both = XOR(prev->both, newNode);
		newNode->both = XOR(NULL, prev);

		return ;
	}
	void display()
	{
		Node* prev = NULL;
		Node* curr = head;
		Node* next;
		while(curr != NULL)
		{
			cout << curr->data <<" "<<curr->both<<endl;
			next = XOR(prev, curr->both);
			prev = curr;
			curr = next;
		}
	}
};

int main ()
{
	LinkedList list(1);
	list.addNode(2);
	list.addNode(3);
	list.addNode(4);
	list.display();
	//cout << list.head->data << " " << list.head->both << endl;
	//Node* temp = list.head;

	return 0;
}
