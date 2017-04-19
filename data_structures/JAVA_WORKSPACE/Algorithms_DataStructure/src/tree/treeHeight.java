package tree;

public class treeHeight {
	public node root;
	public treeHeight(int data){
		root = new node(data);
	}
	
	public int heightTree(node root){
		int height = 0;
		if(root == null)
			height = 0;
		else
		{
			int left = heightTree(root.left)+1;
			int right = heightTree(root.right)+1;
			height = left>right? left:right;
		}
		return height;
	}
	
	public static void main(String []args){
		treeHeight tree = new treeHeight(1);
		tree.root.left = new node(2);
		tree.root.right = new node(3);
		tree.root.left.left = new node(4);
		tree.root.left.right = new node(5);
		
		System.out.print("Height of tree " + tree.heightTree(tree.root));
		
	}

}