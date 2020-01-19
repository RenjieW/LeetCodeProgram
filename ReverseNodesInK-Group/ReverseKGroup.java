import java.io.*;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int i = 0;
        ListNode begin = dummy;

        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverseLists(begin, head.next);
                head = begin.next;
            }
            else
                head = head.next;
        }

        return dummy.next;
    }

    public ListNode reverseLists(ListNode begin, ListNode end) {
        ListNode l1, l2;
        ListNode curr = begin.next, next;
        ListNode prev = begin, first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        first.next = curr;
        begin.next = prev;
        return first; 
    }
}

public class ReverseKGroup {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int k = Integer.parseInt(line);
            
            ListNode ret = new Solution().reverseKGroup(head, k);
            
            String out = listNodeToString(ret);
            
            System.out.print(out);
        }
    }
}