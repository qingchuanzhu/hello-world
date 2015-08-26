/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removeduplicatefromsortedarray;

/**
 *
 * @author qingchuz
 */
public class RemoveDuplicateFromSortedArray {

    /**
     * @param args the command line arguments
     *  Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
    Do  not allocate extra space for another array, you must do this in place with constant memory.

    For example,
    Given input array nums = [1,1,2],
    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
    * It doesn't matter what you leave beyond the new length. 
     */
    public static void printArray(int[] nums){
        int len =nums.length;
        for(int i=0;i<len;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println("");
    }
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int len = nums.length;
        if(len==0)
            return 0;
        if(len==1)
            return 1;
        for(int i=1;i<len;i++){
            if(nums[i] == nums[i-count-1])
                count++;
            else{
                nums[i-count] = nums[i];
            }               
        }
        return len-count;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        RemoveDuplicateFromSortedArray mytest = new RemoveDuplicateFromSortedArray();
        int[] tester = {1};
        int result = mytest.removeDuplicates(tester);
        System.out.println("The new length is "+result);
    }
    
}
