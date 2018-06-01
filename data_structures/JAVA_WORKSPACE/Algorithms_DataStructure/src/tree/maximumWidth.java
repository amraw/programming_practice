package tree;

import java.util.*;

public class maximumWidth {
public node root;
public maximumWidth(int data){
	root = new node(data);
}
public int maxTreeWidth(node root){
	int max = 0;
	if(root == null)
		max = 0;
	else
	{
		int iterator = 0;
		int noNode = 0;
		LinkedList<node> queue = new LinkedList<>();
		queue.add(root);
		noNode = 1;
		while(!queue.isEmpty()){
			if(noNode>max)
				max = noNode;
			iterator = noNode;
			noNode = 0;
			while(iterator>0)
			{
				node current = queue.poll();
				if(current.left!=null)
				{
					queue.add(current.left);
					noNode++;
				}
				if(current.right!=null){
					queue.add(current.right);
					noNode++;
				}
				iterator--;
			}
		}
	}
	return max;
	
}

public int height(node root){
	int height = 0;
	if(root == null)
		height = 0;
	else{
		height = Math.max(height(root.left), height(root.right)) + 1;
	}
	
	return height;
}

public int preOrderMaxTreeWidth(node root){
	int max = 0;
	if(root == null)
		max = 0;
	else
	{
		int height = height(root); 
		int []widthAtLevel = new int[height];
		preOrderMaxTreeRecursion(root,height,0,widthAtLevel);
		max = searchMax(widthAtLevel);
	}
	return max;
}

public void preOrderMaxTreeRecursion(node root, int maxLevel,int level, int []widthAtLevel){
	if(root==null)
		return;
	else
	{
		
		preOrderMaxTreeRecursion(root.left,maxLevel,level+1,widthAtLevel);
		widthAtLevel[level]++;
		preOrderMaxTreeRecursion(root.right,maxLevel,level+1,widthAtLevel);
	}
}

public int searchMax(int []array){
	int max = 0;
	for(int i=0; i<array.length; i++)
	{
		max = Math.max(array[i], max);
	}
	return max;
}

public static void main(String []args){
	maximumWidth t = new maximumWidth(1);
	t.root.left = new node(2);
	t.root.right = new node(3);
	t.root.left.left = new node(4);
	t.root.left.right = new node(5);
	t.root.right.left = new node(6);
	t.root.right.right = new node(9);
	t.root.left.left.left = new node(7);
	t.root.left.left.right = new node(8);
	System.out.println("Max Tree width: "+t.maxTreeWidth(t.root));
	System.out.println("Max Tree width: "+t.preOrderMaxTreeWidth(t.root));
}

}