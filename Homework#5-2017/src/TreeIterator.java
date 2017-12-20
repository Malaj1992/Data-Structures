import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * 
 * The TreeIterator allows a user of a BinarySearchTree to iterate through the TreeItems currently in the tree
 * in one of the following Key orders:
 * 
 * <ol>
 * <li>preOrder</li>
 * <li>inOrder</li>
 * <li>postOrder</li>
 * </ol>
 * 
 * Users will set the desired order and access the TreeItems using the Iterator interface.
 * 
 * @author Sameh Fakhouri
 *
 * @param <K> 	This is the type of the Key being used by the BinarySearchTree to position TreeItems in the tree
 * @param <V>	This is the type of the Value associated with the Key
 * 
 */
public class TreeIterator<K extends Comparable<? super K>,V> implements java.util.Iterator<TreeItem<K,V>> {

	private BinarySearchTree<K,V> binarySearchTree;
	private TreeNode<K,V> currentNode;
	private Vector<TreeNode<K,V>> treeNodes;

	
	
	/**
	 * 
	 * This is the constructor for the <code>TreeIterator</code>.
	 * 
	 * @param binarySearchTree		The <code>BinaryTreeBasis</code> that this iterator will operate on.
	 * 
	 */
	public TreeIterator(BinarySearchTree<K,V> binarySearchTree) {
		this.binarySearchTree = binarySearchTree;
		currentNode = null;
		// empty vector indicates no traversal type currently
		// selected or end of current traversal has been reached
		treeNodes = new Vector<TreeNode<K,V>>();
	} // end constructor

	
	
	/**
	 * 
	 * This method is used to obtain the number of elements available in the iterator.
	 * 
	 * @return	Returns the number of <code>TreeNode</code>'s available in the iterator.
	 * 
	 */
	public int size() {
		if (this.treeNodes == null) {
			return 0;
		} else {
			return treeNodes.size();
		}
	}

	
	
	/**
	 * 
	 * This method is used to verify that the <code>TreeIterator</code> has more elements to return.
	 * 
	 * @return	Returns <code>true</code> if there are more elements to return, <code>false</code> otherwise. 
	 * 
	 */
	public boolean hasNext() {
		if (this.treeNodes == null) {
			return false;
		} else {
			return !treeNodes.isEmpty();
		}
	} // end hasNext

	
	
	/**
	 * 
	 * This method is used to retrieve the next element from the <code>TreeIterator</code>.
	 * 
	 * @return	Returns the next element from the <code>TreeIterator</code>.
	 * 
	 */
	public TreeItem<K,V> next() throws java.util.NoSuchElementException {
		if (this.treeNodes == null) {
			throw new NoSuchElementException("No TreeItems are available...");
		}
		currentNode = treeNodes.elementAt(0);
		treeNodes.remove(0);
		return currentNode.getTreeItem();
	} // end next

	
	
	/**
	 * 
	 * This method sets the order of retrieval from the <code>TreeIterator</code> to be <b>Preorder</b>.
	 * This method will call the private method preorder() in order to populate the <b>queue</b>. 
	 * 
	 */
	public void setPreorder() {
		this.treeNodes = new Vector<TreeNode<K,V>>();
		preorder(binarySearchTree.getRoot());
	} // setPreOrder


	
	private void preorder(TreeNode<K,V> treeNode) {
		if (treeNode != null) {
			treeNodes.add(treeNode);
			preorder(treeNode.getLeftChild());
			preorder(treeNode.getRightChild());
		} // end if
	} // end preorder

	
	
	/**
	 * 
	 * This method sets the order of retrieval from the <code>TreeIterator</code> to be <b>Inorder</b>.
	 * This method will call the private method inorder() in order to populate the <b>queue</b>. 
	 * 
	 */
	public void setInorder() {
		this.treeNodes = new Vector<TreeNode<K,V>>();
		inorder(binarySearchTree.getRoot());
	} // end setInorder

	
	
	private void inorder(TreeNode<K,V> treeNode) {
		if (treeNode != null) {
			inorder(treeNode.getLeftChild());
			treeNodes.add(treeNode);
			inorder(treeNode.getRightChild());
		} // end if
	} // end inorder

	
	
	/**
	 * 
	 * This method sets the order of retrieval from the <code>TreeIterator</code> to be <b>Postorder</b>.
	 * This method will call the private method postorder() in order to populate the <b>queue</b>. 
	 * 
	 */
	public void setPostorder() {
		this.treeNodes = new Vector<TreeNode<K,V>>();
		postorder(binarySearchTree.getRoot());
	} // end setPostorder

	
	
	private void postorder(TreeNode<K,V> treeNode) {
		if (treeNode != null) {
			postorder(treeNode.getLeftChild());
			postorder(treeNode.getRightChild());
			treeNodes.add(treeNode);
		} // end if
	} // end postorder
} // end TreeIterator