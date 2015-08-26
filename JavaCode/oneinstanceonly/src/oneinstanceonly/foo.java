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
public class foo {
    private static foo ref;
    private static int objcount = 0;
    private int size;
    
    // private constructor
    private foo(int a){
        size = a;
    }
    
    // public constructor for use
    public static foo constructme(int a){
        if(objcount == 0){
            ref = new foo(a);
            objcount++;
            return ref;
        }else
            return ref;
    }
    
    // instance access
    public int getsize(){
        return size;
    }   
}
