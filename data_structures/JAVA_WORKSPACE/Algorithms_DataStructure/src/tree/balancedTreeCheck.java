package tree;
public class balancedTreeCheck {
public node root;
public balancedTreeCheck(int data){
	root = new node(data);
}
public boolean isBalanced(node root){
	boolean result = false;
	if(root == null)
	{
		result = true;
	}
	else
	{
		if(Math.abs(treeHeight(root.left) - treeHeight(root.right) ) < 1 && isBalanced(root.left) && isBalanced(root.right))
		{
			result=true;
		}
	}
	return result;
}
public int treeHeight(node root){
	int height = 0;
	if(root == null)
	{
		height = 0;
	}
	else
	{
		height = 1+ Math.max(treeHeight(root.left), treeHeight(root.right));
	}
	return height;
}


public static void main(String []args){
	balancedTreeCheck tree = new balancedTreeCheck(1);
	tree.root.left = new node(2);
	tree.root.right = new node(3);
	//tree.root.left.left = new node(4);
	//tree.root.left.right = new node(5);
	tree.root.right.left = new node(6);
	tree.root.right.right = new node(7);
	//tree.root.left.left.left = new node(8);
	tree.root.right.right.right = new node(9);
	if(tree.isBalanced(tree.root)){
		System.out.println("Balanced Tree");
	}
	else
	{
		System.out.println("Not Balanced Tree");
	}
}

}
