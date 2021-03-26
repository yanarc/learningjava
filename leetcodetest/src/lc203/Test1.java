package lc203;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

public class Test1 {
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
        Solution s = new Solution();
        ListNode ans = s.removeElements(node1, 1);
        while (ans !=null){
            System.out.println(ans.val);
            ans = ans.next;
        }
        System.out.println(node1);

    }
}
