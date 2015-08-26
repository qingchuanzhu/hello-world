/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverselinkedlist2;

/**
 *
 * @author qingchuz
 */
public class ReverseLinkedList2 {

    /**
     * @param args the command line arguments
     *  Reverse a linked list from position m to n. Do it in-place and in one-pass.

    For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,

    return 1->4->3->2->5->NULL.

    Note:
    Given m, n satisfy the following condition:
    1 ≤ m ≤ n ≤ length of list. 
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        int count=0,len=n-m;
        ListNode iterator=head;
        ListNode headAnchor=null,tailAnchor=null,rhead=null;
        for(int i=1;i<m;i++){
            if(i==m-1)
                headAnchor = iterator;
            iterator= iterator.next;
        }
        ListNode prev = iterator, target=iterator.next, post=iterator.next.next;

        while(count<len){
            rhead = target;
            tailAnchor = post;
            target.next = prev;
            prev = target;
            target = post;
            if(post!=null)
                post = post.next;
            count++;
        }
        if(headAnchor == null){
            ListNode newHead = rhead;
            iterator.next = tailAnchor;
            return newHead;
        }else{
            headAnchor.next = rhead;
            iterator.next = tailAnchor;
            return head;
        }
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
        ListNode n0 = new ListNode(4);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        ReverseLinkedList2 mytest = new ReverseLinkedList2();
        mytest.printList(n0);
        int m=1,n=5;
        ListNode result = mytest.reverseBetween(n0, m, n);
        mytest.printList(result);
    }
    
}
