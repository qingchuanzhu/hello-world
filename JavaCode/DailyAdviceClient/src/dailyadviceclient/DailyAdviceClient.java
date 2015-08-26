/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyadviceclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author qingchuz
 */
public class DailyAdviceClient {

    /**
     * @param args the command line arguments
     */
    public void go(){
        try{
            Socket s = new Socket("127.0.0.1",4242);
            
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            
            String advice  = reader.readLine();
            System.out.println("Today you should :"+advice);
            reader.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
    
}
