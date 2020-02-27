class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int currVal = head.val;
        int count = 0;
        ListNode lastPos = dummy, currPos = head, ps = dummy;
        while (currPos != null) {
            if (currPos.val == currVal) {
                count++;
            }
            else {
                if (count > 1) {
                    ps.next = currPos;
                } else {
                    ps = lastPos;
                }
                currVal = currPos.val;
                count = 1;
            }
            lastPos = currPos;
            currPos = currPos.next;
        }

        if (count > 1)
            ps.next = currPos;
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

public class RemoveDuplicatesfromSortedList2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5};
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