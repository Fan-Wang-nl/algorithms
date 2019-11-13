/**
1. A + B Problem
Write a function that add two numbers A and B.

Example
Example 1:

Input:  a = 1, b = 2
Output: 3	
Explanation: return the result of a + b.
Example 2:

Input:  a = -1, b = 1
Output: 0	
Explanation: return the result of a + b.
Challenge
Of course you can just return a + b to get accepted. But Can you challenge not do it like that?(You should not use + or any arithmetic operators.)

Clarification
Are a and b both 32-bit integers?

Yes.
Can I use bit operation?

Sure you can.
Notice
There is no need to read data from standard input stream. Both parameters are given in function aplusb, your job is to calculate the sum and return it.
*/


public class Solution {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b 
     */
    public int aplusb(int a, int b) {
        // write your code here
        int sum = a;
        int carry = b;
     
        while(carry != 0){
            int new_carry = (sum & carry) << 1;
            sum = sum ^ carry;
            carry = new_carry;
        }
     
        return sum;
    }
}
