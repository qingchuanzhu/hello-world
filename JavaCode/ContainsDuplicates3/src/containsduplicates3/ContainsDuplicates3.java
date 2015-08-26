/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containsduplicates3;

import java.util.TreeSet;

/**
 *
 * @author qingchuz
 */
public class ContainsDuplicates3 {

    /**
     * @param args the command line arguments
     * Given an array of integers, find out whether there are two distinct indices i and j in the array 
     * such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k. 
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // test validity of k and t
        if(k<1 || t<0)
            return false;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            if((set.floor(n)!= null && set.floor(n)+t>=n) ||
               (set.ceiling(n)!=null && set.ceiling(n)-t <=n))
                return true;
            // check length
            if(i>=k)
                set.remove(nums[i-k]);
            set.add(n);
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = {1,3,1};
        boolean result = containsNearbyAlmostDuplicate(a, 1, 1);
        if(result)
            System.out.println("Found");
        else
            System.err.println("Not Found");
    }
    
}
