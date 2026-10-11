/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        // Step 1: Check if there are at least k nodes remaining
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        
        // If fewer than k nodes remain, leave them as they are
        if (count < k) {
            return head;
        }
        
        // Step 2: Reverse the first k nodes
        ListNode prev = null;
        curr = head;
        ListNode nextNode = null;
        
        for (int i = 0; i < k; i++) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        // Step 3: Recursively process the remaining linked list and connect
        head.next = reverseKGroup(curr, k);
        
        // prev becomes the new head of the current group
        return prev;
    }
}