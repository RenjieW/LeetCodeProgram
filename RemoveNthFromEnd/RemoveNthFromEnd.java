class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;

        for (int i = 0; i <= n; i++)
            first = first.next;

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }
}

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode end = new ListNode(2);
        head.next = end;
        printNode(head);
        ListNode newhead = new Solution().removeNthFromEnd(head, 1);

        printNode(newhead);
    }

    private static void printNode(ListNode head) {
        ListNode first = head;
        while (first != null) {
            System.out.printf("%d ", first.val);
            first = first.next;
        }
        System.out.printf("\n");
    }
}