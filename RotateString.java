public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        int len = str.length;
        if(len == 0)
            return;
        offset = offset % len;
        char[] data = new char[offset];
        int ind = 0;
        for(int x = len - offset; x < len; x++)
        {
            data[ind] = str[x];
            ind++;
        }
        
        for(int i = len - offset - 1; i >=0; i-- )
        {
            str[i + offset] = str[i];
        }
        for(int i =0; i < offset; i++)
        {
            str[i] = data[i];
        }
        
    }
}
