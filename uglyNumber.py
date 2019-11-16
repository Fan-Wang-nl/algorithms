"""
4. Ugly Number II
Ugly number is a number that only have prime factors 2, 3 and 5.

Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

Example
Example 1:

Input: 9
Output: 10
Example 2:

Input: 1
Output: 1
Challenge
O(n log n) or O(n) time.
"""

class Solution:
    """
    @param n: An integer
    @return: return a  integer as description.
    """
    def nthUglyNumber(self, n):
        # write your code here
        ugly=set()
        ugly.add(1)
        minNumber=1
        #add new eligible candidates in the set, but keep removing the minimun one
        for i in range(n):
            minNumber=min(ugly)
            ugly.remove(minNumber)
            ugly.add(minNumber*2)
            ugly.add(minNumber*3)
            ugly.add(minNumber*5)
        return minNumber
"""
100% test cases passedTotal runtime 101 ms
Your submission beats 100.00% Submissions!
"""
