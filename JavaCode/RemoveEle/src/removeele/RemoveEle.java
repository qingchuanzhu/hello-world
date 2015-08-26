/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removeele;

/**
 *
 * @author qingchuz
 * Given an array and a value, remove all instances of that value in place and return the new length.
    The order of elements can be changed. It doesn't matter what you leave beyond the new length. 
 */
public class RemoveEle {

    /**
     * @param args the command line arguments
     */
    public int removeElement(int[] nums, int val) {
        int count=0;
        int len=nums.length;
        if(len==0)
            return 0;
        for(int i=0;i<len;i++){
            if(nums[i]==val){
                count++;
                continue;
            }
            else{
                nums[i-count]=nums[i];
            }
        }
        return len-count;
    }
    public static void printArray(int[] nums){
        int len=nums.length;
        for(int i=0;i<len;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        RemoveEle mytest = new RemoveEle();
        int[] tester = {1,1,3,1,4};
        printArray(tester);
        int target = 1;
        int newLen = mytest.removeElement(tester, target);
        printArray(tester);
        System.out.println("The new length is "+newLen);
    }
    
}
