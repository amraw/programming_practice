package tree;
import java.util.*;
public class spiralLevelTraversal {
public node root;
public spiralLevelTraversal(int data){
	root = new node(data);
}

public int height(node root){
	int height = 0;
	if(root == null)
		height = 0;
	else
	{
		int lheight = 1+height(root.left);
		int rheight = 1+height(root.right);
		height = rheight>lheight?rheight:lheight;
	}
	return height;
}

public void spiralLevelOrderRecursive(node root){
	int treeHeight = height(root);
	boolean flip = false;
	for(int i=1; i <= treeHeight; i++)
	{
		spiralLevelOrderRecursiveUtil(root, i, flip);
		flip= !flip;
	}
}

public void spiralLevelOrderRecursiveUtil(node root, int height, boolean flip){
	if(root == null)
		return ;
	else if(root != null && height ==1)
	{
		System.out.print(root.data + " ");
	}
	else
	{
		if(flip){
			spiralLevelOrderRecursiveUtil(root.left,height-1,flip);
			spiralLevelOrderRecursiveUtil(root.right,height-1,flip);
		}
		else
		{
			spiralLevelOrderRecursiveUtil(root.right,height-1,flip);
			spiralLevelOrderRecursiveUtil(root.left,height-1,flip);
		}
	}
}

public void spiralLevelOrder(node root){
	Stack<node> s1 = new Stack<node>();
	Stack<node> s2 = new Stack<node>();
	if(root == null){
		return ;
	}
	else
	{
		s2.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				node current = s1.pop();
				System.out.print(current.data + " ");
				if(current.left!=null)
					s2.push(current.left);		
				if(current.right!=null)
					s2.push(current.right);
			}
		
			while(!s2.isEmpty()){
				node current = s2.pop();
				System.out.print(current.data + " ");
				if(current.right!=null)
					s1.push(current.right);
				if(current.left!=null)
					s1.push(current.left);
			}
		}
	}
}

public static void main(String []args){
	spiralLevelTraversal tree = new spiralLevelTraversal(1);
	tree.root.left = new node(2);
	tree.root.right = new node(3);
	tree.root.left.left = new node(4);
	tree.root.left.right = new node(5);
	tree.root.right.left = new node(6);
	tree.root.right.right = new node(7);
	tree.root.left.left.left = new node(8);
	tree.root.right.right.right = new node(9);
	tree.spiralLevelOrderRecursive(tree.root);
	System.out.println("");
	tree.spiralLevelOrder(tree.root);
}

}