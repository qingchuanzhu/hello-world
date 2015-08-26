/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removeduplicatefromsortedlist2;

/**
 *
 * @author qingchuz
 */
public class RemoveDuplicateFromSortedList2 {

    /**
     * @param args the command line arguments
     *  Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3. 
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode it1=head.next, it2=head;
        ListNode newHead=null;

        // first find the new head
        if(it1.val != it2.val)
            newHead = it2;
        else{
            it1 =it1.next;
            while(it1!=null){
                if(it2.val == it1.val){
                    it1 = it1.next;
                }else{
                    it2 = it1;
                    it1 = it1.next;
                    if(it1 == null){
                        newHead = it2;
                        break;
                    }else if(it2.val!=it1.val){
                        newHead = it2;
                        break;
                    }
                }
            }
        }
        
        // if can return earlier
        if(newHead==null || newHead.next==null)
            return newHead;       
        it2 = newHead.next;
        if(it2.next == null)
            return newHead;
        
        it1 = it2.next;
        ListNode distinTail = newHead;
        distinTail.next = null;    // distinct tail, all nodes including and before distinTail are valid
        boolean headDup = false;   // wether the nodes starting from distinTail+1 to it1 have duplicates
        while(it1!=null){
            if(it2.val == it1.val){
                it1=it1.next;
                headDup = true;
            }else{
                if(headDup){
                    it2 = it1;
                    it1 = it1.next;
                    headDup = false;}
                if(it1==null){   // reach end, break
                    distinTail.next = it2;
                    break;
                }else if(it2.val != it1.val){
                    distinTail.next = it2;
                    distinTail = it2;
                    distinTail.next = null;
                    it2=it1;
                    it1=it1.next;
                }
            }
        }
        if(!headDup) // see if the last one is also valid, since it1==null this time the loop exist
            if(distinTail.val != it2.val){
                distinTail.next = it2;
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
        ListNode n0 = new ListNode(2);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        RemoveDuplicateFromSortedList2 mytest = new RemoveDuplicateFromSortedList2();
        mytest.printList(n0);
        ListNode result = mytest.deleteDuplicates(n0);
        if(result != null)
            System.out.println("newHead value is "+result.val);
        else
            System.out.println("Empty head");
        mytest.printList(result);
    }
    
}
