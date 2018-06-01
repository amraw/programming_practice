package tree;

public class LevelOfNode {
public node root;
public LevelOfNode(int data){
	root = new node(data);
}

public int getLevel(node root, int level, int targetNode){
	int result = 0;
	if(root == null)
	{
		result=0;
	}
	else if(root.data == targetNode)
	{
			result =  level;
	}
	else
	{
		int resultl = getLevel(root.left,level+1,targetNode);
		int resultr = getLevel(root.right,level+1,targetNode);
		if(resultl!=0)
			result = resultl;
		else
			result = resultr;
	}
	
	return result;
	
}

public static void main(String []args){
	LevelOfNode t = new LevelOfNode(1);
	t.root.left = new node(2);
	t.root.right = new node(3);
	t.root.left.left = new node(4);
	t.root.left.right = new node(5);
	t.root.right.left = new node(6);
	t.root.right.right = new node(9);
	t.root.left.left.left = new node(7);
	t.root.left.left.right = new node(8);
	int level = t.getLevel(t.root,1,10);
	if(level>0)
	{
		System.out.println("Level of node: "+level);
	}
	else
	{
		System.out.println("Node not Found");
	}
}

}
