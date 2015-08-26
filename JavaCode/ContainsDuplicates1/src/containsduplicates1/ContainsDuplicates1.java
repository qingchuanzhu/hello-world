/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containsduplicates1;

import java.util.*;

/**
 *
 * @author qingchuz
 */
public class ContainsDuplicates1 {

    /**
     * @param args the command line arguments
     */
    public boolean containsDuplicate(int[] nums) {
        TreeSet<Integer> mySet = new TreeSet<>();
        int len = nums.length;
        if(len <=1)
            return false;
        for(int i=0;i<len;i++){
            System.out.println("Adding "+nums[i]);
            if(!mySet.add(nums[i]))
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ContainsDuplicates1 mytest = new ContainsDuplicates1();
        int[] tests = {3,3};
        boolean result = mytest.containsDuplicate(tests);
        System.out.println("The result is "+result);
    }
    
}
