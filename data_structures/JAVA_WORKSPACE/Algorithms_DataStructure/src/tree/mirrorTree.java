package tree;

import java.util.LinkedList;

public class mirrorTree {

	public node root;
	public mirrorTree(int data){
		root = new node(data);
	}
	
	public void mirro(node root){
		if(root == null)
			return;
		else
		{
			mirro(root.left);
			mirro(root.right);
			node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		
		
	}
	public void printInorder(node root){
		if(root == null)
			return ;
		printInorder(root.left);
		System.out.print(root.data+" ");
		printInorder(root.right);
	}
	
	public static void main(String []args){
		mirrorTree tree = new mirrorTree(1);
		tree.root.left = new node(2);
		tree.root.right = new node(3);
		tree.root.left.left = new node(4);
		tree.root.left.right = new node(5);
		tree.printInorder(tree.root);
		System.out.println("");
		tree.mirro(tree.root);
		tree.printInorder(tree.root);
	}
	
}
