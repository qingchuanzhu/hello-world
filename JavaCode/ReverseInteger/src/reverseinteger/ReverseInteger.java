/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseinteger;

/**
 *
 * @author qingchuz
 */
public class ReverseInteger {

    /**
     * @param args the command line arguments
     */
    public static int reverse(int x) {
        int ans=0,b;
        boolean lessthanz = false;
        if(x<0){
            lessthanz = true;
            x = -x;
        }
        while(x/10 > 0){
            b= x%10;
            System.out.println(ans);
             if(ans >= (2147483647-b)/10){// largest Int/10
                System.out.println(ans+"is too large");
                return 0;
            }
            ans = ans*10 +b;
            x = x/10;
        }
        if(ans > (2147483647-x%10)/10){// largest Int/10
                System.out.println(ans+"is too large");
                return 0;
        }
        ans = ans*10 +(x%10);
        if(lessthanz)
            return -ans;
        else
            return ans;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int ans = reverse(1463847412);
        System.out.println(ans);
    }
    
}
