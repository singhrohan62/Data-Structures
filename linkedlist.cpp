#include <bits/stdc++.h>

using namespace std;

struct node
{
  int data;
  node* next;
};

class LinkedList
{
  node *head, *tail;
  public:
    LinkedList()
    {
      head = NULL;
      tail = NULL;
    }
    void insertNode(int value)
    {
      //By default, we add node to the last of the list
      node* temp = new node;
      temp->data = value;
      temp->next = NULL;
      if(head == NULL)
      {
        head = temp;
        tail = temp;
        //tail->next = NULL;
      }
      else 
      {
        tail->next = temp;
        tail = temp;
      }
    }
    void insertNode(int value, int position)
    {
      if(head == NULL)
      {
        if(position > 1)
        {
          cout << "The list is empty, so adding the node to first position" << endl;
        }
        insertNode(value);
      }
      else
      {
        node* newNode = new node;
        newNode->data = value;
        node* prevNode = NULL;
        node* currNode = head;
        while(position > 1 && (tail->next != currNode))
        {
          prevNode = currNode;
          currNode = currNode->next;
          //cout << prevNode->data << " " << currNode->data<<endl;
          position--;
        }
        if(position <= 0)//Insert new node at head
        { 
          head = newNode;
          newNode->next = currNode;
        }
        else
        {
          prevNode->next = newNode;
          newNode->next = currNode;
          if(prevNode == tail)
          {
            tail = newNode;
          }
        }
      }
    }

    bool deleteNode(int position)
    {
      if (head == NULL || position < 1)
      {
        return false;
      }
      if(position == 1)
      {
        head = head->next;
        return true;
      }
      node* prevNode = NULL;
      node* currNode = head;
      while(position > 1 && tail->next != currNode)
      {
        prevNode = currNode;
        currNode = currNode->next;
        position--;
      }
      if(tail == currNode)
      {
        tail = prevNode;
        cout << "New tail: " << tail->data << endl;
      }
      else if(tail == prevNode)
      {
        cout << "No node found at that position" << endl;
        return 0;
      }
      prevNode->next = currNode->next;
      return true;
    }

    void reverse_list()
    {
      node* prevNode = NULL;
      node* currNode = head;
      tail = currNode;
      while(currNode != NULL)
      {
        node* temp = currNode->next;
        currNode->next = prevNode;
        prevNode = currNode;
        currNode = temp;
      }
      head = prevNode;
    }

    void display()
    {
      node *temp = head;
      cout << "LinkedList: ";
      while(temp != NULL)
      {
        cout << temp->data << "->";
        temp = temp->next;
      }
      cout << "NULL" << endl;
    }
};


int main()
{
  LinkedList sample;
  sample.insertNode(2);
  sample.insertNode(5);
  sample.insertNode(6,2);
  sample.insertNode(12,4);
  //sample.insertNode(143, 11);//Makes 143 the tail node
  //sample.insertNode(34, -1);//Makes 34 the head node
  sample.display();
  sample.deleteNode(2);
  sample.display();
  //sample.deleteNode(3);
  sample.display();
  sample.deleteNode(5);
  sample.display();
  sample.reverse_list();
  sample.display();
  return 0;
}