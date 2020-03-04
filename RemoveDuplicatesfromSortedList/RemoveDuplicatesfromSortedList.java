class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = new ListNode(head.val);
        ListNode ps = dummy.next;

        while (head != null) {
            if (head.val != ps.val) {
                ps.next = new ListNode(head.val);
                ps = ps.next;
            }
            head = head.next;
        }
        printList(dummy.next);
        return dummy.next;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.printf("%d->", head.val);
            head = head.next;
        }
        System.out.printf("null\n");
    }
}

public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        int[] nums = {1,1};
        ListNode head = arrToList(nums);
        ListNode newHead = new Solution().deleteDuplicates(head);
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