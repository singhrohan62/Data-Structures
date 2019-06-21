import numpy as np

#__author__ = "Rohan Singh"

def insertion_sort(list):
	for x in range(1,len(list)):
		key = list[x]
		j = x-1
		while j >= 0 and list[j] > key:
			#swap
			temp = key
			list[j+1] = list[j]
			list[j] = key
			j-=1

def main():
	num = int(input("Enter size of array: "))
	print(num)
	list = np.random.randint(1, 10000, num)
	print(list)
	insertion_sort(list)
	print(list)

if __name__ == '__main__':
	main()