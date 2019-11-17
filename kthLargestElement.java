/**
5. Kth Largest Element

Find K-th largest element in an array.

Example
Example 1:

Input:
n = 1, nums = [1,3,4,2]
Output:
4
Example 2:

Input:
n = 3, nums = [9,3,2,4,8]
Output:
4
Challenge
O(n) time, O(1) extra memory.

Notice
You can swap elements in the array
*/

//please mind the repeated elements
public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
     public int kthLargestElement(int n, int[] nums) {
        // write your code here
        int temp = 0;
        
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int x = 0; x < n; x++)
        {
            if(!treeMap.containsKey(nums[x]))
            {
                treeMap.put(nums[x], 1);
            }
            else
            {
                temp = treeMap.get(nums[x]);
                treeMap.replace(nums[x], temp + 1);
            }
        }
        int firstKey = 0;

        //n should be less than nums.length
        for(int i = n; i < nums.length; i++)
        {
            firstKey = treeMap.keySet().iterator().next();
            if(nums[i] > firstKey)
            {
                //add this number to the hashmap
                if(treeMap.containsKey(nums[i]))
                {
                    temp = treeMap.get(nums[i]);
                    treeMap.replace(nums[i], temp + 1);
                }
                else
                {
                    treeMap.put(nums[i], 1);
                }

                temp = treeMap.get(firstKey);
                if(temp == 1)
                {
                    treeMap.remove(firstKey);
                }
                else if(temp > 1)
                {
                    treeMap.replace(firstKey, temp -1);
                }

            }
        }

        return treeMap.keySet().iterator().next();
    }
 }
