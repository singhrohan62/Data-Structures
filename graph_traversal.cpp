#include <bits/stdc++.h>

using namespace std;

vector<int> adj[10];

int level[10];

bool visit[10];

int src;

void BFS()
{
	cout << "Running BFS..." <<endl;
	queue <int> q;

	q.push(src);

	level[src] = 0;

	visit[src] = 0;

	while(!q.empty())
	{
		int p = q.front();
		q.pop();

		for (int i = 0; i < adj[p].size(); ++i)
		{
			if(visit[ adj[p][i] ] == false)
			{
				level[ adj[p][i] ] = level[ p ] + 1;
				q.push(	adj[p][i]);
				visit[ adj[p][i] ] = true;
			}
		}
		if (!q.empty())
		cout << "Top of the queue: "<< q.front() << endl;
	}

}

void DFS()
{
	cout << endl << "Running DFS..."<<endl;
	stack <int> s;

	s.push(src);

	level[src] = 0;
	visit[src] = 0;

	while(!s.empty())
	{
		int p = s.top();
		s.pop();

		for (int i = adj[p].size()-1; i > -1; --i)
		{
			if(visit[ adj[p][i] ] == false)
			{
				level[ adj[p][i] ] = level[p] + 1;
				s.push( adj[p][i] );
				visit[adj[p][i]] = true;
				//cout << "Current node: "<<adj[p][i] << endl;
			}
		}
		if (!s.empty())
		{
			cout << "Top of the stack: "<<s.top()<<endl;
		}
	}
}



int main()
{
	int nodes,edges;

	cin >> nodes >> edges;

	int x,y;

	for (int i = 0; i < edges; ++i)
	{
		cin >> x >> y;
		if(i == 0) src = x;
		adj[x].push_back(y);
	}

	BFS();

	for(int i=0;i<10;i++)
	{
		level[i] = 0;
		visit[i] = false;
	}

	DFS();
	return 0;
}