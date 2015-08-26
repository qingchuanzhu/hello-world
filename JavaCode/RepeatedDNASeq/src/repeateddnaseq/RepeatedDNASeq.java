/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repeateddnaseq;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author qingchuz
 */
public class RepeatedDNASeq {

    /**
     * @param args the command line arguments
     * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

    For example,
    Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
    Return:
    ["AAAAACCCCC", "CCCCCAAAAA"].

     */
    public List<String> findRepeatedDnaSequences(String s) {
        TreeSet<String> myList = new TreeSet<>();
        TreeSet<String> mySet = new TreeSet<>();
        ArrayList<String> ans = new ArrayList<>();
        int len = s.length();
        if(len<=10)
            return ans;
        
        for(int i=0;i<=len-10;i++){
            String subString = s.substring(i, i+10);
            if(!mySet.add(subString)){
                myList.add(subString);
            }
        }
        ans.addAll(myList);
        return ans;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        RepeatedDNASeq mytest = new RepeatedDNASeq();
        String s = "AAAAAAAAAAAA";
        List<String> result = mytest.findRepeatedDnaSequences(s);
        System.out.println("Result is "+result);
    }
    
}
