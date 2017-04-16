package tree;
import java.util.*;
public class inOrderWithoutRecursion {

	public node root;
	public inOrderWithoutRecursion(int nodeData){
		root = new node(nodeData);
	}
	
	public void printInorder(node root){
		if(root == null)
			return;
		else
		{
			Stack<node> stack = new Stack<node>();
			node current = root;
			stack.push(current);
			current = current.left;
			while(!stack.isEmpty()){
				if(current!=null)
				{
					stack.push(current);
					current = current.left;
				}
				else
				{
					current = stack.pop();
					System.out.print(current.data+" ");
					if(current.right !=null)
					{
						current = current.right;
						stack.push(current);
						current = current.left;
					}
					else
					{
						current = current.right;
					}
					
				}
			}
		}
	}
	
	public static void main(String []args){
		inOrderWithoutRecursion tree = new inOrderWithoutRecursion(1);
		tree.root.left = new node(2);
		tree.root.right = new node(3);
		tree.root.left.left = new node(4);
		tree.root.left.right = new node(5);
		tree.printInorder(tree.root);
	}
}