package graphs;

import java.util.*;
public class IterativeDeepeningSearch {
int N; 
public LinkedList<Integer> adjList[];
public IterativeDeepeningSearch(int N)
{
	this.N = N;
	adjList = (LinkedList<Integer>[]) new LinkedList[N];
	for(int i=0; i<N; i++)
		adjList[i] = new LinkedList<Integer>();
}
public void addEdge(int src, int dest)
{
	adjList[src].add(dest);
}

public boolean IterativeDeepeningSearchAlgo(int src, int maxDepth, int target)
{
	for(int i=0; i<=
			maxDepth; i++)
		if( IterativeDeepeningSearchUtil(src,target, i) )
			return true;
	return false;
}

public boolean IterativeDeepeningSearchUtil(int node,  int target, int limit)
{
	if(limit<=0)
	{
		return false;
	}
	if(node == target)
		return true;
	
	Iterator itr = adjList[node].iterator();
	while(itr.hasNext())
	{
			int adjNode = (int) itr.next();
			if(IterativeDeepeningSearchUtil(adjNode,target,limit-1))
				return true;
	}
	return false;
}

public static void main(String []args)
{
	IterativeDeepeningSearch graph = new IterativeDeepeningSearch(7);
	graph.addEdge(0, 1);
	graph.addEdge(0, 2);
	graph.addEdge(1, 3);
	graph.addEdge(1, 4);
	graph.addEdge(2, 5);
	graph.addEdge(2, 6);
	
	int target = 6, maxDepth = 3, src = 0;
	
	if(graph.IterativeDeepeningSearchAlgo(0,maxDepth,target))
	{
		System.out.print("Target reachable in the given depth");
	}
	else
	{
		System.out.print("Target not reachable in the given depth");
	}
}

}