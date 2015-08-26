/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotatelist;

/**
 *
 * @author qingchuz
 */
public class RotateList {

    /**
     * @param args the command line arguments
     * Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
     */
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode tail=null;
        ListNode iterator = head;
        while(iterator!=null){
            len++;
            tail = iterator;
            iterator=iterator.next;
        }
        iterator = head;
        if(len<=1||k%len==0)
            return head;
        ListNode prev=null, newHead;
        int offset = len-k%len;
        for(int i=0;i<offset;i++){
            if(i==offset-1)
                prev = iterator;
            iterator=iterator.next;
        }
        newHead = iterator;
        
        prev.next = null;
        tail.next = head;
        return newHead;
    }
    
    public void printList(ListNode head){
        if(head == null)
            System.out.println("Empty list");
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        int k = 7;
        RotateList mytest = new RotateList();
        mytest.printList(n0);
        ListNode result = mytest.rotateRight(n0, k);
        mytest.printList(result);
    }
    
}
