import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0)
            return null;

        int interval = 1;
        int i = 0;
        while (interval < len) {
            for (i = 0; i + interval < len; i+=interval*2) 
                lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
            interval *= 2;
        }

        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) 
            p.next = l2;
        if (l2 == null)
            p.next = l1;

        return dummy.next;
    }
}

pubic class MergeKSortedLists {
    public static void main(String[] args) {

    }
}

