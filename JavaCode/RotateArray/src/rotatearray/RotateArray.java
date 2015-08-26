/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotatearray;

import java.util.ArrayList;

/**
 *
 * @author qingchuz
 */
public class RotateArray {

    /**
     * @param args the command line arguments
     * Rotate an array of n elements to the right by k steps.

        For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(len<=1 || k==0)
            return;
        int realK = k % len;
        ArrayList<Integer> myStack = new ArrayList<>();
        int K1 = len-realK;
        for(int i=len-1;i>=K1;i--){
            myStack.add(nums[i]);
        }
        for(int i=len-realK-1;i>=0;i--){
            nums[i+realK] = nums[i];
        }
        for(int i=realK-1;i>=0;i--){
            nums[i] = myStack.get(realK-i-1);
        }
    }
    public static void printArray(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++)
            System.out.print(nums[i]+" ");
        System.out.println("");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        RotateArray mytest = new RotateArray();
        int[] tester = {1,2,3,4,5,6,7};
        int k= 3;
        printArray(tester);
        mytest.rotate(tester, k);
        printArray(tester);
    }
    
}
