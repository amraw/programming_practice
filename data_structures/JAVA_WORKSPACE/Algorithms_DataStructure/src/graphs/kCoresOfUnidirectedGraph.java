package graphs;
import java.util.*;
public class kCoresOfUnidirectedGraph {
public int N;
public LinkedList<Integer> adjList[];
public kCoresOfUnidirectedGraph(int N)
{
	this.N = N;
	adjList = (LinkedList<Integer>[]) new LinkedList[N];
	for(int i=0; i<N; i++)
		adjList[i] = new LinkedList<Integer>();
}
public void addEdge(int x, int y){
	adjList[x].add(y);
	adjList[y].add(x);
}

public void kCoresOfUnidirectedGraphFind(int k)
{
	HashSet<Integer> set = new HashSet<Integer>();
	int nodeDegree[] = new int[N];
	for(int i=0; i<N; i++)
	{
		nodeDegree[i] = adjList[i].size();
		if(nodeDegree[i]<k)
			set.add(i);
	}
	int size = -1;
	while(!set.isEmpty())
	{
		for(int i=0; i<N; i++)
		if(set.contains(i) && adjList[i]!=null)
		{
			Iterator itr = adjList[i].iterator();
			while(itr.hasNext())
			{
				int adjNode = (int) itr.next();
				nodeDegree[adjNode]--;
				adjList[adjNode].remove(new Integer(i));
			}
			adjList[i] = null;
			set.remove(i);
		}
		for(int i=0; i<N; i++)
		{
			if(nodeDegree[i] < k && adjList[i]!=null)
			{
				set.add(i);
			}
		}
	}
	
	for(int i=0; i<N; i++)
	{
		if(adjList[i]!=null)
		{
			System.out.print("["+i+"]");
			Iterator itr = adjList[i].iterator();
			while(itr.hasNext())
			{
				System.out.print("->"+itr.next());
			}
			System.out.println("");
		}
	}
		
	
}

public void kCoresOfUnidirectedGraphFind2(int k)
{
	boolean visited[] = new boolean[N];
	Arrays.fill(visited, false);
	int minDeg = Integer.MAX_VALUE;
	int nodeDegree[] = new int[N];
	int startIndex = 0;
	for(int i=0; i<N; i++)
	{
		nodeDegree[i] = adjList[i].size();
		if(nodeDegree[i] < minDeg)
		{
			minDeg = nodeDegree[i];
			startIndex=i;
		}
			
	}
	DFSUtil(startIndex,visited,nodeDegree,k);
	
	for(int i=0; i<N; i++)
		if(!visited[i])
			DFSUtil(i,visited,nodeDegree,k);
	
	for(int i=0; i<N; i++)
	{
		if(nodeDegree[i] >=k)
		{
			System.out.print("["+i+"]");
			Iterator itr = adjList[i].iterator();
			while(itr.hasNext())
			{
				int adjNode = (int) itr.next();
				if(nodeDegree[adjNode] >=k)
					System.out.print("->"+adjNode);
			}
			System.out.println("");
		}
		
	}
}

public boolean DFSUtil(int node, boolean []visited, int []nodeDegree, int k)
{
	visited[node] = true;
	Iterator itr = adjList[node].iterator();
	while(itr.hasNext())
	{
		int adjNode = (int) itr.next();
			
		if(nodeDegree[node] < k)
			nodeDegree[adjNode]--;
		if(!visited[adjNode])
		{
			if(DFSUtil(adjNode,visited,nodeDegree,k))
				nodeDegree[adjNode]--;
		}
			
		
	}
	return nodeDegree[node] < k;
}



public static void main(String []args)
{
	kCoresOfUnidirectedGraph graph =  new kCoresOfUnidirectedGraph(9);
	graph.addEdge(0, 1);
	graph.addEdge(0, 2);
	graph.addEdge(1, 2);
	graph.addEdge(1, 5);
	graph.addEdge(2, 3);
	graph.addEdge(2, 4);
	graph.addEdge(2, 5);
	graph.addEdge(2, 6);
	graph.addEdge(3, 4);
	graph.addEdge(3, 6);
	graph.addEdge(3, 7);
	graph.addEdge(4, 6);
	graph.addEdge(4, 7);
	graph.addEdge(5, 6);
	graph.addEdge(5, 8);
	graph.addEdge(6, 7);
	graph.addEdge(6, 8);
	System.out.println("DFS ALGO 1");
	graph.kCoresOfUnidirectedGraphFind2(3);
	System.out.println("DFS ALGO 2");
	graph.kCoresOfUnidirectedGraphFind(3);
	System.out.println("Second Input");
	kCoresOfUnidirectedGraph graph2 =  new kCoresOfUnidirectedGraph(13);
	graph2.addEdge(0, 1);
	graph2.addEdge(0, 2);
	graph2.addEdge(0, 3);
	graph2.addEdge(1, 4);
	graph2.addEdge(1, 5);
	graph2.addEdge(1, 6);
	graph2.addEdge(2, 7);
	graph2.addEdge(2, 8);
	graph2.addEdge(2, 9);
	graph2.addEdge(3, 10);
	graph2.addEdge(3, 11);
	graph2.addEdge(3, 12);
	graph2.kCoresOfUnidirectedGraphFind(3);
}

}
