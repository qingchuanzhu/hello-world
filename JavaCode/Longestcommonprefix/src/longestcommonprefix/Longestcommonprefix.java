/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestcommonprefix;

/**
 *
 * @author qingchuz
 */
public class Longestcommonprefix {

    /**
     * @param args the command line arguments
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int len = strs[0].length();
        int sizeofstrs = strs.length;
        String ans = "";
        boolean sameforall;
        for(int i=0;i<len;i++){
            char target = strs[0].charAt(i);
            sameforall = true;
            for(int j=1;j<sizeofstrs;j++){
               if(i==strs[j].length()) 
                   return ans;
               if(strs[j].charAt(i)!=target){
                   sameforall = false;
                   break;
               } 
            }
            if(sameforall)
                ans = ans.concat(Character.toString(target));
            else
                return ans;
        }
        return ans;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        String[] strs = new String[3];
        strs[0]="abv";
        strs[1]="abcd";
        strs[2]="ab";
        String ans = longestCommonPrefix(strs);
        System.out.println(ans);
    }
    
}
