package lc83;
import java.util.HashSet;
import java.util.Set;


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);
        head.next=head2;
        head2.next=head3;
        head3.next=null;
        Solution s = new Solution();
        ListNode listNode = s.deleteDuplicates(head);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        set.add(cur.val);
        while(cur.next != null){
            if(!set.add(cur.next.val)){ // 如果添加失败，“添加”这个动作虽然在条件判断中，但是已经产生了的
                cur.next = cur.next.next;    // 就跳过cur.next的这个节点
            }else {
                cur = cur.next;
            }
        }
        for (Integer i : set) {
            System.out.println("这是"+i);
        }
        return head;
    }
}