package site.mizhuo.code;

/**
 * @author: wulibin
 * @date:  2019-05-09
 * @description:
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveElements {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode q = p.next;
        while(q != null){
            if(q.val != val){
               p = q;
               q = p.next;
            }else{
                p.next = q.next;
                q = q.next;
            }
        }
        if(head.val == val){
            return head.next;
        }
        return head;
    }

}
