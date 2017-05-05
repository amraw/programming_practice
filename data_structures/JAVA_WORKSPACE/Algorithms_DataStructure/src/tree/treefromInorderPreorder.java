package tree;

public class treefromInorderPreorder {
	public node root;
	static int preIndex = 0;
	public treefromInorderPreorder(){
	}
	
	public node buildTree(int[] inorder, int[] preorder,int start, int end)
	{
		if(start >= end)
			return null;
		node presentNode =new node( preorder[preIndex++]);
		int searchIndex = search(inorder,start,end,presentNode.data);
		presentNode.left = buildTree(inorder,preorder,start,searchIndex);
		presentNode.right = buildTree(inorder,preorder,searchIndex+1,end);
		return presentNode;
		
	}
	int search (int []inorder, int start, int end, int target){
		int index = -1;
		for(int i = start; i<end; i++)
		{
			if(target == inorder[i])
			{
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void printInorder(node root){
		if(root == null)
			return ;
		printInorder(root.left);
		System.out.print(root.data+" ");
		printInorder(root.right);
	}
	
	public static void main(String []args){
		treefromInorderPreorder t = new treefromInorderPreorder();
		int [] inorder = {3,2,4,1,6,5};
		int [] preorder = {1,2,3,4,5,6};
		t.root = t.buildTree(inorder,preorder, 0, inorder.length);
		t.printInorder(t.root);
	}
	
}