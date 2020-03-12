class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode ps = dummy;
        ListNode before = ps, after = ps.next;
        int count = 0;
        while (head != null) {
            printList(dummy.next);
            count++;
            if (count < m || count > n) {
                ps.next = new ListNode(head.val);
                ps = ps.next;
            } else if (count == m) {
                ps.next = new ListNode(head.val);
                before = ps;
                after = ps.next;
                ps = ps.next;
            } else {
                before.next = new ListNode(head.val);
                before.next.next = after;
                after = before.next;
            }
            head = head.next;
        }

        printList(dummy.next);
        return (dummy.next);
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.printf("%d->", head.val);
            head = head.next;
        }
        System.out.printf("null\n");
    }
}

public class ReverseLinkedList2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = arrToList(nums);
        ListNode newHead = new Solution().reverseBetween(head, 2, 4);
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