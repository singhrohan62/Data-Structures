import java.util.*;
import java.io.*;

class MergeSort{

	public static void merge(int a[],int l,int m,int r){
		int n1 = m+1-l;
		int n2 = r-m;
		int i,j,k;
		int L[] = new int[n1];
		int M[] = new int[n2];
		for(i=0;i<n1;i++){
			L[i] = a[l+i];
		}
		for(j=0;j<n2;j++){
			M[j] = a[m+1+j];
		}
		i=0;j=0;k=l;
		while(i<n1 && j<n2){
			if(L[i]<M[j]){
				a[k] = L[i];
				i++;k++;
			}
			else{
				a[k] = M[j];
				j++;k++;
			}
		}

		while(i<n1){
			a[k] = L[i];
			i++;k++;
		}
		while(j<n2){
			a[k] = M[j];
			j++;k++;
		}
	}

	public static void sort(int a[],int l,int r){
		if(l<r){
			int m = l + (r-l)/2;

			sort(a,l,m);
			sort(a,m+1,r);
			merge(a,l,m,r);
		}
	}

	public static void main(String[] args) throws Exception{
		Scanner ip = new Scanner(System.in);
		Random r = new Random();
		int n,i;
		n = ip.nextInt();
		int arr[] = new int[n];
		for(i=0;i<n;i++){
			arr[i] = r.nextInt(4000)+1000;
		}
		MergeSort obj = new MergeSort();
		double start = System.nanoTime();
		start = start/1000;
		obj.sort(arr,0,n-1);
		double end = System.nanoTime();
		end = end/1000;

		 for(i=0;i<n;i++){
		 	System.out.print(arr[i]+" ");
		 }
		 System.out.println();
		 System.out.println(end - start);
	}
}