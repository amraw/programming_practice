package tree;

public class rootToLeafPaths {
public node root;
//public int path[];
public rootToLeafPaths(int data){
	root = new node(data);
	//path = new int[1000];
}

public void printArray(int []path, int index)
{
	for(int i=0; i< index;i++)
	{
		System.out.print(path[i]+" ");
	}
	System.out.println("");
}

public void printRootToLeafPath(node root, int[]path, int index){
	if(root == null)
		return;
	else if(root.left==null && root.right==null)
	{
		path[index] = root.data;
		index++;
		printArray(path, index);
	}
	else
	{
		path[index] = root.data;
		index++;
		printRootToLeafPath(root.left,path,index);
		printRootToLeafPath(root.right,path,index);
	}
}
public static void main(String []args){
	rootToLeafPaths tree = new rootToLeafPaths(1);
	tree.root.left = new node(2);
	tree.root.right = new node(3);
	tree.root.left.left = new node(4);
	tree.root.left.right = new node(5);
	int []path = new int[1000];
	tree.printRootToLeafPath(tree.root, path, 0);
}
}