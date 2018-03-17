import java.util.*;

class Insertsort{
	public static void isort(int a[],int n){
	int i,j,key;
	for(i=0;i<n;i++){
		key = a[i];
		j = i-1;
		while(j>=0&&a[j]>key){
			a[j+1]=a[j];
			j = j-1;
		}
		a[j+1]=key;
	}
}

	public static void main(String[] args) {
		int i,n;
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the length of the array : ");
		n = ip.nextInt();
		int a[] = new int[n];
		System.out.println("Enter the elements of the array : ");
		for(i=0;i<n;i++){
			a[i] = ip.nextInt();
		}
		isort(a,n);

		for (i=0;i<n;i++) {
			System.out.println(a[i]);
		}

	}

}