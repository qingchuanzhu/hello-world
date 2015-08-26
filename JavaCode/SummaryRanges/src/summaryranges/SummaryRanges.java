/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summaryranges;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author qingchuz
 */
public class SummaryRanges {

    /**
     * @param args the command line arguments
     *  Given a sorted integer array without duplicates, return the summary of its ranges.

        For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"]. 
     */
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> mySummary = new ArrayList<>();
        if(nums.length==0)
            return mySummary;
        
        int len = nums.length;
        String alive = "";
        alive = alive.concat(Integer.toString(nums[0]));
        
        for(int i=1;i<len;i++){
            if(nums[i] == nums[i-1]+1){
                if(i == len-1 && Integer.parseInt(alive) != nums[i]){
                    alive = alive.concat("->"+Integer.toString(nums[i]));
                }
                continue;
            }else{
                if(Integer.parseInt(alive) != nums[i-1]){
                    alive = alive.concat("->"+Integer.toString(nums[i-1]));
                }
                String newalive = "";
                newalive = newalive.concat(Integer.toString(nums[i]));
                mySummary.add(alive);
                alive = newalive;
            }           
        }
        
        mySummary.add(alive);
        return mySummary;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        SummaryRanges mytest = new SummaryRanges();
        //int[] tester = {0,1,2,4,5,7};
        int[] tester = {1,3};
        List<String> result = mytest.summaryRanges(tester);
        System.out.println("Summary is:"+result);
    }
    
}
