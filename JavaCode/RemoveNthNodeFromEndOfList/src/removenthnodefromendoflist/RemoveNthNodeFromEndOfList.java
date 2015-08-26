/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removenthnodefromendoflist;

/**
 *
 * @author qingchuz
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * @param args the command line arguments
     * Given a linked list, remove the nth node from the end of list and return its head.

    For example,
    Given linked list: 1->2->3->4->5, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5.

    Note:
    Given n will always be valid.
    Try to do this in one pass. 
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode it1=head,it2=null;
        int count = 0;
        if(head==null || n==0)
            return head;
        while(it1!=null){
            if(count == n)
                it2 = head;
            if(count>n)
                it2 = it2.next;
            it1=it1.next;
            count++;
        }
        if(it2 == null)
            return head.next;
        if(n==1){
            it2.next = null;
        }else{
            it2.next = it2.next.next;
        }
        return head;
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
        ListNode n4 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        RemoveNthNodeFromEndOfList mytest = new RemoveNthNodeFromEndOfList();
        mytest.printList(n0);
        int n=5;
        ListNode result = mytest.removeNthFromEnd(n0, n);
        mytest.printList(result);
    }
    
}
