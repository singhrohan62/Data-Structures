#include <bits/stdc++.h>

using namespace std;

void merge(int* arrptr, int low, int mid, int high)
{
  int p=low,q=mid+1,k=0;
  int tempArr[high-low+1];

  cout <<"Mrg-> "<<"low: "<<low<<" mid: "<<mid<<" high: "<<high<<endl;
  
  for(int c=low;c<=high;c++)
  {
  	cout <<"At iteration "<<c<<", "<<"p: "<<p<<", q: "<<q<<endl;
  	if( p > mid)
  	{
  	  tempArr[k++] = arrptr[q++];
  	}

  	else if( q > high)
  	{
  	  tempArr[k++] = arrptr[p++];
  	}

  	else if( arrptr[p] < arrptr[q])
  	{
  	  tempArr[k++] = arrptr[p++];
  	}
  	else
  	  tempArr[k++] = arrptr[q++];
  }

  cout << "tempArr: ";

	for (int i = 0; i < k; ++i)
	{
		arrptr[low+i] =  tempArr[i];
		cout << tempArr[i]<<" ";
	}

	cout << endl;
}

void merge_sort(int* arrptr, int low, int high)
{
  if(low<high)
  {
  	int mid = (high+low)/2;
  	cout<< "MS-> " <<"low: "<<low<<" mid: "<<mid<<" high: "<<high<<endl;
  	merge_sort(arrptr, low, mid);
  	merge_sort(arrptr, mid+1, high);
  	merge(arrptr, low, mid, high);
  }
}

int main()
{
  int n;
  cin >> n;
  int arr[n];
  for (int i = 0; i < n; ++i)
  {
  	cin >> arr[i];
  }

  int* arrptr = arr;

  merge_sort(arrptr, 0, n-1);

  for (int i = 0; i < n; ++i)
  {
  	cout << arrptr[i] << " ";
  }

  cout << endl;

}

/*

0 1 2 3 4
0 1 2
0 1
*/