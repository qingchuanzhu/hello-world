/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoboxing;

/**
 *
 * @author qingchuz
 */
public class Autoboxing {
    Integer i = new Integer(4);
    int j;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Autoboxing t = new Autoboxing();
        t.go();
    }
    
    public void go(){
    j=i;
    System.out.println(j);
    System.out.println(i);
}
    
}
