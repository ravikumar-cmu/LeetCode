public class BinarySearchTree {
  public Node root;

  public void insert(int value){
    Node node = new Node(value);

    if ( root == null ) {
      root = node;
      return;
    }

    insertRec(root, node);

  }

  private void insertRec(Node latestRoot, Node node){

    if ( latestRoot.value > node.value){

      if ( latestRoot.left == null ){
        latestRoot.left = node;
        return;
      }
      else{
        insertRec(latestRoot.left, node);
      }
    }
    else{
      if (latestRoot.right == null){
        latestRoot.right = node;
        return;
      }
      else{
        insertRec(latestRoot.right, node);
      }
    }
  }

  /**
 * Printing the contents of the tree in an inorder way.
 */
public void printInorder(){
  printInOrderRec(root);
  System.out.println("");
}

/**
 * Helper method to recursively print the contents in an inorder way
 */
private void printInOrderRec(Node currRoot){
  if ( currRoot == null ){
    return;
  }
  printInOrderRec(currRoot.left);
  System.out.print(currRoot.value+", ");
  printInOrderRec(currRoot.right);
}
public static void main(String[] args) {
    
    BinarySearchTree tr = new BinarySearchTree();
    
    //tr.addNode(10);
    //System.out.println(tr.treeRoot.data);

    //tr.addNode(11);

    //tr.addNode(9);

    
    tr.insert(10);
    tr.insert(9);
    tr.insert(11);
    //System.out.println("ROOOT LEFT" + tr.treeRoot.left.data);
    tr.printInorder();


  }
}

class Node {

	int value;
	Node left;
	Node right;

	Node(int data) {
		this.value = data;
		this.left = null;
		this.right = null;	
	}

}