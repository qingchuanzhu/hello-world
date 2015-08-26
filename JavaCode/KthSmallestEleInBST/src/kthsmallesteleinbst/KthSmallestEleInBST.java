/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthsmallesteleinbst;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qingchuz
 */
public class KthSmallestEleInBST {

    /**
     * @param args the command line arguments
     * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
     Note:
     You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
     */
   class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    
    int target;
    int count = 0;
    
    class Bingo extends Exception{
        
    }
    
    public void pushNode(TreeNode root, int k) throws Bingo{
        try {
            if(root.left!=null)
                pushNode(root.left, k);
        }
        catch(Bingo b){
            throw b;
        }
        count++;
        if(count == k){
            target = root.val;
            throw new Bingo();
        }
        try {
            if(root.right!=null)
                pushNode(root.right, k);
        }
        catch(Bingo b){
            throw b;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
          try{
              pushNode(root, k);
          }catch(Bingo b){
              System.out.println("I found it: "+target);
          }
          return target;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        KthSmallestEleInBST mytest = new KthSmallestEleInBST();
        KthSmallestEleInBST.TreeNode n0 = mytest.new TreeNode(1);
        //TreeNode n11 = new TreeNode(5);
        KthSmallestEleInBST.TreeNode n12 = mytest.new TreeNode(3);
        //TreeNode n21 = new TreeNode(2);
        //TreeNode n22 = new TreeNode(5);
       // TreeNode n23 = new TreeNode(8);
        
        n0.left = null;
        n0.right = n12;
        //n11.left = n21;
       // n11.right = n22;
        //n12.right = n23;
        
        int k =2;
        int result = mytest.kthSmallest(n0, k);
        System.out.println("The "+k+"th smallest number is "+result);
    }
    
}
