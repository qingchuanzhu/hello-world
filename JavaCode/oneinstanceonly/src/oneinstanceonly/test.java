/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneinstanceonly;

import java.util.ArrayList;

/**
 *
 * @author qingchuz
 */
public class test {
    final static int x=12;
    ArrayList<Integer> alist = new ArrayList<>();
    public static void go(final int x){
        System.out.println(x);
    }
}
