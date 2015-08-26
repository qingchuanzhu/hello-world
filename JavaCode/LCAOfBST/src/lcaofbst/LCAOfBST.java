/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcaofbst;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qingchuz
 */
public class LCAOfBST {

    /**
     * @param args the command line arguments
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST. 
     */
    public void findPath(List<TreeNode> mpath, TreeNode root, TreeNode target){
        mpath.add(root);
        if(root==target)
            return;
        else if(root.val > target.val)
            findPath(mpath, root.left, target);
        else
            findPath(mpath, root.right, target);
        return;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        findPath(pathP, root,p);
        findPath(pathQ, root,q);
        this.printList(pathP);
        this.printList(pathQ);
        TreeNode lastCommon = root;
        int i =1;
        while(i<pathP.size()&&i<pathQ.size()){
            if(pathP.get(i) != pathQ.get(i)){
                break;
            }
            lastCommon = pathP.get(i);
            i++;
        }
        return lastCommon;
    }
    public void printList(List<TreeNode> path){
        int len = path.size();
        for(int i=0;i<len;i++)
            System.out.print(path.get(i).val+" ");
        System.out.println("");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        TreeNode n0 = new TreeNode(5);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(16);
        
        n0.left = n1;
        n0.right = n5;
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        
        
        LCAOfBST mytest = new LCAOfBST();
        TreeNode result = mytest.lowestCommonAncestor(n0, n4, n3);
        System.out.println("LCA value is "+result.val);
    }
    
}
