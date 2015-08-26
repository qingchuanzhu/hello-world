/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intersectionoftwolinkedlist;

/**
 *
 * @author qingchuz
 */
public class IntersectionOfTwoLinkedList {

    /**
     * @param args the command line arguments
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
      }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode iterator1 = headA;
        ListNode iterator2 = headB;
        if(iterator1==null || iterator2==null){            
            return null;
        }else if(iterator1 == iterator2)
            return iterator1;
        int deep1=0;
        int deep2=0;
        while(iterator1.next!=null){
            iterator1 = iterator1.next;
            deep1++;
        }
        while(iterator2.next!= null){
            iterator2 = iterator2.next;
            deep2++;
        }
        iterator1 = headA;
        iterator2 = headB;
        int dep = 0;
        if(deep1>deep2){
            dep = deep1 - deep2;
            while(dep>0){
                iterator1 = iterator1.next;
                dep--;
            }
        }else if(deep2>deep1){
            dep = deep2-deep1;
            while(dep>0){
                iterator2 = iterator2.next;
                dep--;
            }
        }
        if(iterator1 == iterator2)
            return iterator1;
        while(iterator1!=null){
            if(iterator1.next == iterator2.next)
                return iterator1.next;
            iterator1 = iterator1.next;
            iterator2 = iterator2.next;
        }
        return null;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        IntersectionOfTwoLinkedList mytest = new IntersectionOfTwoLinkedList();
        IntersectionOfTwoLinkedList.ListNode n0 = mytest.new ListNode(1);
        IntersectionOfTwoLinkedList.ListNode n1 = mytest.new ListNode(2);
        IntersectionOfTwoLinkedList.ListNode n2 = mytest.new ListNode(3);
        IntersectionOfTwoLinkedList.ListNode n3 = mytest.new ListNode(4);
        IntersectionOfTwoLinkedList.ListNode n4 = mytest.new ListNode(5);
        n0.next = n2;
        n1.next = n3;
        n2.next = n3;
        n3.next = n4;
        ListNode result = mytest.getIntersectionNode(n0, n1);
        if(result != null)
            System.out.println("The intersection is of val "+result.val);
        else
            System.out.println("Intersection not found");
    }
    
}
