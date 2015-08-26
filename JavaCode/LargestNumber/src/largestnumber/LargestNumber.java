/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestnumber;
import java.util.*;
/**
 *
 * @author qingchuz
 */
public class LargestNumber {

    /**
     * @param args the command line arguments
     */
    public static String largestNumber(int[] nums) {
        String ans="";
        ArrayList<Integer> sortNums = new ArrayList();
        int len = nums.length;
        int k;
        int listlen;
        int toInsert;
        int conclen;
        boolean findpos = false;
        char[] cs1, cs2;
        for(int i=0;i<len;i++){
            //compute list length
            listlen = sortNums.size();
            // to sert
           // System.out.println(i);
            toInsert = nums[i];
            // compare from the begining of the list
            k=0;
            while(k<listlen){
                // convert toInsert and nums[i] to array
                String s1 = Integer.toString(toInsert);
                String s2 = Integer.toString(sortNums.get(k));
                String s3 = s1;
                s1 = s1.concat(s2);
                s2 = s2.concat(s3);
                //compare the two thing
               System.out.println("to insert:"+s1+" target:"+s2);
                cs1 = s1.toCharArray();
                cs2 = s2.toCharArray();
                findpos = false;
                conclen =s1.length(); 
                for(int j=0;j<conclen;j++){
                    if(cs2[j]==cs1[j]){
                        ;//keep looking next
                    }
                    else if(cs2[j]<cs1[j]){
                        findpos = true;
                        break;
                    }else
                        break;
                }
                //
                if(!findpos){
                    k++;
                }else
                    break;
            }
            System.out.println("Going to add nums["+i+"]="+nums[i]+" at index["+k+"]");
            sortNums.add(k, nums[i]);
        }
       // System.out.println(sortNums.size());
        for(int i=0;i<sortNums.size();i++){
           // System.out.println(sortNums.get(i));
            ans = ans.concat(Integer.toString(sortNums.get(i)));
        }
        if((int)sortNums.get(0)==0)
            ans = "0";
        return ans;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int [] nums = {824,938,1399,5607,6973,5703,9609,4398,8247};
        String ans = largestNumber(nums);
        System.out.println(ans);
    }
    
}
