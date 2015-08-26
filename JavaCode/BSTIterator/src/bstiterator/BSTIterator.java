/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstiterator;

import com.sun.java.swing.plaf.motif.MotifSplitPaneDivider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qingchuz
 */
public class BSTIterator {

    /**
     * @param args the command line arguments
     * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

    Calling next() will return the next smallest number in the BST.
    Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. 
    * 
    * Your BSTIterator will be called like this:
    * BSTIterator i = new BSTIterator(root);
    * while (i.hasNext()) v[f()] = i.next();
     */
    
        /** @return whether we have a next smallest number */
    public boolean hasNext() {
       return !parentList.isEmpty();
    }

    public void printList(List<TreeNode> parlist){
        int len = parlist.size();
        for(int i=0;i<len;i++)
            System.out.print(parlist.get(i).val+" ");
        System.out.println("");
    }
    /** @return the next smallest number */
    public int next() {
       TreeNode top = parentList.remove(parentList.size()-1);
       TreeNode temp = top.right;
       while(temp!=null){
           parentList.add(temp);
           temp = temp.left;
       }
       return top.val;
    }
    
    // constructor   
    List<TreeNode> parentList = new ArrayList<>();
    public BSTIterator(TreeNode root){       
        while(root!=null){
            parentList.add(root);
            root = root.left;
        }
        printList(parentList);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        TreeNode n0 = new TreeNode(8);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(15);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(16);
        
        n0.left = n1;
        n0.right = n5;
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n5.left = n6;
        n5.right = n7;
        
        BSTIterator mytest = new BSTIterator(null);
        while(mytest.hasNext()){
            System.out.print(mytest.next()+" ");
        }
        System.out.println("");
    }
    
}
