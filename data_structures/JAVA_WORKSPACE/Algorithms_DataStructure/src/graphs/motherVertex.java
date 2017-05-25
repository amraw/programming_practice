package graphs;
import java.util.*;
public class motherVertex {
int N;
LinkedList<Integer> adjList[];
public motherVertex(int N)
{
	this.N = N;
	adjList = (LinkedList<Integer>[]) new LinkedList[N];
	for(int i=0; i<N; i++)
	{
		adjList[i] = new LinkedList<Integer>();
	}
}

public void addEdge(int x, int y)
{
	adjList[x].add(y);
}

public void findMotherVertices()
{
	boolean visited[] = new boolean[N];
	for(int i=0; i<N; i++)
	{
		Arrays.fill(visited, false);
		findMotherVerticesUtil(i,visited);
		if(isMotherVertex(visited))
		{
			System.out.print(String.valueOf(i)+" ");
		}
	}
}

public void findMotherVerticesUtil(int node, boolean visited[])
{
	if(!visited[node])
	{
		visited[node] = true;
		Iterator itr = adjList[node].iterator();
		while(itr.hasNext())
		{
			int adjNode =  (int) itr.next();
			findMotherVerticesUtil(adjNode,visited);
		}
	}
}

public int findMotherVerticesOptimized()
{
	boolean visited[] = new boolean[N];
	Arrays.fill(visited, false);
	int motherVertex = -1;
	for(int i=0; i<N; i++)
	{
		if(!visited[i])
		{
			findMotherVerticesUtil(i,visited);
			motherVertex = i;
		}
	}
	
	Arrays.fill(visited, false);
	findMotherVerticesUtil(motherVertex,visited);
	if(isMotherVertex(visited))
		return motherVertex;
		
	return -1;
}

public boolean isMotherVertex(boolean visited[])
{
	for(int i=0; i<N; i++)
		if(!visited[i])
			return false;
	return true;
}

public static void main(String []args)
{
	motherVertex graph = new motherVertex(7);
	graph.addEdge(0, 1);
	graph.addEdge(0, 2);
	graph.addEdge(1, 3);
	graph.addEdge(4, 1);
	graph.addEdge(6, 4);
	graph.addEdge(5, 6);
	graph.addEdge(5, 2);
	graph.addEdge(6, 0);
	//graph.addEdge(4, 0);
	graph.findMotherVertices();
	System.out.println("");
	System.out.println("Result: "+graph.findMotherVerticesOptimized());
}

}
