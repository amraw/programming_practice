package graphs;

import java.util.*;

public class DFS {
	private int V;
	private LinkedList<Integer> adj[];
	private boolean visited[];
	public DFS(int V){
		this.V = V;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for(int i = 0; i<V; i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
	}
	
	void DFSPrint(int node, boolean []visited){
		visited[node]=true;
		System.out.print(node+" ");
		Iterator<Integer> itr = adj[node].iterator();
		while(itr.hasNext()){
			int next = itr.next();
			if(!visited[next])
				DFSPrint(next , visited);
		}
	}
	
	void DFS(){
		visited = new boolean[V];
		for(int i=0; i<V; i++)
			if(!visited[i])
				DFSPrint(i, visited);
	}
	
	public static void main(String []args){
		DFS g = new DFS(4);
		g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
	    
	    System.out.println("DFS of Tree");
	    g.DFS();
	}

}
