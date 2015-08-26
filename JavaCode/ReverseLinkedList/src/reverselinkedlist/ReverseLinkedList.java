/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverselinkedlist;

/**
 *
 * @author qingchuz
 */
public class ReverseLinkedList {

    /**
     * @param args the command line arguments
     */
    public static ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode tohead = head.next;
        head.next = null;
        ListNode totohead;
        while(tohead!=null){
            totohead = tohead.next;
            tohead.next = head;
            head = tohead;
            tohead = totohead;
        }
        return head;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ListNode n1 = new ListNode(23);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(57);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(13);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        // ouput original list
        ListNode head = n1;
        while(head!= null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.print("\n\nAfter reverse:\n\n");
        ListNode empty =null;
        head = reverseList(empty);
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
    
}
