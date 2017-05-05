package tree;

public class doubleTree {
public node root;
public doubleTree(int data){
	root  = new node(data);
}

public void doubleTree(node root)
{
	if(root == null)
		return;
	else
	{
		doubleTree(root.left);
		doubleTree(root.right);
		node tmp = root.left;
		root.left = new node(root.data);
		root.left.left = tmp;
	}
			
}
public void printInorder(node root){
	if(root == null)
		return ;
	printInorder(root.left);
	System.out.print(root.data+" ");
	printInorder(root.right);
}

public static void main(String []args){
	doubleTree t = new doubleTree(1);
	t.root.left = new node(2);
	t.root.right = new node(3);
	t.root.left.left = new node(4);
	t.root.left.right = new node(5);
	t.doubleTree(t.root);
	t.printInorder(t.root);
}
}