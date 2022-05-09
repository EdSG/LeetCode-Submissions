/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        boolean cycleFound = false;
        
        if (head == null) return cycleFound;
        
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode next = head.next;
        while (next != null) {
            if (visited.contains(next)) {
                cycleFound = true;
                break;
            } else {
                visited.add(next);
            }
            next = next.next;
        }
        
        return cycleFound;
    }
}