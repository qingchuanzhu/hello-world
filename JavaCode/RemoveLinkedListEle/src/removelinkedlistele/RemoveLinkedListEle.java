/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removelinkedlistele;

/**
 *
 * @author qingchuz
 */
public class RemoveLinkedListEle {

    /**
     * @param args the command line arguments
     * Remove all elements from a linked list of integers that have value val.
     * Example
    Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
    Return: 1 --> 2 --> 3 --> 4 --> 5 
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode removeElements(ListNode head, int val) {
        ListNode iterator = head;
        if(head == null)
            return head;
        // determine true head
        while(iterator.val == val){
            if(iterator.next != null)
                iterator = iterator.next;
            else
                return null;
        }
        head = iterator;
        ListNode temp = iterator;
        while(iterator.next!=null){
            iterator = iterator.next;
            // iterator continue moving down until next valid
            while(iterator.val == val){
                if(iterator.next != null)
                    iterator = iterator.next;
                else{ // touch end, cut off the tail and return
                    temp.next = null;
                    return head;
                }
            }
            temp.next = iterator;
            temp = iterator;
        }
        return head;
    }

    public void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        RemoveLinkedListEle mytest = new RemoveLinkedListEle();
        
        // init nodes
        RemoveLinkedListEle.ListNode n0 = mytest.new ListNode(1);
        RemoveLinkedListEle.ListNode n1 = mytest.new ListNode(1);
        RemoveLinkedListEle.ListNode n2 = mytest.new ListNode(6);
        RemoveLinkedListEle.ListNode n3 = mytest.new ListNode(1);
        RemoveLinkedListEle.ListNode n4 = mytest.new ListNode(2);
        RemoveLinkedListEle.ListNode n5 = mytest.new ListNode(2);
        RemoveLinkedListEle.ListNode n6 = mytest.new ListNode(2);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        
        int val = 2;
        mytest.printList(n3);
        ListNode result = mytest.removeElements(n3, val);
        mytest.printList(result);
    }
    
}
