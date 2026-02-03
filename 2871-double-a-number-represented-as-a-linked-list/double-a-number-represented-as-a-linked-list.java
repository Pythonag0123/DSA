class Solution {
    public ListNode doubleIt(ListNode head) {

        // Step 1: build string (use StringBuilder for speed)
        StringBuilder sb = new StringBuilder();
        ListNode a = head;

        while (a != null) {
            sb.append(a.val);
            a = a.next;
        }

        // Step 2: double the number manually (string math)
        int carry = 0;

        for (int i = sb.length() - 1; i >= 0; i--) {
            int digit = (sb.charAt(i) - '0') * 2 + carry;
            sb.setCharAt(i, (char) ((digit % 10) + '0'));
            carry = digit / 10;
        }

        if (carry > 0) sb.insert(0, carry);

        // Step 3: convert string back to list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int i = 0; i < sb.length(); i++) {
            curr.next = new ListNode(sb.charAt(i) - '0');
            curr = curr.next;
        }

        return dummy.next;
    }
}
