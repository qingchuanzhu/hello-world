/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyadviceserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author qingchuz
 */
public class DailyAdviceServer {

    /**
     * @param args the command line arguments
     */
    String[] adviceList = {"Take smaller bites","Just for today"};
    
    public void go(){
        try{
            ServerSocket serverSock = new ServerSocket(4242);
            
            while(true){
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    private String getAdvice(){
        int random = (int) (Math.random()*adviceList.length);
        return adviceList[random];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
    
}
