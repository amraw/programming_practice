package tree;

public class InorderSuccessor {
node3 root;
static node3 next_ref = null;
public InorderSuccessor(int data){
	root = new node3(data);
}
public void inOrderSuccessor(node3 root)
{
	if(root==null)
		return ;
	else
	{
		inOrderSuccessor(root.right);
		root.next = next_ref;
		next_ref = root;
		inOrderSuccessor(root.left);
	}
}

public void printNodes(node3 root){
	node3 ptr = getLeftNode(root);
	while(ptr!=null)
	{
		System.out.print(ptr.data+" ");
		ptr = ptr.next;
	}
}

public node3 getLeftNode(node3 root)
{
	if(root.left==null && root.right == null)
		return root;
	else
		return getLeftNode(root.left);
}

public static void main(String []args){
	InorderSuccessor t = new InorderSuccessor(1);
	t.root.left = new node3(2);
	t.root.right = new node3(3);
	t.root.left.right = new node3(4);
	t.root.left.left = new node3(6);
	t.root.right.left = new node3(5);
	t.root.right.right = new node3(7);
	t.inOrderSuccessor(t.root);
	t.printNodes(t.root);
}

}



class node3{
	int data;
	node3 left;
	node3 right;
	node3 next;
	public node3(int data){
		this.data = data;
		left = null;
		right = null;
		next = null;
	}
}