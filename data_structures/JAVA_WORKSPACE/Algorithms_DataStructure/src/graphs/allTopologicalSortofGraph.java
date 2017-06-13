package graphs;
import java.util.*;
public class allTopologicalSortofGraph {
int N;
LinkedList<Integer> adjList[];
int nodeDegree[];
public allTopologicalSortofGraph(int N)
{
	this.N = N;
	adjList = (LinkedList<Integer>[]) new LinkedList[N];
	for(int i=0; i<N; i++)
		adjList[i] = new LinkedList<Integer>();
	nodeDegree = new int[N];
	Arrays.fill(nodeDegree, 0);
}

public void addEdge(int x, int y)
{
	adjList[x].add(y);
	nodeDegree[y]++;
}

public void printAllTopologicalSort()
{
	boolean visited[] = new boolean [N];
	Arrays.fill(visited, false);
	ArrayList<Integer> result = new ArrayList<Integer>();
	printAllTopologicalSortUtil(result, visited);
	
}

public void printAllTopologicalSortUtil(ArrayList<Integer> result , boolean visited[])
{
	boolean flag = false;
	for(int i =0; i<N; i++)
	{
		if(nodeDegree[i]==0 && !visited[i])
		{
			Iterator itr = adjList[i].iterator();
			while(itr.hasNext())
			{
				int adjNode = (int) itr.next();
				nodeDegree[adjNode]--;
			}
			visited[i] = true;
			result.add(i);
			printAllTopologicalSortUtil(result,visited);
			visited[i] = false;
			result.remove(result.size()-1);
			itr = adjList[i].iterator();
			while(itr.hasNext())
			{
				int adjNode = (int) itr.next();
				nodeDegree[adjNode]++;
			}
			flag = true;
		}
	}
	
	if(!flag)
	{
		Iterator itr = result.iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+" ");
		}
		System.out.println("");
	}
}

public static void main(String[] args)
{
	allTopologicalSortofGraph g = new allTopologicalSortofGraph(6);
	g.addEdge(5,2);
	g.addEdge(5,0);
	g.addEdge(4,0);
	g.addEdge(4,1);
	g.addEdge(2,3);
	g.addEdge(3,1);
	
	g.printAllTopologicalSort();
}

}
