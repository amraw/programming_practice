package tree;

public class sameTree {
public node root;
public sameTree(int data){
	root = new node(data);
}

public boolean treeSame(node root1, node root2){
	boolean result = false;
	if(root1 == root2)
	{
		result = true;
	}
	else if((root1!= null && root2!= null) && (root1.data == root2.data))
	{
		result = treeSame(root1.left, root2.left) && treeSame(root1.right, root2.right);
	}
	
	return result;
}


public static void main(String []args){
	sameTree tree1 = new sameTree(1);
	sameTree tree2 = new sameTree(1);
	
	tree1.root.left = new node(2);
	tree1.root.right = new node(3);
	tree1.root.left.left = new node(4);
	tree1.root.left.right = new node(5);
	
	tree2.root.left = new node(2);
	tree2.root.right = new node(3);
	tree2.root.left.left = new node(4);
	tree2.root.left.right = new node(5);
	if(tree1.treeSame(tree1.root, null)){
		System.out.println("Tree are same");
	}
	else
	{
		System.out.println("Tree are not same");
	}
}
}