/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removeduplicatefromsortedlist;

/**
 *
 * @author qingchuz
 */
public class RemoveDuplicateFromSortedList {

    /**
     * @param args the command line arguments
     *  Given a sorted linked list, delete all duplicates such that each element appear only once.

    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3. 
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode it1=head.next, it2=head;
        while(it1!=null){
            if(it1.val == it2.val){
                it2.next = it1.next;
                it1 = it1.next;
            }else{
                it1 = it1.next;
                it2 = it2.next;
            }
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
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        n0.next = n1;
        n1.next = null;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        RemoveDuplicateFromSortedList mytest = new RemoveDuplicateFromSortedList();
        mytest.printList(n0);
        ListNode result = mytest.deleteDuplicates(n0);
        mytest.printList(result);
    }
    
}
