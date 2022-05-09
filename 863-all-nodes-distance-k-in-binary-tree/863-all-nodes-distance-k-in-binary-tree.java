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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<Integer>();
        
        distanceK(root, target, k, result);
        
        return result;
    }
    
    private int distanceK(TreeNode node, TreeNode target, int k, List<Integer> result) {
        if (node == null) {
            return -1;
        } else if (node.val == target.val) {
            distanceK(target, k, result);
            return 1;
        } else {
            int leftDepth = distanceK(node.left, target, k, result);
            if (leftDepth != -1) {
                if (leftDepth == k) {
                    result.add(node.val);
                }
                distanceK(node.right, k - leftDepth - 1, result);
                return leftDepth + 1;
            }
            
            int rightDepth = distanceK(node.right, target, k, result);
            if (rightDepth != -1) {
                if (rightDepth == k) {
                    result.add(node.val);
                }
                distanceK(node.left, k - rightDepth - 1, result);
                return rightDepth + 1;
            } else {
                return -1;
            }
        }
    }
    
    private void distanceK(TreeNode node, int k, List<Integer> result) {
        if (k == 0) {
            if (node != null) {
                result.add(node.val);
            }
        } else if (node != null) {
            distanceK(node.left, k - 1, result);
            distanceK(node.right, k - 1, result);
        }
    }
}