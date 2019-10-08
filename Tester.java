//alex ortega

import java.util.*;
import java.io.*;

public class Tester {

	public static void main(String[] args) throws IOException {
		
		System.out.printf("\t\t\t\tWelcome to the BST Tree Lab.\n\n");
		
		BST     bst   = new BST();
		Scanner input = new Scanner(new File("bst.txt"));
		String  a     = input.nextLine();

		System.out.printf("tree is empty: %b\n", bst.isEmpty());
		System.out.printf("populating tree . . .\n");

		for(String x: a.split(""))
			bst.add(x);

		System.out.printf("tree is empty: %b\n\n", bst.isEmpty());

		System.out.printf("before rearrange()\n");
		bst.inOrder(); //this will print out the tree in alphabetical order
		System.out.printf("smallest value in tree: %s\n", bst.smallest()); 
		System.out.printf("largest value in tree: %s\n", bst.largest());   

		System.out.print("after rearrange()\n");
		bst.rearrange(); //tree will be arranged on the frequencies
		bst.inOrder();
		System.out.printf("smallest value in tree: %s\n", bst.smallest()); 
		System.out.printf("largest value in tree: %s\n\n", bst.largest()); 

		System.out.println("levelOrder()");
		bst.levelOrder();
		
		System.out.printf("\nfindKth(11)\n");
		bst.findKth(11);

		input.close();
	}
}