package tree;

public class holdsChildrenSumProperty {
public node root;
public holdsChildrenSumProperty(int data){
	root = new node(data);
}

public void childrenSumTree(node root){
	int leftData = 0;
	int rightData = 0;
	if(root == null || (root.left==null && root.right==null) )
		return ;
	else
	{
		childrenSumTree(root.left);
		childrenSumTree(root.right);
		
		if(root.left!=null)
			leftData = root.left.data;
		if(root.right!=null)
			rightData = root.right.data;
		int diff =  (leftData+rightData) - root.data;
		if(diff>0)
			root.data +=diff;
		if(diff<0)
			increment(root,-diff);
			
	}
}

public void increment(node root, int diff){
	if(root.left!=null)
	{
		root.left.data += diff;
		increment(root.left,diff);
	}
	else
	{
		root.right.data+=diff;
		increment(root.right,diff);
	}
	
}

public void printPreorder(node root){
	if(root == null)
		return ;
	System.out.print(root.data+" ");
	printPreorder(root.left);
	printPreorder(root.right);
}

public static void main(String []args){
	holdsChildrenSumProperty tree = new holdsChildrenSumProperty(1);
	tree.root.left = new node(2);
	tree.root.right = new node(3);
	tree.root.left.left = new node(4);
	tree.root.left.right = new node(5);
	tree.root.right.left = new node(6);
	tree.root.right.right = new node(7);
	tree.root.left.left.left = new node(8);
	tree.root.right.right.right = new node(9);
	tree.printPreorder(tree.root);
	System.out.println("");
	tree.childrenSumTree(tree.root);
	tree.printPreorder(tree.root);
}

}