import java.util.*;
public class test {
private int V;
private LinkedList<Integer> adjList[];
public test(int V)
{
	this.V = V;
	adjList = (LinkedList<Integer>[])new LinkedList[V];
}
public void addEdge(int start, int end)
{
	adjList[start].add(end);
}
public void bfs(int start)
{
	boolean visited[] = new boolean[V];
	Arrays.fill(visited, false);
	LinkedList<Integer>queue = new LinkedList<Integer>();
}
}
