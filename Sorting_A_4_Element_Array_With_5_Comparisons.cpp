#include<bits/stdc++.h>

using namespace std;

int main()
{
    int arr[4];

    for(int i=0;i<4;i++)
    {
        cin >> arr[i];
    }

    int globalMax,globalMin,dummyMax,dummyMin;

    if(arr[0]>arr[1]){dummyMax = arr[0];dummyMin=arr[1];}     //COMPARISON #1
    else {dummyMax=arr[1];dummyMin = arr[0];}

    globalMax = dummyMax ; globalMin = dummyMin;

    cout << "Values of globalMax,globalMin,dummyMax and dummyMin in Array after 1 Comparison"<<endl;
    cout << globalMax <<"  "<<globalMin << " "<< dummyMax<<" " <<dummyMin <<endl<<endl;

    if(arr[2]>arr[3]){dummyMax = arr[2];dummyMin=arr[3];}       //COMPARISON #2
    else {dummyMax=arr[3];dummyMin = arr[2];}

    cout << "Values of globalMax,globalMin,dummyMax and dummyMin in Array after 2 Comparisons"<<endl;
    cout << globalMax <<"  "<<globalMin << " "<< dummyMax<<" " <<dummyMin <<endl<<endl;

    if(globalMax<dummyMax){int temp;temp = globalMax ;globalMax = dummyMax;dummyMax = temp;}     //COMPARISON #3

    cout << "Values of globalMax,globalMin,dummyMax and dummyMin in Array after 3 Comparisons"<<endl;
    cout << globalMax <<"  "<<globalMin << " "<< dummyMax<<" " <<dummyMin <<endl<<endl;

    if(globalMin > dummyMin) {int temp;temp = globalMin ;globalMin = dummyMin;dummyMin = temp;}     //COMPARISON #4

    arr[3] = globalMax;

    arr[0] = globalMin;

    cout << "Values of globalMax,globalMin,dummyMax and dummyMin in Array after 4 Comparisons"<<endl;
    cout << globalMax <<"  "<<globalMin << " "<< dummyMax<<" " <<dummyMin <<endl<<endl;

    if(dummyMax > dummyMin){arr[1]=dummyMin;arr[2]=dummyMax;}     //COMPARISON #5

    else{arr[1]=dummyMax;arr[2]=dummyMin;}

    cout << "Values of globalMax,globalMin,dummyMax and dummyMin in Array after 5 Comparisons"<<endl;

    for(int i=0;i<4;i++)
    {
        cout << arr[i] <<" ";
    }

    cout << endl;
}
