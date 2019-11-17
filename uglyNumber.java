public class Solution{
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        //int count =  0;

        TreeSet<Long> myset = new TreeSet<Long>();
        myset.add((long)1);
        long minNumber = 0;
        for(int i = 0; i < n; i++)
        {
            minNumber = myset.first();
            myset.remove(minNumber);
            myset.add(2 * minNumber);
            myset.add(3 * minNumber);
            myset.add(5 * minNumber);
        }

        return  (int)minNumber;
    } 
    /**
    *100% test cases passedTotal runtime 217 ms
    *Your submission beats 22.80% Submissions!
    
    *same algorithm with Python one but different result
    */
    
    
    
}
