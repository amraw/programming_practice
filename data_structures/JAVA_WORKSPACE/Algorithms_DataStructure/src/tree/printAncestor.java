package tree;

public class printAncestor {
public node root;
public printAncestor(int data){
	root = new node(data);
}

public boolean printAncestorNode(node root, int target){
	boolean result = false;
	if(root == null)
		result = false;
	else if(root.data == target)
	{
		result = true;
	}
	else
	{
		result  = printAncestorNode(root.left,target) || printAncestorNode(root.right,target);
		if(result)
		{
			System.out.print(root.data+" ");
		}
	}
	return result;
	
}

public static void main(String []args){
	printAncestor t = new printAncestor(1);
	t.root.left = new node(2);
	t.root.right = new node(3);
	t.root.left.left = new node(4);
	t.root.left.right = new node(5);
	t.root.right.left = new node(6);
	t.root.right.right = new node(9);
	t.root.left.left.left = new node(7);
	t.root.left.left.right = new node(8);
	if(!t.printAncestorNode(t.root, 7))
	{
		System.out.println("Node not found");
	}
}
}
