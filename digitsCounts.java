/**
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
*/

public class Solution {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int count=0;
        int pos = 0;

		for(int i = 0; i <= n; i++)
		{
			String str = Integer.toString(i);
			String x = Integer.toString(k);
			while ((pos = str.indexOf(x, pos)) != -1)
			{
				count++;
				pos++;//from the next position
			}
		}
		return count;
    }
}
