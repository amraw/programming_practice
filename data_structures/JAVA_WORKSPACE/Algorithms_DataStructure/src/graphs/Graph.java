package graphs;

import java.util.*;

public class Graph {
	int V;
	LinkedList<Integer> []adj;
	
	Graph( int V)
	{
		this.V=V;
		adj = (LinkedList<Integer>[])new LinkedList[V];
		for(int i=0; i<V; i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}
	
	void printGraph()
	{
		for(int i=0; i<V; i++)
		{
			System.out.print("Adjacency List of Node "+ i+" ");
			Iterator<Integer> itr = adj[i].iterator();
			while(itr.hasNext())
			{
				System.out.print(" "+itr.next());
			}
			System.out.println("");
		}
	}
	
	public static void main(String []args)
	{
		System.out.println("Hello world");
		Graph graph = new Graph(3);
		graph.addEdge(0, 2);
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 1);
		graph.printGraph();
	}

}

