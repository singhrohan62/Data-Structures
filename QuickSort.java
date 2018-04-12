import java.util.*;
import java.io.*;

class QuickSort{

	public static int partition(int a[],int l,int r){
		int pivot = a[r];
		int i=l-1,j;
		for(j=1;j<r;j++){
			if(a[j]<=pivot){
				i++;
				int tmp = a[j];
				a[j] = a[i];
				a[i] = tmp;
			}
		}

		int temp = a[r];
		a[r] = a[i+1];
		a[i+1] = temp;
		return a[i+1];
	}

	public static void sort(int a[],int l, int r){
		if(l<r){
			int pi = partition(a,l,r);
			sort(a,l,pi-1);
			sort(a,pi+1,r);
		}
	}

	public static void main(String[] args)throws Exception {
		Scanner ip = new Scanner(System.in);
		Random r = new Random();
		int n,i;
		n = ip.nextInt();
		int arr[] = new int[n];
		for(i=0;i<n;i++){
			arr[i] = r.nextInt(4000)+1000;
		}
		QuickSort obj = new QuickSort();
		double str = System.nanoTime();
		str = str/1000;
		obj.sort(arr,0,n-1);
		double end = System.nanoTime();
		end = end/1000;
		for(i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println(end-str);
	}
}