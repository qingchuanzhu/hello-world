/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcaofbinarytree;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author qingchuz
 */
public class LCAofBinaryTree {

    /**
     * @param args the command line arguments
     *  Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is 
     * defined between two nodes v and w as the lowest node in T that has both v and w as descendants 
     * (where we allow a node to be a descendant of itself).” 
     */
    public class TreeNode {
       int val;
       TreeNode left = null;
       TreeNode right = null;
       TreeNode(int x) { val = x; }
       @Override
       public String toString(){
           return Integer.toString(val);
       }
       
    }
   
    // use List instead of ArrayList will save stack space during run time
    public boolean fillThePath(List<TreeNode> mpath, TreeNode root, TreeNode target){
        mpath.add(root);
        if(root == target)
            return true;
        else{ 
            if(root.left!=null){
                boolean leftFound = fillThePath(mpath, root.left, target);
                if(leftFound)
                    return true;
            }
            if(root.right != null){
                boolean rightFound = fillThePath(mpath, root.right, target);
                if(rightFound)
                    return true;
            }
        }
        mpath.remove(mpath.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       ArrayList<TreeNode> pathP = new ArrayList<>();
       ArrayList<TreeNode> pathQ = new ArrayList<>();
       fillThePath(pathP,root,p);
       fillThePath(pathQ, root, q);
       TreeNode lastCommon = root;
       int i=1;
       while(i<pathP.size()&&i<pathQ.size()){
           if(pathP.get(i)!=pathQ.get(i))
               break;
           else
               lastCommon = pathP.get(i);
           i++;
       }
//        System.out.println("path P is"+pathP);
//        System.out.println("path Q is"+pathQ);
       return lastCommon;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        LCAofBinaryTree mytest = new LCAofBinaryTree();
        LCAofBinaryTree.TreeNode na = mytest.new TreeNode(1);
        LCAofBinaryTree.TreeNode nb = mytest.new TreeNode(2);
        LCAofBinaryTree.TreeNode nc = mytest.new TreeNode(3);
        LCAofBinaryTree.TreeNode nd = mytest.new TreeNode(4);
        LCAofBinaryTree.TreeNode ne = mytest.new TreeNode(5);
        LCAofBinaryTree.TreeNode nf = mytest.new TreeNode(6);
        LCAofBinaryTree.TreeNode ng = mytest.new TreeNode(7);
        LCAofBinaryTree.TreeNode nh = mytest.new TreeNode(8);
        LCAofBinaryTree.TreeNode ni = mytest.new TreeNode(9);
        
        na.left = nb;
        na.right = ni;
        nb.left = nc;
        nb.right = nf;
        nc.left = nd;
        nc.right = ne;
        nf.left = ng;
        nf.right = nh;
        
        TreeNode LCA = mytest.lowestCommonAncestor(na, na, ne);
        System.out.println("The LCA's value is "+LCA.val);
    }
    
}
