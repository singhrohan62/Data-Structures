class Node:
	def __init__(self, data, next = None):
		self.data = data
		self.next = next

class LinkedList:
	traversal_cost = "O(n)"
	def __init__(self, node=None):
		self.head = node

	def addNode(self, data):
		if(self.head == None):
			self.head = Node(data)
			return 

		newNode = Node(data)
		temp = self.head
		while temp.next != None:
			temp = temp.next

		temp.next = newNode
		print(temp.data)
		return

	def displayList(self):
		temp = self.head
		while temp != None:
			print(temp.data, " ")
			temp = temp.next

		return

	def addToGivenIndex(self, data, index):
		print("Assuming index starts from 0")
		currNode = self.head
		prevNode = None
		while index > 0:
			prevNode = currNode
			currNode = currNode.next
			index -= 1
		newNode = Node(data)
		prevNode.next = newNode
		newNode.next = currNode
		return

	def deleteNodeGivenIndex(self, index):
		print("Assuming index starts from 0 and deleting node of index:", index)
		currNode = self.head
		prevNode = None
		while index > 0:
			prevNode = currNode
			currNode = currNode.next
			index-=1
		prevNode.next = currNode.next
		return 

	def reverse_list(self):
		print("List before reversing it:")
		self.displayList()
		currNode = self.head
		prevNode = None
		while currNode != None:
			nextNode = currNode.next
			currNode.next = prevNode
			prevNode = currNode
			currNode = nextNode

			self.head = prevNode;

		print("List after reversing it:")
		self.displayList()
		return 




nodeA = Node(1)
ll = LinkedList(nodeA)
nodeB = Node("Mon")
nodeC = Node(3.4)
nodeA.next = nodeB
nodeB.next = nodeC

print(ll.head.data)

ll2 = LinkedList(nodeB)

print(nodeB.next.data)

print(ll.traversal_cost, " ", ll2.traversal_cost)

ll.addNode("d")

ll.displayList()

ll.addToGivenIndex(35.6, 2)

ll.displayList()

ll.deleteNodeGivenIndex(3)

ll.displayList()

ll.reverse_list()