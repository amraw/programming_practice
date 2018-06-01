package tree;

public class sumTree {
public node root;
public sumTree(int data){
	root = new node(data);
}

public int sum(node root){
	if(root == null)
		return 0;
	else
		return sum(root.left)+root.data+sum(root.right);
}
public int sumTree(node root){
	if(root == null || (root.left==null && root.right==null))
		return 1;
	else
	{
		int lresult = sum(root.left);
		int rresult = sum(root.right);
		if(lresult+rresult == root.data && sumTree(root.left)==1 && sumTree(root.right)==1)
		{
			return 1;
		}
		else
			return 0;
	}
	
}

public boolean sumTree2(node root){
	if(root==null || (root.left == null && root.right == null)){
		return true;
	}
	
	if(sumTree2(root.left) && sumTree2(root.right)){
		int ls, rs;
		if(root.left == null)
		{
			ls = 0;
		}
		else if(root.left.left==null && root.left.right == null)
		{
			ls = root.left.data;
		}
		else
		{
			ls = 2 * (root.left.data);
		}
		
		if(root.right == null)
		{
			rs = 0;
		}
		else if(root.right.left==null && root.right.right == null)
		{
			rs = root.right.data;
		}
		else
		{
			rs = 2 * (root.right.data);
		}
		
		return ls+rs == root.data;
	}
	
	return false;
	
}

public static void main(String []args){
	sumTree t = new sumTree(26);
	t.root.left = new node(10);
	t.root.right = new node(3);
	t.root.left.left = new node(4);
	t.root.left.right = new node(6);
	t.root.right.left = new node(3);
	if(t.sumTree(t.root) == 1)
	{
		System.out.println("It follows sum tree property.");
	}
	else
	{
		System.out.println("It does not follows sum tree property.");	
	}
	
	if(t.sumTree2(t.root) )
	{
		System.out.println("It follows sum tree property.");
	}
	else
	{
		System.out.println("It does not follows sum tree property.");	
	}
	
	
}

}
