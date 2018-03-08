#include<bits/stdc++.h>

using namespace std;

 vector <int> adj[10];

int main(int argc, char const *argv[])
{

	int x,y,nodes,edges;

	cin >>nodes >> edges;

	for (int i = 0; i < edges; ++i)
	{
		cin >> x >> y;
		adj[x].push_back(y);	//creating an adjacency list for the graph
	}

	for (int i = 1; i <= nodes; ++i)
	{
		cout << "Vertices connected to Node "<<i<<" : ";

		for(int j=0;j<adj[i].size();j++)
		{
			if (j==adj[i].size()-1)
			{
				cout << adj[i][j] << endl;
			}

			else
				cout << adj[i][j] << " --> ";
		}
	}

	return 0;
}
