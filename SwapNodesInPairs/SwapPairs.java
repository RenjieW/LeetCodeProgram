class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        ListNode l1, l2;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            l1 = current.next;
            l2 = current.next.next;
            l1.next = l2.next;
            current.next = l2;
            l2.next = l1;
            current = current.next.next;
        }

        return dummy.next;
    }
}

public class SwapPairs {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = arrayToNodeLists(nums);
        printLists(head);
        ListNode swaphead = new Solution().swapPairs(head);
        printLists(swaphead);
    }

    public static ListNode arrayToNodeLists(int[] nums) {
        int len = nums.length;
        ListNode head = new ListNode(0);
        ListNode p = head; 
        for (int i = 0; i < len; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }

        return head.next;
    }

    public static void printLists(ListNode p) {
        while (p != null) {
            System.out.printf("%d ", p.val);
            p = p.next;
        }
        System.out.printf("\n");
    }
}