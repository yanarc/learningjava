package lc203;

public class Test2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Solution1 s = new Solution1();
        ListNode ans = s.removeElements1(node1, 1);
        while (ans !=null){
            System.out.println(ans.val);
            ans = ans.next;
        }
        System.out.println(node1);
    }
}

class Solution1 {
    public ListNode removeElements1(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode pre = sentinel, cur = sentinel.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return sentinel.next;
    }
}