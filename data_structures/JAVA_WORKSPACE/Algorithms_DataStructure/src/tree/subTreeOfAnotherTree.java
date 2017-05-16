package tree;

public class subTreeOfAnotherTree {
public node root;
public subTreeOfAnotherTree(int data){
	root = new node(data);
}
public boolean isSubTree(node root1, node root2)
{
	
	if(root2== null)
		return true;
	else if(root1 == null)
		return false;
	else if(equalTree(root1,root2))
		return true;
	else
		return isSubTree(root1.left,root2) || isSubTree(root1.right,root2);
	
}

public boolean equalTree(node root1, node root2)
{
	if(root1 == null && root2==null)
		return true;
	else if((root1!=null && root2==null) || (root1==null && root2!=null))
	{
		return false;
	}
	else
	{
		return root1.data==root2.data && equalTree(root1.left,root2.left) && equalTree(root1.right, root2.right);
	}
}

public boolean isSubTree2(node root1, node root2){
	String parentTreeInOrder = null;
	String parentTreePreOrder = null;
	String subTreeInOrder = null;
	String subTreePreOrder = null;
	
	parentTreeInOrder = treeInOrder(root1);
	subTreeInOrder = treeInOrder(root2);
	parentTreePreOrder=treePreOrder(root1);
	subTreePreOrder=treePreOrder(root2);
	
	if(subTreeInOrder.isEmpty())
		return true;
	
	if(parentTreeInOrder!=null && parentTreePreOrder!=null && parentTreeInOrder.contains(subTreeInOrder) && parentTreePreOrder.contains(subTreePreOrder))
	{
		return true;
	}
	else
	{
		return false;
	}
	
}

public String treeInOrder(node root)
{
	if(root == null)
		return "";
	else if( root.left == null && root.right==null)
	{
		return root.data+"";
	}
	else
	{
		return treeInOrder(root.left)+root.data+treeInOrder(root.right);
	}
}

public String treePreOrder(node root)
{
	if(root == null)
		return "";
	else if( root.left == null && root.right==null)
	{
		return root.data+"";
	}
	else
	{
		return root.data+treePreOrder(root.left)+treePreOrder(root.right);
	}
}


public static void main(String []args){
	subTreeOfAnotherTree t = new subTreeOfAnotherTree(26);
	t.root.left = new node(10);
	t.root.right = new node(3);
	t.root.left.left = new node(4);
	t.root.left.right = new node(6);
	t.root.right.left = new node(3);
	
	subTreeOfAnotherTree t2 = new subTreeOfAnotherTree(10);
	t2.root.left = new node(4);
	t2.root.right = new node(6);
	
	if(t.isSubTree(t.root, t2.root)){
		System.out.println("Tree 2 subtree of Tree1");
	}
	else
	{
		System.out.println("Tree 2 is not subtree of Tree1");
	}
	
	if(t.isSubTree2(t.root, t2.root)){
		System.out.println("Tree 2 subtree of Tree1");
	}
	else
	{
		System.out.println("Tree 2 is not subtree of Tree1");
	}
}

}
