/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneinstanceonly;

/**
 *
 * @author qingchuz
 */
public class Oneinstanceonly {

    /**
     * @param args the command line arguments
     */
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        foo obj1 = foo.constructme(1);
        foo obj2 = foo.constructme(2);
        foo obj3 = foo.constructme(3);
        foo obj4 = foo.constructme(4);
        System.out.println("obj1's size is "+obj1.getsize());
        System.out.println("obj2's size is "+obj2.getsize());
        System.out.println("obj3's size is "+obj3.getsize());
        System.out.println("obj4's size is "+obj4.getsize());
    }
    
}
