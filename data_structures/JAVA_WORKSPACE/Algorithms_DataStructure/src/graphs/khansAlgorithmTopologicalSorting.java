package graphs;
import java.util.*;
public class khansAlgorithmTopologicalSorting {
public int N;
public LinkedList<Integer>adjList[];
public int nodeInDegree[];
public khansAlgorithmTopologicalSorting(int N)
{
	this.N = N;
	adjList = (LinkedList<Integer>[]) new LinkedList[N];
	for(int i=0; i<N; i++)
		adjList[i] = new LinkedList<Integer>();
	nodeInDegree = new int[N];
	Arrays.fill(nodeInDegree, 0);
}
public void addEdge(int src, int dest)
{
	adjList[src].add(dest);
	nodeInDegree[dest]++;
}

public void topologicalSort()
{
	ArrayList<Integer> topOrder = new ArrayList<Integer>();
	LinkedList<Integer> queue = new LinkedList<Integer>();
	int count=0;
	for(int i =0; i<N; i++)
	{
		if(nodeInDegree[i] == 0)
			queue.addLast(i);
	}
	while(!queue.isEmpty())
	{
		int top = queue.removeFirst();
		Iterator itr = adjList[top].iterator();
		topOrder.add(top);
		while(itr.hasNext())
		{
			int adjNode = (int) itr.next();
			if(--nodeInDegree[adjNode] == 0)
			{
				queue.addLast(adjNode);
			}
		}
		count++;
	}
	if(count !=N)
		System.out.println("There is cycle in the graph");
	else
	{
		Iterator itr = topOrder.iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+" ");
		}
	}
}

public static void main(String []args)
{
	khansAlgorithmTopologicalSorting g = new khansAlgorithmTopologicalSorting(6);
	g.addEdge(5,2);
	g.addEdge(5,0);
	g.addEdge(4,0);
	g.addEdge(4,1);
	g.addEdge(2,3);
	g.addEdge(3,1);
	g.topologicalSort();
}

}