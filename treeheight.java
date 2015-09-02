public class treeheight {
	
	public Node treeRoot;

	int calHeight() {

		return getHeight(treeRoot);
	}

	int getHeight(Node root) {

	if (root == null) {
		return 0;
	} 

	return max(getHeight(root.left), getHeight(root.right))+1;

	}

	int max(int a , int b) {
		if (a>b) {
			return a;
		} else {
			return b;
		}
	}
		

    void addNode(int n) {

    	if (treeRoot == null) {
    		treeRoot = new Node(n);
    		return;
    	} else {
    		Node temp = treeRoot;
    		if (treeRoot.data > n) {
    			treeRoot = treeRoot.right;
    			addNode(n);
    		} else {
    			treeRoot= treeRoot.left;
    			addNode(n);
    		}
    		treeRoot = temp;
    	}
    	return;
    }

    void createTree(int n) {
    	if (treeRoot == null){
    		treeRoot = new Node(n);
    	}
    	else {
    		insert(treeRoot, n);
    	}
    }

    Node insert(Node t, int data) {

    	if (t == null) {
    		return t = new Node(data);
    	} else {
    		if (data < t.data) {
    			t.left = insert(t.left, data);
    		} else {
    			t.right = insert(t.right, data);
    		}
    		return t;
    	}
    }


    void printTree() {

    	inorder(treeRoot);
    }

	void inorder(Node n) {

		if (n == null) {
			return;
		}
		inorder(n.left);
		System.out.println(n.data);
		
		inorder(n.right);
	}

	public static void main(String[] args) {
		
		treeheight tr = new treeheight();

		tr.createTree(15);
		tr.createTree(5);
		tr.createTree(3);
		tr.createTree(12);
		tr.createTree(16);
		tr.createTree(20);
		tr.createTree(18);
		tr.createTree(23);
		tr.createTree(13);
		tr.createTree(10);
		tr.createTree(6);
		tr.createTree(7);
		tr.createTree(14);

		tr.printTree();

		System.out.println(" height" +tr.calHeight());

	}
}

class Node {

	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;	
	}

}