/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertbinarytree;

/**
 *
 * @author qingchuz
 */
public class InvertBinaryTree {

    /**
     * @param args the command line arguments
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode (int x) {val = x;}
    }
    
    public static TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        else{
            TreeNode temp;
            temp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = temp;
            return root;
        }
    }
    
    // in-order print
    public static void printTree(TreeNode root){
        if(root!= null){
            printTree(root.left);
            System.err.print(root.val+" ");
            printTree(root.right);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        TreeNode root = new TreeNode(4);
        TreeNode n11 = new TreeNode(2);
        TreeNode n12 = new TreeNode(7);
        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(3);
        TreeNode n23 = new TreeNode(6);
        TreeNode n24 = new TreeNode(9);
        
        root.left = n11;
        root.right = n12;
        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;
        
        printTree(root);
        System.err.println("");
        TreeNode newroot = invertTree(root);
        printTree(newroot);
        System.err.println("");
    }
    
}
