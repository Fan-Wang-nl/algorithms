/**
12. Min Stack
Implement a stack with following functions:

push(val) push val into the stack
pop() pop the top element and return it
min() return the smallest number in the stack
All above should be in O(1) cost.

Example
Example 1:

Input:
  push(1)
  pop()
  push(2)
  push(3)
  min()
  push(1)
  min()
Output:
  1
  2
  1
Example 2:

Input:
  push(1)
  min()
  push(2)
  min()
  push(3)
  min()
Output:
  1
  1
  1
Notice
min() will never be called when there is no number in the stack.
*/

public class MinStack {

    private int pointer = -1;
    ArrayList<Integer> list = new ArrayList<>();
//    LinkedList<Integer> myset = new LinkedList<>();

    TreeMap<Integer,Integer> treeMap = new TreeMap<>();

    class Element{
        public int value;
        public int position;
    }

    public MinStack() {
        // do intialization if necessary

    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here

        pointer++;
        list.add(pointer, number);



        if(pointer == 0)
        {
            treeMap.put(number, 1);
        }
        else if(treeMap.containsKey(number))
        {
            treeMap.replace(number, treeMap.get(number) + 1);
        }
        else {
            treeMap.put(number, 1);
        }
        
    

    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int x = list.get(pointer);
        pointer--;

        //myset.removeFirstOccurrence(x);
        if(treeMap.get(x) == 1)
        {
            treeMap.remove(x);
        }
        else 
        {
            treeMap.replace(x, treeMap.get(x) - 1);
        }

        return  x;


    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return  treeMap.firstKey();
    }
}
