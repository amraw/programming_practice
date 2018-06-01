package graphs;
import java.util.*;

enum color{WHITE, GRAY,BLACK};

public class GraphCycleUsingColors {
public int N;
public LinkedList<Integer> adjList[];
public GraphCycleUsingColors(int N)
{
	this.N = N;
	adjList = (LinkedList<Integer>[]) new LinkedList[N];
	for(int i=0; i<N; i++)
		adjList[i] = new LinkedList<Integer>();
}

public void addEdge(int src, int dest)
{
	adjList[src].add(dest);
}

public boolean isCycle()
{
	color nodeColor[] = new color[N];
	Arrays.fill(nodeColor, color.WHITE);
	Stack<Integer> stk = new Stack<Integer>();
	for(int i=0; i<N; i++)
	{
		if(nodeColor[i] == color.WHITE && isCycleUtil(i,nodeColor))
		{
			return true;
		}
	}
	return false;
}

public boolean isCycleUtil(int node, color[] nodeColor){
	
	nodeColor[node] = color.GRAY;
	Iterator itr =  adjList[node].iterator();
	while(itr.hasNext())
	{
		int adjNode = (int) itr.next();
		if(nodeColor[adjNode].equals(color.WHITE) && isCycleUtil(adjNode, nodeColor))
			return true;
		else if( nodeColor[adjNode].equals(color.GRAY))
			return true;
	}
	nodeColor[node] = color.BLACK;
	return false;
}


public static void main(String []args)
{
	GraphCycleUsingColors g = new GraphCycleUsingColors(4);
	g.addEdge(0, 1);
	g.addEdge(0, 2);
	g.addEdge(1, 2);
	//g.addEdge(2, 0);
	g.addEdge(2, 3);
	g.addEdge(3, 3);
	
	if(g.isCycle())
	{
		System.out.println("Cycle exist");
	}
	else
		System.out.println("Cycle does not exist");
}

}
