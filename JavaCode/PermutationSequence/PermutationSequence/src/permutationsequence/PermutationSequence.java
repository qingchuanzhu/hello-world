/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutationsequence;
import java.util.*;
/**
 *
 * @author qingchuz
 */
public class PermutationSequence {

    /**
     * @param args the command line arguments
     */
    public static String getPermutation(int n, int k){
        String ans = "";  // ans
        int length = n; // length
        int remainingK = k; //remaining k
        double gpsize;  //group size
        int index;
        //list in order
        List nums = new ArrayList();
        for(int i=1;i<=n;i++)
            nums.add(i);
        while(length>0){
            // calculate group size
            gpsize = 1;
            for(int i=2;i<=length-1;i++)
                gpsize = gpsize * i;
            // find index;
            index = (int)Math.ceil(remainingK/gpsize)-1;
            // append the result
            ans = ans.concat(Integer.toString((int)nums.get(index)));
            // remove the element form list
            nums.remove(index);
            length --;
            remainingK = remainingK - (int)(index*gpsize);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String ans = getPermutation(4,14);
        System.out.println(ans);
    }
    
}
