#include <bits/stdc++.h>

using namespace std;

void print_array (int* arr, int n);

void insert_sort(int* arr, int n)
{
  int j, key;
  for(int i=1;i<n;i++)
  {
  	j = i-1;key = arr[i];
  	while((j>=0) && (arr[j] > key))
  	{
  	  int temp = key;
  	  arr[j+1] = arr[j];
  	  arr[j] = temp;
  	  j--;
  	}
  }
}

void print_array(int* arr, int n)
{
  for(int i=0;i<n;i++)
  {
  	cout << arr[i] << " ";
  }
  cout << endl;
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

  insert_sort(arrptr, n);

  print_array(arrptr, n);

  return 0;
}