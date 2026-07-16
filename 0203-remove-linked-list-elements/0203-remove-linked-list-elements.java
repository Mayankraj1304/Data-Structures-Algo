class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 1. Remove matching elements at the very beginning of the list
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        // 2. Start traversing from our cleaned-up head
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                // If the next node matches, skip it
                curr.next = curr.next.next;
            } else {
                // Only move 'curr' forward if we didn't delete anything
                curr = curr.next;
            }
        }
        
        // 3. Return the original head pointer
        return head;
    }
}