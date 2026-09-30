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
    public ListNode swapPairs(ListNode head) {
        // Dummy node acts as a convenient precursor to the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Traverse as long as there is a pair of nodes to swap
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Perform the swap by updating pointers
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Advance prev to the end of the current swapped pair
            prev = first;
        }

        return dummy.next;
    }
}