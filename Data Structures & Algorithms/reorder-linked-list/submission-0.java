class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
 
        // 1. Find the end of the first half
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
 
        // 2. Split, then reverse the second half
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
 
        // 3. Interleave the two halves
        ListNode head1 = head, head2 = prev;
        while (head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
 
            head1.next = head2;
            head2.next = next1;
 
            head1 = next1;
            head2 = next2;
        }
    }
}