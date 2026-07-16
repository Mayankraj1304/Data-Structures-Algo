class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        // Traverse the list
        while (current != null && current.next != null) {
            // If the next node is a duplicate, skip it
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // Otherwise, just move to the next node
                current = current.next;
            }
        }
        
        return head;
    }
}