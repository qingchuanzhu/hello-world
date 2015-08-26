/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package houserobber;

/**
 *
 * @author qingchuz
 */
public class HouseRobber {

    /**
     * @param args the command line arguments
     * You are a professional robber planning to rob houses along a street. 
     * Each house has a certain amount of money stashed, the only constraint stopping you 
     * from robbing each of them is that adjacent houses have security system connected 
     * and it will automatically contact the police if two adjacent houses were 
     * broken into on the same night.

     *Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     */
    
    public static int rob(int[] nums) {
        int len = nums.length;
        int[] myMaxRob = new int[len+1];
        
        if(len == 0)
            return 0;
        if(len == 1)
            return nums[0];
        if(len == 2){
            if(nums[0]>nums[1])
                return nums[0];
            else
                return nums[1];
        }
        // len>=3    
        // step1, initialize myMaxRob
        myMaxRob[0] = 0;
        myMaxRob[1] = nums[0];
        myMaxRob[2] = nums[1]>nums[0]?nums[1]:nums[0];
        
        // fill each cell of the array
        int val1,val2;
        for(int i=2;i<len;i++){
            val1 = nums[i]+myMaxRob[i-1];
            val2 = nums[i-1]+myMaxRob[i-2];
            if(val1>val2)
                myMaxRob[i+1]=val1;
            else
                myMaxRob[i+1]=val2;
        }
        
        //return the max of myMaxRob[len-1] and myMaxRob[len-2]
        return myMaxRob[len];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //int money[]= {4,2,11,9,8,7};
        int money[]= {2,1,1,2};
        int myrob = rob(money);
        System.out.println("I robbed "+myrob);
    }
    
}
