/* Name: Ryan McGregor
 * Thesis Project
 * Program Name: ThreeByThreeCube
 * Class: BinarySearchTree
 * Purpose of this Program: The purpose of this program is to systematically
 * go through every possible case a 3x3x3 Rubik's cube can exist in,
 * in order to be able to say the following:
 *  		"when there are x moves performed on a 3x3x3 Rubik's Cube, 
 *  		there are ____ cases that take y moves to solve."
 *  A chart that will display the results is set up with incrementing x values
 *  in each column, incrementing y values for each row, and the blank will be
 *  filled in with the correct value to appropriately complete the statement.
 *  Purpose of this Class: This classes purpose is to implement a binary search
 *  tree, so the cube states can be stored in a tree, and the search for matches
 *  increases in run time from O(n) to O(log(n)), where n is the number of entries
 *  being stored at a given distance.
 *  */

package cube;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
	
	class BinaryNode<E extends Comparable<E>>{
		protected E data;
		protected BinaryNode<E> right, left;
		protected int height;
	
		public BinaryNode(){
			data = null;
			left = null;
			right = null;
			height = 0;
		}
	
		public BinaryNode(E d){
			data = d;
			right = null;
			left = null;
		}
	
		public BinaryNode(BinaryNode<E> p, E d, BinaryNode<E> n){
			data = d;
			right = n;
			left = p;
		}
	
		public BinaryNode(BinaryNode<E> p, E d, BinaryNode<E> n, int h){
			data = d;
			right = n;
			left = p;
			height = h;
		}
	}

	protected BinaryNode<T> root;
	private int size;
	
	public void insert(T d){
		root = insert(d, root);
		size++;
	}
	
	protected BinaryNode<T> rotateWithLeftChild(BinaryNode<T> k2){
		BinaryNode<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.left), k2.height) + 1;
		return k1;
	}
	
	protected BinaryNode<T> rotateWithRightChild(BinaryNode<T> k1){
		BinaryNode<T> k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		k2.height = max(height(k2.right), k1.height) + 1;
		return k2;
	}
	
	protected BinaryNode<T> doubleWithLeftChild(BinaryNode<T> k3){
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}
	
	protected BinaryNode<T> doubleWithRightChild(BinaryNode<T> k1){
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}
	
	protected BinaryNode<T> insert(T d, BinaryNode<T> root){
		if(root == null)
			root = new BinaryNode<T>(d);
		else if(root.data.compareTo(d) > 0){
			root.left = insert(d, root.left);
			if(height(root.left) - height(root.right) == 2){
				if(root.left.data.compareTo(d) > 0)
					root = rotateWithLeftChild(root);
				else
					root = doubleWithLeftChild(root);
			}
		}
		else if(root.data.compareTo(d) < 0){
			root.right = insert(d, root.right);
			if(height(root.right) - height(root.left) == 2){
				if(root.right.data.compareTo(d) < 0)
					root = rotateWithRightChild(root);
				else
					root = doubleWithRightChild(root);
			}
		}
		else
			;//do nothing
		root.height = max(height(root.left), height(root.right)) + 1;
		return root;
	}

	protected int height(BinaryNode<T> root){
		if(root == null){
			return 0;
		}
		return root.height;
	}
	
	protected int max(int a, int b){
		return (a > b) ? a : b;
	}
	
	public boolean find(T id){
		BinarySearchTree<T>.BinaryNode<T> current = root;
		while(current != null){
			if(current.data.compareTo(id) == 0){
				return true;
			}else if(current.data.compareTo(id) == 1){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	
	public String preorder(){
		String str = "\n[Pre-order - size = " + size + "]\n";
		str += preorder(root);
		return str;
	}
	
	public String inorder(){
		String str = "\n[In-order - size = " + size + "]\n";
		str += inorder(root);
		return str;
	}
	
	public String postorder(){
		String str = "\n[Post-order - size = " + size + "]\n";
		str += postorder(root);
		return str;
	}
	
	protected String preorder(BinaryNode <T> root){
		String msg = "";
		if(root != null){
			msg += root.data + " ";
			msg += preorder(root.left);
			msg += preorder(root.right);
		}
		return msg;
		
	}
	
	protected String inorder(BinaryNode <T> root){
		String msg = "";
		if(root != null){
			msg += inorder(root.left);
			msg += root.data + " ";
			msg += inorder(root.right);
		}
		return msg;
	}
	
	protected String postorder(BinaryNode <T> root){
		String msg = "";
		if(root != null){
			msg += postorder(root.left);
			msg += postorder(root.right);
			msg += root.data + " ";
		}
		return msg;
	}
	
	protected void levelOrderPrint(BinaryNode <T> root){
		Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
		LinkedList<T> list = new LinkedList<T>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryNode<T> item = (BinaryNode<T>) queue.remove();
			if(item != null){
				list.addLast(item.data);
				if(item.left != null)
					queue.add(item.left);
				if(item.right != null)
					queue.add(item.right);
			}
		}
	System.out.println(list);
	}
	
	protected BinaryNode<T> insertLevel(T d, BinaryNode<T> root){
		if(root == null)
			root = new BinaryNode<T>(d);
		else if(root.left == null){
			root.left = new BinaryNode<T>(d);
			insert(d, root.left);
		}
		else if(root.right == null){
			root.right = new BinaryNode<T>(d);
			insert(d, root.right);
		}
		return root;
	}
	
	public void insertLevel(T d){
		insertLevel(d, root);
		size++;
	}
	
	public void levelOrderPrint(){
		levelOrderPrint(root);
	}
	
	public void levelOrderInsert(T d) {
        size++;
        if(root == null)
               root = new BinaryNode<T>(d);
        else {
               Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
                                                       
               queue.add(root);
               while(!queue.isEmpty()) {
                     BinaryNode<T> item = queue.remove();
                     if(item != null) {                               
                            if(item.left != null){
                                   queue.add(item.left);
                                   if(item.right != null)
                                          queue.add(item.right);
                                   else{
                                          item.right = new BinaryNode<T>(d);
                                          return;
                                   }
                            }
                            else{
                                   item.left = new BinaryNode<T>(d);
                                   return;
                            }
                    
                     }
               }
        }
	}
}
