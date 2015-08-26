/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectanglearea;

/**
 *
 * @author qingchuz
 */
public class RectangleArea {

    /**
     * @param args the command line arguments
     */
    public int overlapLength(int x00, int x01, int x10, int x11){
        System.out.println(x00 + " "+x01+" "+x10+" "+x11);
       if(x10<x01 && x00<=x10&&x11>x01){
           return x01-x10;
       }else if(x11>x00&&x11<=x01&&x10<x00){
           return x11-x00;
       }else if(x00<=x10&&x11<=x01){
           return x11-x10;
       }else if(x10<=x00&&x01<=x11){
           return x01-x00;
       } else
           return 0;
    }
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overW=overlapLength(A, C, E, G);
        int overH=overlapLength(B, D, F, H);
        System.out.println("overH = "+overH);
        System.out.println("overW = "+overW);
        int totalA=(D-B)*(C-A)+(G-E)*(H-F);
        return totalA - overW*overH;
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        RectangleArea myrec = new RectangleArea();
        //int result = myrec.computeArea(-3,0,3,4,0,-1,9,2);
        int result = myrec.computeArea(-2, -2, 2, 2, -1, -1, 1, 1);
        System.out.println("Area is:"+result);
    }
    
}
