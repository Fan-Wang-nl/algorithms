/**
13. Implement strStr()
For a given source string and a target string, you should output the first index(from 0) of target string in source string.

If target does not exist in source, just return -1.

Example
Example 1:

Input: source = "source" ，target = "target"
Output: -1	
Explanation: If the source does not contain the target content, return - 1.
Example 2:

Input:source = "abcdabcdefg" ，target = "bcd"
Output: 1	
Explanation: If the source contains the target content, return the location where the target first appeared in the source.
Challenge
O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)

Clarification
Do I need to implement KMP Algorithm in a real interview?

Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your basic implementation ability. But make sure you confirm with the interviewer first.
*/

public class Solution {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        // Write your code here
        //return source.indexOf(target, 0);
        int ret = -1;
        if (source == null && target == null) 
            return 0;
        else if(source == null || target == null)
            return ret;
        else if(target.length() == 0)
            return 0;   
        if(source.length() < target.length())
            return ret;
        

        for (int i = 0; i < source.length() - target.length() + 1; i++)
        {
            if(source.charAt(i) == target.charAt(0))
            {
                int j = 1;
                for (; j < target.length(); j++)
                {
                    if(!(source.charAt(i + j) == target.charAt(j))) {
                        break;
                    }
                }
                if(j == target.length())
                    return i;                
            }
            else
            {
                continue;
            }            
        }

        return  ret;
    }
}
