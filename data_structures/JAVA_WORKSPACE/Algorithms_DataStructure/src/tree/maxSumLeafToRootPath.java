package tree;
import java.util.*;
public class maxSumLeafToRootPath {
public node root;
public maxSumLeafToRootPath(int data){
	root = new node(data);
}

public int findmaxSumLeafToRootPath(node root){
	if(root == null)
		return 0;
	else
	{
		return root.data+Math.max(findmaxSumLeafToRootPath(root.left), findmaxSumLeafToRootPath(root.right));
	}
		
}

public boolean printPath(node root, int sum)
{
	if(root==null)
		return false;
	else if(root.left==null && root.right==null && sum-root.data==0)
	{
		System.out.print(""+root.data);
		return true;
	}
	else
	{
		if(printPath(root.left,sum-root.data) || printPath(root.right,sum-root.data))
		{
			System.out.print("->"+root.data);
			return true;
		}
	}
	return false;
}

public static void main(String []args){
	ArrayList<node> list = new ArrayList<node>();
	maxSumLeafToRootPath t = new maxSumLeafToRootPath(10);
	t.root.left = new node(-2);
	t.root.right = new node(7);
	t.root.left.left = new node(8);
	t.root.left.right = new node(-4);
	int sum = t.findmaxSumLeafToRootPath(t.root);
	System.out.println("Max sum: "+sum);
	t.printPath(t.root, sum);
}

}
