package tree;

public class treeSize {
public node root;
public treeSize(int data){
	root = new node(data);
}

public int size(node root){
	int size = 0;
	if(root == null)
		size = 0;
	else
	{
		size  = size(root.left) + size(root.right)+1;
	}
	return size;
}

public static void main(String []args){
	treeSize tree = new treeSize(1);
	tree.root.left = new node(2);
	tree.root.right = new node(3);
	//tree.root.left.left = new node(4);
	tree.root.left.right = new node(5);
	int size = tree.size(tree.root);
	System.out.println(size + " ");
}
}