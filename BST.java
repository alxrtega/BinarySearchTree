//alex ortega

import java.util.*;

public class BST {

	private class Node{
		
		String data;
		Node   right;
		Node   left;
		int    freq;

		Node(String x){
			this.data  = x;   
			this.right = null;
			this.left  = null;
			this.freq  = 1;
		}
		
		Node(String v, int c){
			this.data  = v;
			this.freq  = c;
			this.right = null;
			this.left  = null;
		}
	}//end of Node

	private Node root;

	public boolean isEmpty() {
		return isEmpty(root);
	}
	public boolean isEmpty(Node root) {
		return root == null;
	}//end of isEmpty

	public boolean add(String x){
		root = add(x,root);
		return true;
	}
	private Node add(String x, Node root){
		
		if(root == null)
			root = new Node(x);
		
		else if(x.compareTo(root.data) > 0)
			root.right = add(x, root.right);
		
		else if(x.compareTo(root.data) < 0)
			root.left = add(x, root.left);
		
		else 
			root.freq++;
		
		return root;
		
	}//end of add

	public void rearrange() {
		Node t = null;
		root = rearrange(root, t);
	}
	private Node rearrange(Node r, Node t) { 
		                                     //in this method
		if(r != null) {                      //we transverse 
			t = addFreq(r.data, r.freq, t);  //in a preorder
			rearrange(r.left, t);            //style to create
			rearrange(r.right, t);           //new tree
		}
		
		return t;		
	}
	private Node addFreq(String data, int freq, Node t) {
		
		Node x = new Node(data, freq); //i am creating new nodes,
		if(t == null) {                //extracting the data and 
			t = x;                     //number of frequencies only
		}
		
		else if(x.freq >= t.freq)
			t.right = addFreq(data, freq, t.right);
		
		else if(x.freq < t.freq)
			t.left = addFreq(data, freq, t.left);
		
		return t;		
	}//end of rearranging

	public String smallest() {
		return smallest(root);
	}
	private String smallest(Node root) {
		return (root.left == null) ? root.data : smallest(root.left);
	}//end of smallest

	public String largest() {
		return largest(root);
	}
	private String largest(Node root) {
		return (root.right == null) ? root.data : largest(root.right);
	}//end of largest

	public void inOrder() {
		inOrder(root);
	}
	private void inOrder(Node root) {
		
		if(root != null) {
			inOrder(root.left);
			System.out.println(root.data+" - "+root.freq);
			inOrder(root.right); 
		}
		
	}//end of inOrder

	public void levelOrder() {
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		levelOrder(q);
		System.out.println();
		
	}
	private void levelOrder(Queue<Node> q) {
		
		if(!q.isEmpty()) {
			
			Node temp = q.remove();
			System.out.printf("%s ", temp.data);
			
			if(temp.left != null)
				q.add(temp.left);
			
			if(temp.right != null)
				q.add(temp.right);
			
			levelOrder(q);			
		}
		
	}//end of levelOrder
	
	public void findKth(int x) { 
		                                        //in this method i just want the 
		PriorityQueue<String> q = new PriorityQueue<>(); //character
		findKth(x, root, q);
		System.out.println(q);
	}	
	private void findKth (int x, Node r, PriorityQueue<String> q){
		
	    if (r == null)
	    	return;
	    
	    if (x == r.freq) {       //i will just add to 
	      q.add(r.data);         //my queue if they 
	      findKth(x, r.right, q); //match what im looking
	    }                        //for wtih x
	    
	    else if (x > r.freq)
	      findKth(x, r.right, q);
	    
	    else
	      findKth(x, r.left, q);
	    
	}

}