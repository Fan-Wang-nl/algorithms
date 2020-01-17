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
                
        
