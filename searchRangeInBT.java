/**
11. Search Range in Binary Search Tree
Given a binary search tree and a range [k1, k2], return node values within a given range in ascending order.

Example
Example 1:

Input：{5},6,10
Output：[]
        5
it will be serialized {5}
No number between 6 and 10
Example 2:

Input：{20,8,22,4,12},10,22
Output：[12,20,22]
Explanation：
        20
       /  \
      8   22
     / \
    4   12
it will be serialized {20,8,22,4,12}
[12,20,22] between 10 and 22

*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        while(true)
        {
            if(root != null)
            {
                if((root.val >= k1) && (root.val <= k2))
                {
                    list.add(root.val);
                }
                if(root.right != null)
                {
                    stack.push(root.right);
                    
                }
                root = root.left;
            }           
            else
            {
                if(!stack.empty())
                {
                    root = stack.pop();
                }
                else
                {
                    break;
                }
            }
        }
        Collections.sort(list);
        return list;

    }
}
