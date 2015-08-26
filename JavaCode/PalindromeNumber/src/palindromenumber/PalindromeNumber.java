/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromenumber;

/**
 *
 * @author qingchuz
 */
public class PalindromeNumber {

    /**
     * @param args the command line arguments
     */
    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if(x==0)
            return true;
        int len = (int)(Math.log10(x)+1);
        int testlen,b,a=0;
        if(len%2 == 0){ 
            testlen = len/2;
            for(int i=1;i<=testlen;i++){
                b= x%10;
                a = a*10+b;
                x= x/10;
            }
            if(x==a)
                return true;
            else
                return false;
        }else{ 
            testlen = (len-1)/2;
            for(int i=1;i<=testlen;i++){
                b=x%10;
                a=a*10+b;
                x=x/10;
            }
            x=x/10;
            if(x==a)
                return true;
            else
                return false;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        boolean ans = isPalindrome(123321);
        System.out.println(ans);
    }
    
}
