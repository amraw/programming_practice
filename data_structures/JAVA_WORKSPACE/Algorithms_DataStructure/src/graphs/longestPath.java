package graphs;
import java.util.*;
public class longestPath {
public int N;
public LinkedList<node2> adjList[];
public longestPath(int N)
{
	this.N = N;
	adjList = (LinkedList<node2>[])new LinkedList[N];
	for(int i=0; i<N; i++)
		adjList[i] = new LinkedList<node2>();
}

public void addEdge(int src, int dest, int weight)
{
	adjList[src].add(new node2(src,dest,weight));
}

public void topologicalSortUtil(int node, boolean visited[], Stack<Integer> stk){
	if(!visited[node])
	{
		visited[node] = true;
		Iterator itr = adjList[node].iterator();
		while(itr.hasNext())
		{
			node2 adjNode = (node2) itr.next();
			if(!visited[adjNode.dest])
				topologicalSortUtil(adjNode.dest, visited, stk);
		}
		stk.push(node);
	}
}

public Stack<Integer> topologicalSort()
{
	Stack<Integer> stk = new Stack<Integer>();
	boolean visited[] = new boolean[N];
	for(int i=0; i<N; i++)
	{
		if(!visited[i])
			topologicalSortUtil(i,visited,stk);
	}
	return stk;
}

public void calculateMaxPath(int start)
{
	Stack<Integer> stk;
	stk = topologicalSort();
	int distance[] = new int[N];
	for(int i=0; i<N; i++)
	{
		distance[i]=Integer.MIN_VALUE;
	}
	distance[start] = 0;
	while(!stk.isEmpty()){
		int node = (int) stk.peek();
		stk.pop();
		Iterator itr = adjList[node].iterator();
		while(itr.hasNext())
		{
			node2 adjNode = (node2)itr.next();
			if(distance[adjNode.dest] < distance[node]+adjNode.weight)
			{
				distance[adjNode.dest] = distance[node]+adjNode.weight;
			}
		}
			
	}
	
	for(int i =0; i<N; i++)
		System.out.println(String.valueOf(distance[i]));

}

public static void main(String []args)
{
	longestPath graph = new longestPath(6);
	graph.addEdge(0, 1, 5);
	graph.addEdge(0, 2, 3);
	graph.addEdge(1, 3, 6);
	graph.addEdge(1, 2, 2);
	graph.addEdge(2, 4, 4);
	graph.addEdge(2, 5, 2);
	graph.addEdge(2, 3, 7);
	graph.addEdge(3, 5, 1);
	graph.addEdge(3, 4, -1);
	graph.addEdge(4, 5, -2);
	graph.calculateMaxPath(1);
}

}

class node2{
	int src;
	int dest;
	int weight;
	public node2(int src, int dest, int weight)
	{
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
}
