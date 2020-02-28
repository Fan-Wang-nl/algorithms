/**
7. Serialize and Deserialize Binary Tree
Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

Example
Example 1:

Input：{3,9,20,#,#,15,7}
Output：{3,9,20,#,#,15,7}
Explanation：
Binary tree {3,9,20,#,#,15,7},  denote the following structure:
	  3
	 / \
	9  20
	  /  \
	 15   7
it will be serialized {3,9,20,#,#,15,7}
Example 2:

Input：{1,2,3}
Output：{1,2,3}
Explanation：
Binary tree {1,2,3},  denote the following structure:
   1
  / \
 2   3
it will be serialized {1,2,3}
Our data serialization use BFS traversal. This is just for when you got Wrong Answer and want to debug the input.

You can use other method to do serializaiton and deserialization.

Notice
There is no limit of how you deserialize or serialize a binary tree, LintCode will take your output of serialize as the input of deserialize, it won't check the result of serialize.


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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder strBd = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current = null;
        ArrayList<TreeNode> list = new ArrayList<>();

        while (!queue.isEmpty())
        {
            current = queue.poll();
            list.add(current);
            if(current != null)
            {
                queue.offer(current.left);
                queue.offer(current.right);
            }

        }

        while (!list.isEmpty() && (list.get(list.size() - 1) == null ))
        {
            list.remove(list.size() - 1);
        }
        strBd.append("{");
        for(TreeNode node : list) {
            if(node != null)
                strBd.append(node.val);
            else
                strBd.append("#");
            strBd.append(",");
        }
        if(strBd.charAt(strBd.length() - 1) == ',')
            strBd.deleteCharAt(strBd.length() - 1);
        strBd.append("}");
        return strBd.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("{}")) {
            return null;
        }

        String[] list = data.substring(1,data.length() - 1).split(",");
        String hashtag = "#";
        TreeNode root = null;
        TreeNode current = null;
        boolean isLeft = true;// indicate whether the current node is lef child node or not 

        Queue<TreeNode> queue = new LinkedList<>();

        for(String tmp : list)
        {
            if(root == null)
            {
                root = current = new TreeNode(Integer.parseInt(tmp));
                queue.offer(root);
            }
            else
            {
                current = queue.peek();
                if(hashtag.equals(tmp))
                {

                }
                else //not null
                {
                    if(isLeft) //left child
                    {
                        current.left = new TreeNode(Integer.parseInt(tmp));
                        queue.offer(current.left);
                    }
                    else
                    {
                        current.right = new TreeNode(Integer.parseInt(tmp));
                        queue.offer(current.right);

                    }
                }
                if(!isLeft)
                    queue.poll();
                isLeft = !isLeft;
            }
        }


        return root;
    }
}

