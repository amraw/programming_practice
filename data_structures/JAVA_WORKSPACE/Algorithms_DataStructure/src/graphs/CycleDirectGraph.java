package graphs;

import java.util.*;

public class CycleDirectGraph {
	
	private int V;
	private LinkedList<Integer> adj[];
	
	public CycleDirectGraph(int V){
		this.V = V;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for(int i=0; i< V; i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	public boolean DetetCycleUtil(int node, boolean visited[], boolean recurStack[])
	{
		if(!visited[node]){
			visited[node] = true;
			recurStack[node]=true;
			Iterator<Integer> itr = adj[node].listIterator();
			while(itr.hasNext()){
				int next = itr.next();
				if(!visited[next] && DetetCycleUtil(next,visited,recurStack))
					return true;
				if(recurStack[next])
					return true;
			}
		}
		recurStack[node] = false;
		return false;
	}
	
	public boolean DetectCycle(){
		boolean visited[] = new boolean[V];
		boolean recurStack[] = new boolean [V];
		for(int i=0; i<V; i++)
		{
			if(DetetCycleUtil(i,visited, recurStack))
				return true;
				
		}
		return false;
	}
	
	public static void main(String []args){
		CycleDirectGraph g = new CycleDirectGraph(4);
		g.addEdge(0, 1);
	    //g.addEdge(0, 2);
	   // g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    //g.addEdge(3, 3);
	    if(g.DetectCycle())
	    	System.out.println("Cycle Exist in Graph");
	    else
	    	System.out.println("Cycle Not Exist in Graph");
	}

}
