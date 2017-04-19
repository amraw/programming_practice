package tree;

public class treeDelete {
public node root;
public treeDelete(int data){
	root = new node(data);
}
public void deleteTree(node root){
	if(root == null)
		return;
	else
	{
		deleteTree(root.left);
		deleteTree(root.right);
		root = null;
	}
}

public static void main(String []args){
	treeDelete tree = new treeDelete(1);
	tree.root.left = new node(2);
	tree.root.right = new node(3);
	tree.root.left.left = new node(4);
	tree.root.left.right = new node(5);
	tree.deleteTree(tree.root);
	
}

}