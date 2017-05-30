package graphs;
import java.util.*;
public class DFSIterative {
public int N;
public LinkedList<Integer> adjList[];
public DFSIterative(int N){
	this.N = N;
	adjList = (LinkedList<Integer>[]) new LinkedList[N];
	for(int i=0; i<N; i++)
		adjList[i]= new LinkedList<Integer>();
}

public void addEdge(int x, int y)
{
	adjList[x].add(y);
}

/* Unoptimized Solution
 * public void DFSIterativeSolution()
{
	boolean visited[] = new boolean[N];
	Arrays.fill(visited, false);
	Stack<Integer> stk = new Stack<Integer>();
	for(int i=0; i<N; i++)
	{
		if(!visited[i])
		{
			visited[i]=true;
			stk.push(i);
			System.out.print(i+" ");
			while(!stk.isEmpty())
			{
				int popNode = stk.pop();
				Iterator itr = adjList[popNode].iterator();
				while(itr.hasNext())
				{
					int adjNode = (int) itr.next();
					if(!visited[adjNode])
					{
						visited[adjNode] = true;
						stk.push(popNode);
						stk.push(adjNode);
						System.out.print(adjNode+" ");
					}
				}
			}
		}
	}
}*/

// Optimized iterative DFS

public void DFSIterativeSolution()
{
	boolean visited[] = new boolean[N];
	Arrays.fill(visited, false);
	
	for(int i=0; i<N; i++)
		if(!visited[i])
		{
			DFSIterativeUtil(visited,i);
		}
	
}

public void DFSIterativeUtil(boolean visited[], int source){
	Stack<Integer> stk = new Stack<Integer>();
	stk.push(source);
	while(!stk.isEmpty())
	{
		int popNode = stk.peek();
		stk.pop();
		if(!visited[popNode])
		{
			visited[popNode] = true;
			System.out.print(popNode+" ");
		}
		Iterator itr = adjList[popNode].iterator();
		while(itr.hasNext())
		{
			int adjNode = (int) itr.next();
			if(!visited[adjNode])
			{
				stk.push(adjNode);
			}
		}
	}
}

public static void main(String []args)
{
	DFSIterative g = new DFSIterative(4);
	g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    g.DFSIterativeSolution();
}

}
