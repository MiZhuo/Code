package site.mizhuo.code;


/**
 * @author: wulibin
 * @date: 2019\5\16 0016
 * @description:
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        //差速法，两个节点，一个节点每次走两步，另一个节点每次走一步，形成2倍的差速，那么当前者走到头时，后者也正好位于链表的中间。
        ListNode fast = head,slow = head;
        while (fast.next != null) {
            slow = slow.next;
            if (fast.next.next == null) {
                break;
            }
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode middleNode2(ListNode head) {
        //按顺序将每个结点放入数组 A 中。然后中间结点就是 A[A.Length/2]，因为我们可以通过索引检索每个结点。
        ListNode[] listNodes = new ListNode[100];
        int i = 0;
        while (head.next != null) {
            listNodes[i++] = head;
            head = head.next;
        }
        return listNodes[i / 2];
    }
}
