#include<bits/stdc++.h>

using namespace std;

#define V 5;

int minKey(int key[], bool mstSet[])
{
   // Initialize min value
   int min = INT_MAX, min_index;

   for (int v = 0; v < V; v++)
     if (mstSet[v] == false && key[v] < min)
         min = key[v], min_index = v;

   return min_index;
}

void printMST(int parent[],int n,int Graph[V][V])
{
    cout << "Edge Weight"<<endl;
    for(int i=1;i<V;i++)
    cout << parent[i]<< "-"<<i<<"  "<<Graph[i][parent[i]]<<endl;
}

void PrimMST (int Graph[V][V])
{
    int parent[V];int key[V];bool mstSet[V];

    for(int i=0;i<V;i++)
    {
        mstSet[i] = false;key[i] = INT_MAX;
    }

    key[0] = 0;parent[0]= -1;

    for(int counter=0;counter<V-1;counter++)
    {
        int u = minKey(key,mstSet);

        mstSet[u] = true;

        for(int v=0;v<V;v++)
        {
             if (graph[u][v] && mstSet[v] == false && graph[u][v] <  key[v])
             parent[v]  = u, key[v] = graph[u][v];

        }
    }

    printMST(parent, V, graph);
}

int main ()
{
     int graph[V][V] = {{0, 2, 0, 6, 0},
                        {2, 0, 3, 8, 5},
                        {0, 3, 0, 0, 7},
                        {6, 8, 0, 0, 9},
                        {0, 5, 7, 9, 0},
                     };

        PrimMST(graph);

        return 0;
}
