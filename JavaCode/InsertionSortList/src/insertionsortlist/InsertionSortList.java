/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertionsortlist;

/**
 *
 * @author qingchuz
 */
public class InsertionSortList {

    /**
     * @param args the command line arguments
     * Sort a linked list using insertion sort.
     */
    public class ListNode {
        int val;
        ListNode next=null;
        ListNode(int x) { val = x; }
    }
    // return the new head
    public ListNode insertNode(ListNode head, ListNode node){
        if(node.val<head.val){
            node.next = head;
            return node;
        }
        ListNode temp=head;
        while(temp.next != null){
            if(node.val >temp.next.val)
                temp = temp.next;
            else{
                node.next = temp.next;
                temp.next = node;
                return head;
            }
        }
        temp.next = node;
        node.next = null;
        return head;
    }
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode iterator = head.next;
        head.next = null;
        ListNode temp;
        while(iterator!=null){
            temp = iterator;
            iterator = iterator.next;
            head = insertNode(head, temp);
        }
        return head;
    }
    
    public void printList (ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        InsertionSortList mytest = new InsertionSortList();
        InsertionSortList.ListNode n0 = mytest.new ListNode(4);
        InsertionSortList.ListNode n1 = mytest.new ListNode(3);
        InsertionSortList.ListNode n2 = mytest.new ListNode(5);
        InsertionSortList.ListNode n3 = mytest.new ListNode(1);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        mytest.printList(n0);
        ListNode newhead  = mytest.insertionSortList(n3);
        mytest.printList(newhead);
    }
    
}
