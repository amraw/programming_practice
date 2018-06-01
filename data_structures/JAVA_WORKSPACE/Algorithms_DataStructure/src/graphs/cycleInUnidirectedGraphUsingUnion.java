package graphs;
import java.util.*;
public class cycleInUnidirectedGraphUsingUnion {
public int N;
public LinkedList<Edge> edges;

public cycleInUnidirectedGraphUsingUnion(int N)
{
	this.N = N;
	edges = new LinkedList<Edge>();
}

public void addEdge(int x, int y)
{
	Edge newEdge = new Edge(x,y);
	edges.add(newEdge);
}

public int find(int []parent, int i)
{
	if(parent[i] == -1)
		return i;
	return find(parent,parent[i]);
}

public void Union(int []parent, int x, int y)
{
	int xset = find(parent, x);
	int yset = find(parent,y);
	parent[xset] = yset;
}

public int cycle()
{
	int parent[] = new int[N];
	for(int i=0; i<parent.length; i++)
		parent[i] = -1;
	
		Iterator itr = edges.iterator();
		while(itr.hasNext())
		{
			Edge edges = (Edge) itr.next();
			int x = find(parent,edges.src);
			int y = find(parent,edges.dest);
			if(x==y)
				return 1;
			Union(parent,x,y);
		}
	return 0;
}

public static void main(String []args){
	cycleInUnidirectedGraphUsingUnion graph = new cycleInUnidirectedGraphUsingUnion(3);
	graph.addEdge(0, 1);
	graph.addEdge(1, 2);
	graph.addEdge(0, 2);
	
	if(graph.cycle() == 1)
		System.out.println("Cycle detected");
	else
		System.out.println("Cycle not found");
}

}

class Edge{
	int src;
	int dest;
	public Edge(int src, int dest)
	{
		this.src = src;
		this.dest = dest;
	}
}
