package tree;

public class convertToSumTree {
public node root;
public convertToSumTree(int data){
	root = new node(data);
}

public int convertTreeToItsSumTree(node root)
{
	if(root == null)
		return 0;
	int old_value = root.data;
	root.data = convertTreeToItsSumTree(root.left)+convertTreeToItsSumTree(root.right);
	return old_value+root.data;
}

public void printInorder(node root){
	if(root == null)
		return ;
	printInorder(root.left);
	System.out.print(root.data+" ");
	printInorder(root.right);
}

public static void main(String []args){
	convertToSumTree t = new convertToSumTree(10);
	t.root.left = new node(-2);
	t.root.right = new node(6);
	t.root.left.left = new node(8);
	t.root.left.right = new node(-4);
	t.root.right.left = new node(7);
	t.root.right.right = new node(5);
	t.convertTreeToItsSumTree(t.root);
	t.printInorder(t.root);
}

}
