package graphs;
import java.util.*;
public class topologicalSorting {
	public int N;
	LinkedList<Integer> adjList[];
	public topologicalSorting(int N)
	{
		this.N = N;
		adjList = (LinkedList<Integer>[])new LinkedList[N];
		for(int i=0; i<N; i++)
			adjList[i] = new LinkedList<Integer>();
	}

	public void addEdge(int x, int y)
	{
		adjList[x].add(y);
	}
	
	public void topoLogicalSorting()
	{
		boolean visited[] = new boolean[N];
		Stack<Integer> stk = new Stack<Integer>();
		for(int i=0; i<N; i++)
			visited[i] = false;
		for(int i=0; i<N; i++)
		{
			if(!visited[i])
				topoLogicalSortingUtil(i,visited,stk);
		}
		while(!stk.isEmpty())
		{
			System.out.print(stk.pop()+" ");
		}
	}
	
	public void topoLogicalSortingUtil(int node, boolean visited[], Stack<Integer> stk)
	{
		if(!visited[node])
		{
			visited[node] = true;
			Iterator itr = adjList[node].iterator();
			while(itr.hasNext())
			{
				int adjNode = (int) itr.next();
				if(!visited[adjNode])
					topoLogicalSortingUtil(adjNode,visited,stk);
			}
			stk.push(node);
		}
	}
	
	public static void main(String []args)
	{
		topologicalSorting graph = new topologicalSorting(6);
		graph.addEdge(0, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(4, 1);
		graph.addEdge(0, 5);
		graph.addEdge(4, 0);
		graph.topoLogicalSorting();
	}
}
