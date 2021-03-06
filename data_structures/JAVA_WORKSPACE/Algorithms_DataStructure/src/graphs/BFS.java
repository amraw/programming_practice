package graphs;
import java.util.*;


public class BFS {
	private boolean []visited;
	private GraphBFS graph;
	public BFS(int V){
		graph = new GraphBFS(V);
		visited = new boolean[V];
	}
	
	public void printBFS(int s){
		LinkedList<Integer> queue = new LinkedList<Integer>();
		LinkedList<Integer> adj[] = graph.getAdjList();
		queue.add(s);
		visited[s] = true;
		while(!queue.isEmpty()){
			int node = queue.poll();
			System.out.print(node+" ");
			Iterator<Integer> itr = adj[node].listIterator();
			while(itr.hasNext())
			{
				int adjNode = itr.next();
				if(!visited[adjNode]){
					queue.add(adjNode);
					visited[adjNode] = true;
				}
			}
		}
	}
	
	public GraphBFS getBSFGraph(){
		return graph;
	}
	
	public static void main(String args[])
	{
		BFS bfs = new BFS(4);
		GraphBFS g = bfs.getBSFGraph();
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
        bfs.printBFS(3);
		
	}
}

class GraphBFS{
private int V;
private LinkedList<Integer> []adj;

public GraphBFS(int V){
	this.V = V;
	adj = (LinkedList<Integer>[]) new LinkedList[V];
	for(int i=0; i<V; i++)
	{
		adj[i] = new LinkedList<Integer>();
	}
}

public void addEdge(int v, int w){
	adj[v].add(w);
}

public LinkedList<Integer>[] getAdjList(){
	return adj;
}
}