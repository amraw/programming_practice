package graphs;
import java.util.*;
public class transitiveClosurOfGraph {
int N;
LinkedList<Integer> adjList[];
public transitiveClosurOfGraph(int N)
{
	this.N = N;
	adjList = (LinkedList<Integer>[]) new LinkedList[N];
	for(int i=0; i<N; i++)
		adjList[i] = new LinkedList<Integer>();
}

public void addEdge(int x, int y)
{
	adjList[x].add(y);
}

/* Not optimized
 * public void transitiveClosureofGraphCalculate(){
	int transitiveClosure[][] = new int[N][N];
	boolean visited[] = new boolean[N];
	for(int i=0; i<N; i++)
		Arrays.fill(transitiveClosure[i], 0);
	for(int i=0; i<N; i++)
	{
		Arrays.fill(visited, false);
		Iterator itr = adjList[i].iterator();
		while(itr.hasNext())
		{
			int adjNode = (int)itr.next();
			if(!visited[adjNode])
				transitiveClosureofGraphCalculateUtil(i,adjNode,transitiveClosure, visited);
		}
	}
	for(int i=0; i<N; i++)
	{
		for(int j=0; j<N; j++)
		{
			System.out.print(""+transitiveClosure[i][j]);
		}
		System.out.println("");
	}
		
}
*/

public void transitiveClosureofGraphCalculate(){
	int transitiveClosure[][] = new int[N][N];
	for(int i=0; i<N; i++)
		Arrays.fill(transitiveClosure[i], 0);
	for(int i=0; i<N; i++)
		transitiveClosureofGraphCalculateUtil(i,i,transitiveClosure);
	
	for(int i=0; i<N; i++)
	{
		for(int j=0; j<N; j++)
		{
			System.out.print(""+transitiveClosure[i][j]);
		}
		System.out.println("");
	}
		
}

/* Not optimized
 * 
 * public void transitiveClosureofGraphCalculateUtil(int start, int node, int [][]transitiveClosure, boolean visited[] )
{
	if(!visited[node])
	{
		visited[node] = true;
		transitiveClosure[start][node] = 1;
		Iterator itr = adjList[node].iterator();
		while(itr.hasNext())
		{
			int adjNode = (int)itr.next();
			if(!visited[adjNode])
				transitiveClosureofGraphCalculateUtil(start,adjNode,transitiveClosure, visited);
		}
	}
}*/

// Optimized verstion of above code
public void transitiveClosureofGraphCalculateUtil(int start, int node, int [][]transitiveClosure)
{
		transitiveClosure[start][node] = 1;
		Iterator itr = adjList[node].iterator();
		while(itr.hasNext())
		{
			int adjNode = (int)itr.next();
			if(transitiveClosure[start][adjNode] == 0)
				transitiveClosureofGraphCalculateUtil(start,adjNode,transitiveClosure);
		}
}

public static void main(String []args)
{
	transitiveClosurOfGraph graph = new transitiveClosurOfGraph(4);
	graph.addEdge(0, 1);
	graph.addEdge(0, 2);
	graph.addEdge(1, 2);
	graph.addEdge(2, 0);
	graph.addEdge(2, 3);
	graph.addEdge(3, 3);
	graph.transitiveClosureofGraphCalculate();
}

}

