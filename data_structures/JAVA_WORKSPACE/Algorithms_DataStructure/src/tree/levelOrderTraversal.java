package tree;

import java.util.*;

public class levelOrderTraversal {
	public node root ;
	public levelOrderTraversal(int rootdata){
		root = new node(rootdata);
	}
	
	int heightOfTree(node root){
		int height = 0;
		int heightleft = 0;
		int heightright = 0;
		if(root == null)
			height= 0;
		else if(root.left == null && root.right ==null)
			height = 1;
		else
		{
			heightleft = 1 + heightOfTree(root.left);
			heightright =1 + heightOfTree(root.right);
			height = heightleft > heightright ? heightleft:heightright;
		}
		return height;
		
	}
	
	public void LOT2(node root){
		if(root == null)
			return ;
		int height = heightOfTree(root);
		for(int i=1; i <= height; i++){
			printLOT2(root,i);
			
		}
	}
	
	public void printLOT2(node root, int i)
	{
		if(i == 1)
			System.out.print(root.data+" ");
		else
		{
			if(root.left != null)
				printLOT2(root.left,i-1);
			if(root.right != null)
				printLOT2(root.right,i-1);
		
		}
	}
	
	public void LOT(node root){
		LinkedList<node> queue = new LinkedList<node>();
		Iterator<node>itr = queue.listIterator();
		if(root!=null)
		{
			queue.add(root);
		}
		else
		{
			return ;
		}
		while(!queue.isEmpty())
		{
			node tmp = queue.poll();
			System.out.print(tmp.data + " ");
			if(tmp.left !=null)
				queue.add(tmp.left);
			if(tmp.right != null)
				queue.add(tmp.right);
		}
	}
	
	public void printLOTPerLine(node root){
		LinkedList<node> queue = new LinkedList<node>();
		int nodeCount;
		if(root !=null)
		{
			queue.add(root);
			nodeCount = 1;
			while(!queue.isEmpty()){
				int i = nodeCount;
				nodeCount = 0;
				while(i > 0){
					node tmp = queue.poll();
					System.out.print(tmp.data+" ");
					if(tmp.left !=null)
					{
						queue.add(tmp.left);
						nodeCount++;
					}
					if(tmp.right !=null)
					{
						queue.add(tmp.right);
						nodeCount++;
					}
					i--;
					}
				System.out.println("");
			}
		}
	}
	
	public void printLOTPerLine2(node root){
		if(root == null)
			return ;
		int height = heightOfTree(root);
		for(int i=1; i <= height; i++){
			printLOT2(root,i);
			System.out.println("");
		}
	}
	
	public static void main(String []args){
		levelOrderTraversal levelTraverse = new levelOrderTraversal(1);
		levelTraverse.root.left = new node(2);
		levelTraverse.root.right = new node(3);
		levelTraverse.root.left.left = new node(4);
		levelTraverse.root.left.right = new node(5);
		levelTraverse.root.right.left = new node(6);
		levelTraverse.root.right.right = new node(7);
		levelTraverse.LOT(levelTraverse.root);
		System.out.println("");
		levelTraverse.LOT2(levelTraverse.root);
		System.out.println("");
		levelTraverse.printLOTPerLine(levelTraverse.root);
		System.out.println("");
		levelTraverse.printLOTPerLine2(levelTraverse.root);
	}

}