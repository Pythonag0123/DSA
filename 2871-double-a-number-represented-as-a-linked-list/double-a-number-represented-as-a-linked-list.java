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
    // base case
    if (head == null || head.next == null)
        return head;

    ListNode newHead = reverse(head.next);

    head.next.next = head; // reverse link
    head.next = null;     // break old link

    return newHead;
    }

}
