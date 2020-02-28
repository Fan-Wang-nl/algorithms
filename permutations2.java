/**
16. Permutations II
Given a list of numbers with duplicate number in it. Find all unique permutations.

Example
Example 1:

Input: [1,1]
Output:
[
  [1,1]
]
Example 2:

Input: [1,2,2]
Output:
[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]
Challenge
Using recursion to do it is acceptable. If you can do it without recursion, that would be great!
*/

public class Solution {
    List<List<Integer>> allPermutations = new ArrayList<List<Integer>>();
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        fullArray(nums, 0, nums.length - 1);
        
        return allPermutations;
    }
    
    public void fullArray(int[] array, int cursor, int end) {
        if (cursor >= end)
        {
            //如果已经到了数组的最后一个元素，前面的元素已经排好，输出。
            //System.out.println(Arrays.toString(array));
            List<Integer> intList = new ArrayList<Integer>();
            for (int i : array)
            {
                intList.add(i);
            }
            allPermutations.add(intList);
        }
        else
        {
            for (int i = cursor; i <= end; i++) {
                //在排列的时候进行判断如果后面的元素与start相同时就不进行排序。
                //这样就可以避免对重复元素进行排序
                if(i==cursor||array[i]!=array[cursor]) {
                    Swap(array, cursor, i); //把第一个元素分别与后面的元素进行交换，递归的调用其子数组进行排序
                    fullArray(array, cursor + 1, end);
                    Swap(array, i, cursor);
                    //子数组排序返回后要将第一个元素交换回来。
                    //如果不交换回来会出错，比如说第一次1、2交换，第一个位置为2，子数组排序返回后如果不将1、2
                    //交换回来第二次交换的时候就会将2、3交换，因此必须将1、2交换使1还是在第一个位置
                }
            }
        }
    }

    public void Swap(int[] chs,int i,int j)
    {
        int temp;
        temp=chs[i];
        chs[i]=chs[j];
        chs[j]=temp;
    }
    
};
