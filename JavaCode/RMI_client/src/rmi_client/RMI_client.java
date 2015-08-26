/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Naming;

/**
 *
 * @author qingchuz
 */
public class RMI_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new RMI_client().go();
    }
    
    public void go(){
        try{
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String s = service.sayHello();
            System.out.println(s);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
