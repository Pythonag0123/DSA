class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);

        int carry = 0;
        ListNode curr = head;

        while (curr != null) {
            int val = curr.val * 2 + carry;
            curr.val = val % 10;
            carry = val / 10;
            curr = curr.next;
        }

        head = reverse(head);

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }

        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
