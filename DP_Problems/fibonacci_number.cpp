/*
Author: Rohan Singh
The aim of this program
is to compare both solutions
of the program, one with simple
recursion and the other with 
memoization (Dynamic Programming)
*/

#include<bits/stdc++.h>

using namespace std;

int fib_num(int num, int* ptrmemo)
{
  if(num == 0){ ptrmemo[num] = 1; return 1;}
  else if(num == 1){ ptrmemo[num] = 1; return 1;}
  else if(ptrmemo[num] != 0){ return ptrmemo[num];}
  else {
  	int result = fib_num(num-1, ptrmemo) + fib_num(num-2, ptrmemo);
  	ptrmemo[num] = result; return result;
  }
}

int fib_num(int num)
{
  if(num == 0 || num == 1) return 1;
  else
  {
  	int result = fib_num(num-1) + fib_num(num-2);
  	return result;
  }
}

int main()
{
  int num;
  cout << "Enter the sequence number" << endl;
  cin >> num;
  int arr[num] = {};
  int* ptrmemo = arr; int response;
  cout << "Enter 1 for getting answer through simple recursion" << endl;
  cout << "Enter 2 for getting answer through memoization (DP)" << endl;
  cout << "Enter 3 for quiting" << endl;
  cin >> response;
  int result;
  while(response != 3)
  {
  	switch(response){
  	  case 1:
  	  result = fib_num(num-1);
  	  cout << result << endl;
  	  break;

  	  case 2:
  	  result = fib_num(num-1, ptrmemo);
  	  cout << result << endl;
  	  break;

  	  case 3:
  	  break;

  	  default:
  	  cout << "Add a valid response" << endl;
  	  break;
  	}
  	cin >> response;
  }
  return 0;
}