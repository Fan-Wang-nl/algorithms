/**
Description
Merge two given sorted ascending integer array A and B into a new sorted integer array.

Have you met this question in a real interview?  
Example
Example 1:

Input:  A=[1], B=[1]
Output: [1,1]	
Explanation:  return array merged.
Example 2:

Input:  A=[1,2,3,4], B=[2,4,5,6]
Output: [1,2,2,3,4,4,5,6]	
Explanation: return array merged.
Challenge
How can you optimize your algorithm if one array is very large and the other is very small?
*/
public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer> ();
        int i = 0, j = 0;
        while(true)
        {
           if(A[i] >= B[j])
           {
                list.add(B[j]);
                j++;
                if(j >= B.length)
                {
                    for(;i < A.length; i++)
                    {
                        list.add(A[i]);
                    }
                    break;
                }
           }
           else
           {
               list.add(A[i]);
               i++;
               if(i >= A.length)
               {
                   for(; j < B.length; j++)
                   {
                       list.add(B[j]);
                   }
                   break;
               }
           }
        }
       
        int[] ret = new int[list.size()];
        i = 0;
        for (int x:list)
        {
            ret[i] = x;
            i++;
        }
        return ret;
        
    }
}
