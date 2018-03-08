import java.util.*;

class Heapsort{

	//public static void swap(int a,int b){ int temp = a;a = b;b = temp;}

	public static void max_heapify(int arr[],int i,int n){

		int l = i*2+1;
		int r = l + 1;
		int largest=i;
		if(l<=n && arr[l]>arr[i])
		{
			largest = l;System.out.println("left child big for index "+i+": "+arr[largest]);
		}

		if(r<=n && arr[r]>arr[largest])
		{
			largest = r;System.out.println("right child big for index "+i+": "+arr[largest]);
		}

		if(largest!=i)
		{
			int temp = arr[i];arr[i] = arr[largest];arr[largest] = temp;//	SWAPPING VALUES OF A[LARGEST] AND A[I]
													//NOW THE SMALLER VALUE GOES AT A[LARGEST] INDEX
			max_heapify(arr,largest,n);
		}
	}

	public static void build_max_heap(int arr[],int n)
	{
		for(int i=n/2;i>=0;i--)
		{
			max_heapify(arr,i,n);
			
				for(int j=0;j<n;j++)
				{
					System.out.print(arr[j]+ " ");
				}

				System.out.println();
		}
	}

	public static void heapsort(int arr[],int n){
		build_max_heap(arr,n);

		for (int i=n;i>=1;i-- ) {
			
			int temp = arr[i];arr[i] = arr[0];arr[0] = temp;

			max_heapify(arr,0,i-1);
		}
	}

	public static void main(String[] args) {

		int arr[] = {4,1,3,2,16,9,10,14,8,7};

		int n = arr.length;

		heapsort(arr,n-1);

		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+ " ");
		}
	}
}