package tree;

public class treeTraversal {
	node root;
	public treeTraversal(int rootData){
		root = new node(rootData);
	}
	
	public void printInorder(node root){
		if(root == null)
			return ;
		printInorder(root.left);
		System.out.print(root.data+" ");
		printInorder(root.right);
	}
	
	public void printPreorder(node root){
		if(root == null)
			return ;
		System.out.print(root.data+" ");
		printInorder(root.left);
		printInorder(root.right);
	}
	
	public void printPostorder(node root){
		if(root == null)
			return ;
		printInorder(root.left);
		printInorder(root.right);
		System.out.print(root.data+" ");
	}
	
	public node getRoot(){
		return root;
	}
	
	public static void main(String []args){
		treeTraversal tree = new treeTraversal(1);
		node root = tree.getRoot();
		root.left = new node(2);
		root.right = new node(3);
		root.left.left = new node(4);
		root.left.right = new node(5);
		
		tree.printInorder(root);
		System.out.println("");
		tree.printPreorder(root);
		System.out.println("");
		tree.printPostorder(root);
		
	}

}


class node{
	int data;
	node left;
	node right;
	public node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
