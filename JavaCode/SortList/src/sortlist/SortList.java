/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortlist;

import java.util.PriorityQueue;

/**
 *
 * @author qingchuz
 */
public class SortList {

    /**
     * @param args the command line arguments
     * Sort a linked list in O(n log n) time using constant space complexity.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> myPQ = new PriorityQueue<>();
        if(head == null ||head.next == null)
            return head;
        while(head!=null){
            myPQ.add(head.val);
            head = head.next;
        }
        int len = myPQ.size()-1;
        ListNode newhead = new ListNode(myPQ.poll());
        ListNode temp = newhead;
        for(int i=0;i<len;i++){
            ListNode newpoll = new ListNode(myPQ.poll());
            temp.next = newpoll;
            temp = newpoll;
        }
        temp.next = null;
        return newhead;
    }
    
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        SortList mytester = new SortList();
        SortList.ListNode n0 = mytester.new ListNode(4);
        SortList.ListNode n1 = mytester.new ListNode(5);
        SortList.ListNode n2 = mytester.new ListNode(3);
        SortList.ListNode n3 = mytester.new ListNode(7);
        SortList.ListNode n4 = mytester.new ListNode(3);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        printList(n0);
        
        ListNode result = mytester.sortList(n0);
        printList(result);
    }
    
}
