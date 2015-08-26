/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partitionlist;

/**
 *
 * @author qingchuz
 */
public class PartitionList {

    /**
     * @param args the command line arguments
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.
    For example,
    Given 1->4->3->2->5->2 and x = 3,
    return 1->2->2->4->3->5
     */
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode iterator = start;
        ListNode temp;
        ListNode head2=null,iterator2=null;
        ListNode lastAnchor=start;
        boolean firstSee = false;
        while(iterator.next !=null){
            temp = iterator.next;
            if(temp.val <x){
                if(!firstSee){
                    head2 = new ListNode(temp.val);
                    //head2 = temp;
                    head2.next=null;
                    iterator2 = head2;
                    firstSee = true;
                }else{
                    //ListNode temp2 = new ListNode(temp.val);
                    iterator2.next = temp;
                    iterator2 = temp;
                }
                lastAnchor.next = temp.next;
                iterator = temp;
            }else{
                iterator = iterator.next;
                lastAnchor = temp;
            }
            
        }
        //System.out.println("part1 is:");
        //this.printList(start.next);
        //System.out.println("part2 is:");
        //this.printList(head2);
        
        if(head2==null)
            return start.next;
        else{
        iterator2.next = start.next;
        return head2;}
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
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(2);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        PartitionList mytest = new PartitionList();
        mytest.printList(n0);
        int x=4;
        ListNode result = mytest.partition(n0, x);
        mytest.printList(result);
    }
    
}
