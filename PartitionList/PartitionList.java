class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;

        ListNode before_head = new ListNode(0), after_head = new ListNode(0);
        ListNode before = before_head, after = after_head;
        
        while (head != null) {
            if (head.val < x) {
                before.next = new ListNode(head.val);
                before = before.next;
            } else {
                after.next = new ListNode(head.val);
                after = after.next;
            }
            head = head.next;
        }

        before.next = after_head.next;
        printList(before_head.next);
        return before_head.next;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.printf("%d->", head.val);
            head = head.next;
        }
        System.out.printf("null\n");
    }
}

public class PartitionList {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 2};
        int target = 3;
        ListNode head = arrToList(nums);
        ListNode newHead = new Solution().partition(head, target);
    }

    public static ListNode arrToList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode ps = dummy;
        for (int i = 0; i < nums.length; i++) {
            ps.next = new ListNode(nums[i]);
            ps = ps.next;
        }
        return dummy.next;
    }
}