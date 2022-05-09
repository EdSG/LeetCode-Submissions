/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        visitLevelOrder(root, result, 0);
        return result;
    }
    
    private void visitLevelOrder(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;
        
        List<Integer> levelList;
        if (level > result.size() - 1) {
            levelList = new ArrayList<Integer>();
            result.add(levelList);
        } else {
            levelList = result.get(level);
        }
        
        levelList.add(node.val);
        
        visitLevelOrder(node.left, result, level + 1);
        visitLevelOrder(node.right, result, level + 1);
    }
}