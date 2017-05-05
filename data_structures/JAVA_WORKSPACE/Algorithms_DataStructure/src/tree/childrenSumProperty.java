package tree;

public class childrenSumProperty {
	public node root;
	public childrenSumProperty(int data){
		root = new node(data);
		
	}
	
	public int childrenSumProperty(node root){
		int result = 0;
		if(root == null || (root.left==null && root.right==null))
			result = 1;
		else
		{
			int leftData = 0;
			int rightData = 0;
			if(root.left!=null)
				leftData = root.left.data;
			if(root.right!=null)
				rightData = root.right.data;
			if((root.data == (leftData+rightData)) && childrenSumProperty(root.left)!=0 && childrenSumProperty(root.right)!=0)
				result= 1;
			else
				result= 0;
		}
		
		return result;
	}
	
	public static void main(String []args){
		childrenSumProperty tree = new childrenSumProperty(10);
		tree.root.left = new node(8);
		tree.root.right = new node(2);
		tree.root.left.left = new node(3);
		tree.root.left.right = new node(5);
		tree.root.right.left = new node(2);
		//tree.root.right.right = new node(7);
		//tree.root.left.left.left = new node(8);
		//tree.root.right.right.right = new node(9);
		if(tree.childrenSumProperty(tree.root) != 0)
		{
			System.out.print("Children Sum Property Staisfied");
		}
		else
		{
			System.out.print("Children Sum Property Not Staisfied");
		}
	}
	
}