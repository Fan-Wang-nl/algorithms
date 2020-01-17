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
