package tree;
import java.util.*;

import org.omg.CORBA.Current;
public class connectNodeSameLevel {
public node2 root;
public connectNodeSameLevel(int data){
	root = new node2(data);
}

public void connectNodes(node2 root)
{
	LinkedList<node2> queue = new LinkedList<node2>();
	int nodeCount;
	if(root == null)
		return;
	else
	{
		queue.add(root);
		nodeCount = 1;
		while(!queue.isEmpty())
		{
			int iterator = nodeCount;
			nodeCount = 0;
			while(iterator >= 1)
			{
				node2 node1= queue.poll();
				node2 next;
				if(iterator == 1){
					node1.nextRight = null;
				}
				else
				{
					next = queue.peek();
					node1.nextRight = next;
				}
				if(node1.left!=null)
				{
					queue.add(node1.left);
					nodeCount++;
				}
				if(node1.right!=null)
				{
					queue.add(node1.right);
					nodeCount++;
				}
				iterator--;
			}
			 
		}
	}
}


public void printNode(node2 root){
	if(root == null)
		return;
	{
		node2 current = root;
		while(current!=null)
		{
			System.out.print(current.data+" ");
			current = current.nextRight;
		}
		System.out.println("");
		printNode(root.left);
		if(root.left==null)
			printNode(root.right);
	}
}

//Works only for complete binary tree using preorder recursion
public void connectNodes2(node2 root){
	if(root == null)
		return;
	else
	{
		if(root.left !=null)
			root.left.nextRight = root.right;
		if(root.right!=null)
			root.right.nextRight = root.nextRight!=null?root.nextRight.left:null;
		connectNodes2(root.left);
		connectNodes2(root.right);
	}
}

// Modified version of above code which will work for all kinds of tree

public void connect3(node2 root){
	root.nextRight = null;
	connect3Util(root);
}

public void connect3Util(node2 root){
	if(root == null)
		return;
	if(root.nextRight!=null)
		connect3Util(root.nextRight);
	if(root.left!=null)
	{
		if(root.right!=null)
		{
			root.left.nextRight = root.right;
			root.right.nextRight = getNextRight(root);
		}
		else
		{
			root.left.nextRight = getNextRight(root);
		}
		connect3Util(root.left);
	}
	else if(root.right!=null)
	{
		root.right.nextRight = getNextRight(root);
		connect3Util(root.right);
	}
	else
	{
		connect3Util(getNextRight(root));
	}
	
}

// Iterative verstion of the above code
public void connect3Iterative(node2 root){
	if(root == null)
		return ;
	root.nextRight = null;
	while(root != null)
	{
		node2 temp = root;
		while(temp!=null)
		{
			if(temp.left!=null)
			{
				if(temp.right!=null)
				{
					temp.left.nextRight = temp.right;
				}
				else
				{
					temp.left.nextRight = getNextRight(temp);
				}
			}
			if(temp.right!=null)
				temp.right.nextRight = getNextRight(temp);
			temp = temp.nextRight;
		}
		
		if(root.left!=null)
			root = root.left;
		else if(root.right!=null)
			root = root.right;
		else
			root = getNextRight(root);
		
	}
}

public static node2 getNextRight(node2 root){
	node2 currentPtr = root.nextRight;
	while(currentPtr != null)
	{
		if(currentPtr.left!=null)
			return currentPtr.left;
		if(currentPtr.right!=null)
			return currentPtr.right;
		currentPtr = currentPtr.nextRight;
	}
	
	return null;		
}

public static void main(String []args){
	connectNodeSameLevel t = new connectNodeSameLevel(26);
	t.root.left = new node2(10);
	t.root.right = new node2(3);
	t.root.left.left = new node2(4);
	//t.root.left.right = new node2(6);
	t.root.right.left = new node2(3);
	t.connectNodes(t.root);
	t.printNode(t.root);
	System.out.println("Second Function");
	connectNodeSameLevel t2 = new connectNodeSameLevel(26);
	t2.root.left = new node2(10);
	t2.root.right = new node2(3);
	t2.root.left.left = new node2(4);
	//t2.root.left.right = new node2(6);
	t2.root.right.left = new node2(3);
	t2.connectNodes2(t2.root);
	t2.printNode(t2.root);
	System.out.println("Third Function");
	connectNodeSameLevel t3 = new connectNodeSameLevel(26);
	t3.root.left = new node2(10);
	t3.root.right = new node2(3);
	t3.root.left.left = new node2(4);
	//t2.root.left.right = new node2(6);
	t3.root.right.left = new node2(50);
	t3.connect3Iterative(t3.root);
	t3.printNode(t3.root);
}


}



class node2{
	int data;
	node2 left;
	node2 right;
	node2 nextRight;
	public node2(int data)
	{
		this.data = data;
		left = null;
		right = null;
		nextRight = null;
	}
}