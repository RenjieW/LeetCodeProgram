class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy;
        printList(dummy.next);
        while (last.next != null) {
            len++;
            last = last.next;
        } 

        if (len == 0)
            return head;

        int num = len - (k % len);
        if (num == 0 || num == len)
            return head;
        
        int count = 0;
        ListNode begin = dummy;
        while (count < num) {
            begin = begin.next;
            count++;
        }

        dummy.next = begin.next;
        begin.next = last.next;
        last.next = head;
        printList(dummy.next);
        return dummy.next;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.printf("%d->", head.val);
            head = head.next;
        }
        System.out.printf("NULL\n");
    }
}

public class RotateList {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        ListNode head = arrayToList(nums);
        ListNode newheadr = new Solution().rotateRight(head, k);
    }

    public static ListNode arrayToList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode ps = dummy;
        for (int i = 0; i < nums.length; i++) {
            ps.next = new ListNode(nums[i]);
            ps = ps.next;
        }
        return dummy.next;
    }
} 