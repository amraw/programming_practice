package tree;

public class countLeafNodes {
	public node root;
	public countLeafNodes(int data){
		root = new node(data);
	}
	
	public int countLeafNode(node root){
		int leafCount = 0;
		if(root == null)
			leafCount= 0;
		else if(root.left == null && root.right == null)
			leafCount = 1;
		else
		{
			leafCount = countLeafNode(root.left)+countLeafNode(root.right);
		}
			return leafCount;
	}

	public static void main(String []args){
		countLeafNodes tree = new countLeafNodes(1);
		tree.root.left = new node(2);
		tree.root.right = new node(3);
		//tree.root.left.left = new node(4);
		tree.root.left.right = new node(5);
		int []path = new int[1000];
		System.out.println("No. of Leaf node: " + tree.countLeafNode(tree.root));
		
	}
}