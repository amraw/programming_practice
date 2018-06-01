package tree;

public class diameterOfTree {
	public node root;
	public diameterOfTree(int data){
		root = new node(data);
	}
	
	public int diameterofTree(node root){
		int diameter = 0;
		if(root == null)
		{
			diameter= 0;
		}
		else if(root.left == null && root.right == null)
		{
			diameter = 1;
		}
		
		else
		{
			int leftDiameter=diameterofTree(root.left);
			int rightDiameter=diameterofTree(root.right);
			int leftHeight=heightTree(root.left);
			int rightHeight=heightTree(root.right);
			diameter = leftHeight+rightHeight+1;
			if(diameter <  leftDiameter){
				diameter = leftDiameter;
			}
			if(diameter<rightDiameter)
				diameter=rightDiameter;
		}
		return diameter;
	}
	
	public int heightTree(node root){
		int height = 0;
		if(root == null)
		{
			height = 0;
		}
		else
		{
			int heightLeft = heightTree(root.left);
			int heightRight = heightTree(root.right);
			height = heightLeft>heightRight? heightLeft+1:heightRight+1;
		}
		return height;
	}
	
	public static void main(String []args){
		diameterOfTree tree = new diameterOfTree(1);
		tree.root.left = new node(2);
		tree.root.right = new node(3);
		tree.root.left.left = new node(4);
		tree.root.left.right = new node(5);
		System.out.println("Diameter of Tree: "+ tree.diameterofTree(tree.root));
	}
	
}