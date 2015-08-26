/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reorderlist;

/**
 *
 * @author qingchuz
 */
public class ReorderList {

    /**
     * @param args the command line arguments
     */
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    
    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println("");
    }
    
    public static void reorderList(ListNode head) {
        ListNode iterator = head;
        ListNode secHead = head;
        int count = 0;
        if(head == null || head.next == null)
            return;
        
        
        // divide into two list half-half
        while(iterator.next != null){
            iterator = iterator.next;
            count++;
            if(count%2 == 0)
                secHead = secHead.next;
        }
        ListNode temp = secHead;
        secHead = secHead.next;
        temp.next = null;       
        // print for phase testing
        printList(head);
        printList(secHead);
        
        //reverse the list start at secHead
        ListNode lasthead = null;
        while(secHead.next != null){
            temp = secHead;
            secHead = secHead.next;
            temp.next = lasthead;
            lasthead = temp;
        }
        secHead.next = lasthead;       
        // print for phase testing
        System.out.println("After reverse the second list");
        printList(secHead);
        
        // merge the list
        iterator = head;
        ListNode temps;
        while(secHead!=null){
            temp = iterator.next;
            iterator.next = secHead;
            temps = secHead;
            secHead = secHead.next;
            temps.next = temp;
            iterator = iterator.next.next;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(7);
        
        ListNode nalone = new ListNode(8);
        
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        
        ListNode testnode = n0;
        reorderList(testnode);
        System.out.println("After merge");
        printList(testnode);
        
    }
    
}
