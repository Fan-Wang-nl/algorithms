#Python version 
class Solution:
    """
    @param a: An integer
    @param b: An integer
    @return: The sum of a and b 
    """
    def aplusb(self, a, b):
        # write your code here
        while((a & b) != 0):
            c = a ^ b;
            b = (a & b) < 1
            a = c
        return a | b
