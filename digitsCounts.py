"""
3. Digit Counts
Count the number of k's between 0 and n. k can be 0 - 9.

Example
Example 1:

Input:
k = 1, n = 1
Output:
1
Explanation:
In [0, 1], we found that 1 appeared once (1).
Example 2:

Input:
k = 1, n = 12
Output:
5
Explanation:
In [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12], we found that one appeared five times (1, 10, 11, 12)(Note that there are two 1 in 11).
"""

class Solution:
    """
    @param k: An integer
    @param n: An integer
    @return: An integer denote the count of digit k in 1..n
    """
    def digitCounts(self, k, n):
        # write your code here
        
        #solution 1
        cnt=0
        for i in range(n+1):
            cnt+=int(str(i).count(str(k)))
        return cnt
    
        #solution 2, learned it from discussion
        """
        #result:100% test cases passedTotal runtime 101 ms; Your submission beats 99.00% Submissions!
        #this tells us there is always a better way as long as you can think out of box
        return ''.join(map(str,range(n+1))).count(str(k))
        """
