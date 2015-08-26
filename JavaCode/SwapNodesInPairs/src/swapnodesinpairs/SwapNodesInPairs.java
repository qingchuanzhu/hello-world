/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swapnodesinpairs;

/**
 *
 * @author qingchuz
 *  Given a linked list, swap every two adjacent nodes and return its head.

    For example,
    Given 1->2->3->4, you should return the list as 2->1->4->3.

    Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
 */
public class SwapNodesInPairs {

    /**
     * @param args the command line arguments
     */
    public ListNode swapPairs(ListNode head) {
        ListNode newHead;
        ListNode current, target, next,tail;
        if(head == null||head.next == null)
            return head;
        current = head;
        target = current.next;
        newHead = target;
        tail = current;
        next = target.next;
        while(target!=null){
            target.next = current;
            current.next = next;
            current = next;
            if(current!=null){
                if(current.next !=null){                   
                    target = current.next;
                    tail.next =target;
                    tail = current;
                    next = target.next;
                }else
                    break;
            }
            else
                break;
        }
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
        n1.next = null;
        n2.next = n3;
        n3.next = null;
        SwapNodesInPairs mytest = new SwapNodesInPairs();
        mytest.printList(n0);
        ListNode result = mytest.swapPairs(n0);
        mytest.printList(result);
    }
    
}
