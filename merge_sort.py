import numpy as np

#__author__ = "Rohan Singh"

def merge_sort(list, low, high):
	if low < high:
		mid = (high+low) // 2
		merge_sort(list, low, mid)
		merge_sort(list, mid+1, high)
		merge(list, low, mid, high)

def merge(list, low, mid, high):

	left_sub = list[low:mid + 1]
	right_sub = list[mid + 1: high + 1]
	k = low
	while left_sub and right_sub:
		if left_sub[0] < right_sub[0]:
			list[k] = left_sub.pop(0)
		else:
			list[k] = right_sub.pop(0)
		k += 1
	while left_sub:
		list[k] = left_sub.pop(0)
		k += 1
	while right_sub:
		list[k] = right_sub.pop(0)
		k += 1

def main():
	num = int(input("Enter the size of array: "))
	list = np.random.randint(1, 10000, num).tolist()
	# tolist() method used coz pop() N/A for numpy.ndarray doesn't contain pop()
	print(list)
	merge_sort(list, 0, num-1)
	print(list)

if __name__ == '__main__':
	main()

