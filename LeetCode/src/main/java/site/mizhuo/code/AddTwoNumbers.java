package site.mizhuo.code;


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode p = l1,q = l2,cur = listNode;
        int car = 0;
        while (p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = car + x + y;
            car = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(p != null){
                p = p.next;
            }
            if(q != null){
                q = q.next;
            }
        }
        if(car > 0){
            cur.next = new ListNode(car);
        }

        return listNode.next;
    }
}
