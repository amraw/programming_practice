package graphs;


import java.util.Iterator;
import java.util.LinkedList;

public class cycleInUnidirectedGraphUsingDFS {
public int N;
public LinkedList<Integer> adjList[];
public cycleInUnidirectedGraphUsingDFS(int N)
{
	this.N = N;
	adjList =  (LinkedList<Integer>[]) new LinkedList[N];
	for(int i=0; i<N; i++)
		adjList[i] = new LinkedList<Integer>();
}
public boolean isCycleUtil(int node, boolean visited[], int parent)
{ 
		visited[node] = true;
		Iterator itr = adjList[node].iterator();
		while(itr.hasNext())
		{
			int adjNode = (int) itr.next();
			if(!visited[adjNode])
			{
				if(isCycleUtil(adjNode,visited,node))
					return true;
			}
			else if(visited[adjNode] && adjNode!=parent)
				return true;
		}
		
	return false;
}

public boolean isCycle()
{
	boolean visited[] = new boolean[N];
	for(int i=0; i<N; i++)
		visited[i] = false;
	for(int i=0; i<N; i++)
	{
		if(!visited[i] && isCycleUtil(i,visited,-1))
		{
			return true;
		}
	}
	return false;
}

public void add(int x, int y){
	adjList[x].add(y);
	adjList[y].add(x);
}

public static void main(String []args){
	cycleInUnidirectedGraphUsingDFS  graphs = new cycleInUnidirectedGraphUsingDFS(3);
	graphs.add(0, 1);
	graphs.add(1, 2);
	//graphs.add(2,0);
	if(graphs.isCycle())
		System.out.println("Cycle Present");
	else
		System.out.println("Cycle not present");
}

}
