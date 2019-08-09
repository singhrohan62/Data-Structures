#include <bits/stdc++.h>

using namespace std;

int total_area = 0;

int find_largest_index(int arr[], int low, int high)
{
  int max = arr[low];
  int max_index = low;
  for (int i = low+1; i <= high; ++i)
  {
  	if(max < arr[i]){
  	  max = arr[i];
  	  max_index = i;	
  	} 
  }
  return max_index;
}

int area_of_trapped_water(int arr[], int largest_index, int second_largest_index)
{
  int est_area = arr[second_largest_index] * (abs(largest_index - second_largest_index) + 1);
  int act_area = est_area - 2 * (arr[second_largest_index]);
  int low = largest_index, high = second_largest_index;
  if(low > high)
  {
  	high = largest_index;
  	low = second_largest_index;
  }
  for (int i = low+1; i < high; ++i)
  {
  	act_area = act_area - arr[i];
  }
  cout << "expected area: "<<est_area<<", actual area: "<<act_area<<endl;
  return act_area;
}



void find_trapped_water(int arr[], int low, int high, int num)
{
  if(low == high) return ;
  cout << "low: "<<low<<", high: "<<high<<endl;
  int left_largest_index=-1, right_largest_index=num;
  int largest_index = find_largest_index(arr, low, high);
  cout << "largest_index: "<<largest_index<<endl;
  
  // The 2 below blocks check if the largest index is at the low value or high
  // i.e. is the largest pillar on the either side of the sub-array
  //if we have reached one end of the sub-array, we don't need to find out beyond that
  //i.e. if it is on left side, we don't need to concern for it's left side beyond
  // similarly, for right side. 

  if(largest_index > low)
  left_largest_index = find_largest_index(arr, low, largest_index-1);
  if(largest_index < high)
  right_largest_index = find_largest_index(arr, largest_index+1, high);

  cout << "left_largest_index: "<<left_largest_index<<", right_largest_index: "<<right_largest_index<<endl;

  	if(left_largest_index >= low)
  	{
  	  total_area = total_area + area_of_trapped_water(arr, largest_index, left_largest_index);
  	  cout << "lft total_area: " << total_area << endl;
  	  find_trapped_water(arr, 0, left_largest_index, num);
  	}

   if(right_largest_index <= high)
    {
   	 total_area = total_area + area_of_trapped_water(arr, largest_index, right_largest_index);
  	 cout << "rt total_area: " << total_area << endl;
  	 find_trapped_water(arr, right_largest_index, num-1, num);
    }
}


int main()
{
  int n;

  int arr[3] = {2, 1, 2};
  // cin >> n;

  // int arr[n];

  // for (int i = 0; i < n; ++i)
  // {
  // 	arr[i] = rand()%10 + 1;
  // }

  // for (int i = 0; i < n; ++i)
  // {
  //   cout  << arr[i] << endl;
  // }

	// int arr[12] = {1, 0, 2, 1, 0, 4, 0, 2, 0, 3, 0, 2};

	 find_trapped_water(arr, 0, 2, 3);

	cout << total_area << endl;

  return 0;
}