"""
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
"""
class Solution:
    """
    @param A: sorted integer array A
    @param B: sorted integer array B
    @return: A new sorted integer array
    """
    def mergeSortedArray(self, A, B):
        A = A+B
        A.sort()
        return A
    def mergeSortedArray_1(self, A, B):
        # write your code here
        i, j = 0, 0
        ret = []
        # position = 0
        while(True):
            if(A[i] <= B[j]):
                ret.append(A[i])
                # position += 1
                i += 1
                if(i >= len(A)):
                    for x in range(j, len(B)):
                        ret.append(B[x])
                        # position += 1
                    break
            else:
                ret.append(B[j])
                # position += 1
                j += 1
                if(j >= len(B)):
                    for x in range(i, len(A)):
                        ret.append(A[x])
                        # position += 1
                    break
        return ret
                
        
