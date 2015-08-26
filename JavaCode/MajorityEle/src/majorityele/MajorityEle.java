/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorityele;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author qingchuz
 */
public class MajorityEle {

    /**
     * @param args the command line arguments
     * Given an array of size n, find the majority element. The majority element 
     * is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.
     */
    public int findOccur(int[] nums,int tar){
        int count = 0;
        int len = nums.length;
        for(int i=0; i<len;i++){
            if(nums[i]==tar)
                count++;
        }
        return count;
    }
    public  ArrayList<Integer> givemeans(int[] nums){
        if(nums.length == 1){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(nums[0]);
            ans.add(1);
            return ans;
        }
            
        int len = nums.length;
        int [] left_half = Arrays.copyOfRange(nums, 0, len/2);
        int [] right_half = Arrays.copyOfRange(nums, len/2, len);
        
        ArrayList<Integer> ansLeft = givemeans(left_half);
        ArrayList<Integer> ansRight = givemeans(right_half);
        
        if(ansLeft.get(0)!=null){
        int occurRight = findOccur(right_half,ansLeft.get(0));
        if(occurRight+ansLeft.get(1)>len/2){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(ansLeft.get(0));
            ans.add(occurRight+ansLeft.get(1));
            return ans;
        }
        }
        if(ansRight.get(0)!=null){
        int occurLeft = findOccur(left_half,ansRight.get(0));
        if(occurLeft+ansRight.get(1)>len/2){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(ansRight.get(0));
            ans.add(occurLeft+ansRight.get(1));
            return ans;
        }
        }
        ArrayList<Integer> ans = new ArrayList<>();
            ans.add(null);
            ans.add(0);
            return ans;
    }
    
    public int majorityElement(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        ArrayList<Integer> ans = givemeans(nums);
        System.out.println("The maj is "+ans.get(0));
        System.out.println("The occurence is "+ans.get(1));
        return ans.get(0);
    }
    public static void printArray(int[] nums){
        int len = nums.length;
        for(int i=0;i<len;i++)
            System.out.print(nums[i]+" ");
        System.out.println("");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        MajorityEle mytest = new MajorityEle();
        int[] tester = {1,1,2};
        int[] mycopy = Arrays.copyOfRange(tester, 1, 2);
        int result = mytest.majorityElement(tester);
        System.out.print("The orig is ");
        printArray(tester);
        System.out.print("The copy is ");
        printArray(mycopy);
        System.out.println("The Maj is "+result);
    }
    
}
