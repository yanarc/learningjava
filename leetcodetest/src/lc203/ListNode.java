package lc203;

 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        Solution s = new Solution();
        ListNode ans = s.removeElements(node1, 1);
        while (ans !=null){
            System.out.println(ans.val);
            ans = ans.next;
        }

    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        if(head.next == null && head.val == val) return head.next;

        ListNode pre = head;
        while(pre != null && pre.val == val){ // 为什么一直改变不了最前面的那些值, pre变了，head没变
            pre = pre.next;
        }
        if(pre == null) return pre;

        while(pre.next != null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }

        return head;
    }
}
