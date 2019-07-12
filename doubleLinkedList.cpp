#include <bits/stdc++.h>

using namespace std;

struct Node
{
	int data;
	Node* next;
	Node* prev;
};

class doublyLinkedList
{
	Node* head;
	Node* tail;
public:
	doublyLinkedList()
	{
		head = NULL;
		tail = NULL;
	}
	void addNode(int value)
	{
		Node* temp = new Node;
		temp->data = value;
		temp->prev = NULL;
		temp->next = NULL;
		if(head == NULL)
		{
			head = temp;
			tail = temp;
		}
		else
		{
			tail->next = temp;
			temp->prev = tail;
			temp->next = NULL;
			tail = temp;
		}
	}
	bool findNode(int value)
	{
		Node* temp = tail;
		while(temp != NULL)
		{
			if(temp->data == value)
			{
				return true;
			}
			else
			{
				temp = temp->prev;
			}
		}
		return false;
	}

	bool deleteNode(int value)
	{
		if(head == NULL) return false;

		Node* currNode = head;
		Node* prevNode = NULL;

		while(currNode != NULL)
		{
			if(currNode->data == value){
				prevNode->next = currNode->next;
				Node* temp = currNode->next;
				temp->prev = prevNode;
				return true;
			}
			else
			{
				prevNode = currNode;
				currNode = currNode->next;
			}
		}
		return false;
	}
	void display()
	{
		Node* temp = head;
		while(temp != NULL)
		{
			cout << temp->data << "<=>";
			temp = temp->next;
		}
		cout << endl;
	}
};

int main()
{
	doublyLinkedList obj;
	obj.addNode(4);
	obj.addNode(5);
	obj.addNode(7);
	obj.display();
	cout << obj.findNode(5) << endl;
	cout << obj.findNode(12) << endl;
	obj.addNode(12); 
	cout << obj.deleteNode(7) << endl;
	obj.display();
	return 0;
}