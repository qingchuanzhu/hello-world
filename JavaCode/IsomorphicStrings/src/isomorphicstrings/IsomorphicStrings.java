/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isomorphicstrings;

import java.util.Hashtable;

/**
 *
 * @author qingchuz
 */
public class IsomorphicStrings {

    /**
     * @param args the command line arguments
     * Given two strings s and t, determine if they are isomorphic.

    Two strings are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character while 
    preserving the order of characters. No two characters may map to the same character but a character may map to itself.

    For example,
    Given "egg", "add", return true.
    Given "foo", "bar", return false.
    Given "paper", "title", return true.
     */
    public boolean isIsomorphic(String s, String t) {
       char[] ch1 = s.toCharArray();
       char[] ch2 = t.toCharArray();
       
       int len = ch1.length;
       if(len == 0)
           return true;
       Hashtable<Character, Character> myMap = new Hashtable<>();
       for(int i=0;i<len;i++){
           if(myMap.containsKey(ch1[i])){
               if(myMap.get(ch1[i])== ch2[i])
                   continue;
               else
                   return false;
           }else{
               // check they don't map to the same value
               if(myMap.containsValue(ch2[i])){
                   return false;
               }else
                    myMap.put(ch1[i], ch2[i]);
           }
       }
       return true;
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        IsomorphicStrings mytest = new IsomorphicStrings();
        String st1 = "ab";
        String st2 = "aa";
        boolean result = mytest.isIsomorphic(st1, st2);
        System.out.println("result is "+result);
    }
    
}
