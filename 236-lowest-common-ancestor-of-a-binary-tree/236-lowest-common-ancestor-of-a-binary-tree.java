/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> found = new ArrayDeque<TreeNode>();
            
        lowestCommonAncestorHelper(root, p, q, found);
        
        return found.peekFirst(); // TreeNode in first position will be the common ancestor
    }
    
    private void lowestCommonAncestorHelper(TreeNode node, TreeNode p, TreeNode q, Deque<TreeNode> found) {
        if (node == null) {
            return;
        } else {
            if (node.val == p.val || node.val == q.val) {
                found.offerLast(node);
            }
            
            if (found.size() == 2) {
                return;
            } else {
                boolean wasEmpty = found.isEmpty();
                
                lowestCommonAncestorHelper(node.left, p, q, found);

                if (wasEmpty && found.size() == 2) {
                    return;
                } else if (wasEmpty && found.size() == 1) {
                    lowestCommonAncestorHelper(node.right, p, q, found);
                    if (found.size() == 2) {
                        found.offerFirst(node);
                    }
                } else {
                    lowestCommonAncestorHelper(node.right, p, q, found);
                }
            }
        }
    }
}