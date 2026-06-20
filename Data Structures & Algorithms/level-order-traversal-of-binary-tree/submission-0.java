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
        List<List<Integer>> result = new LinkedList<>();
        if (root == null ) {
            return result;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        
        que.add(root);
        while(que.size() > 0) {
            int sz = que.size();
            List<Integer> list = new LinkedList<Integer>();
            while (sz > 0) {
                TreeNode temp = que.poll();
                list.add(temp.val);
                if(temp.left != null)
                    que.add(temp.left);
                if(temp.right != null)
                    que.add(temp.right);
                sz = sz-1;
            }
            result.add(list);
        }
        return result;
    }
}
