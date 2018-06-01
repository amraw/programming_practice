package tree;

public class RootToLeafPathEqualToANumber {
public node root;
public RootToLeafPathEqualToANumber(int data){
	root = new node(data);
}
public boolean sumPathExist(node root, int sum)
{
	boolean ans = false;
	if(root == null)
	{
		ans = (sum==0);
	}
	else if((sum - root.data)==0 && root.left==null && root.right==null)
	{
		ans = true;
	}
	else
	{
		int subsum = sum-root.data;
		if(root.left!=null)
			ans = ans || sumPathExist(root.left,subsum);
		if(root.right!=null)
			ans = ans || sumPathExist(root.right,subsum);
	}
	return ans;
}

public static void maint(String []args){
	RootToLeafPathEqualToANumber tree = new RootToLeafPathEqualToANumber(1);
	tree.root.left = new node(2);
	tree.root.right = new node(3);
	tree.root.left.left = new node(4);
	tree.root.left.right = new node(5);
	tree.root.right.left = new node(6);
	tree.root.right.right = new node(7);
	tree.root.left.left.left = new node(8);
	tree.root.right.right.right = new node(9);
	if(tree.sumPathExist(tree.root, 8))
		System.out.println("Sum path exist");
	else
		System.out.println("Sum path does not exist");
}
}
