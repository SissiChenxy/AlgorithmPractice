package BasicDataStructure.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class MinStack {
    /*
    arraylist:stack + arraylist:min
stack = {1, 0, 0}
min = 1, 0
algorithm:
  when a new element comes(push):
    stack.add(element)
    element < min[last]
      min.add(element)
  when pops an element(pop):
    stack.poll(element)
    element == min[last] && stack[last] != min[last]
      min.poll(element)
 */

    public static class Stack {
        private Deque<Integer> data;
        private Deque<Integer> min;

        public Stack(){
            data = new ArrayDeque<Integer>();
            min = new ArrayDeque<Integer>();
        }

        public boolean push(int val){
            data.offerLast(val);
            if(min.isEmpty() || (!min.isEmpty() && min.peekLast() > val)){
                min.offerLast(val);
            }
            return true;
        }

        public Integer pop(){
            Integer last = null;
            if(!data.isEmpty()){
                last = data.pollLast();
            }

            if(!min.isEmpty() && min.peekLast() == last){
                if(data.isEmpty() || min.peekLast() != data.peekLast()){
                    min.pollLast();
                }
            }
            return last;
        }

        public Integer top(){
            if(data.isEmpty()){
                return null;
            }
            return data.peekLast();
        }

        public Integer getMin(){
            if(min.isEmpty()){
                return null;
            }
            return min.peekLast();
        }
    }


    public static void test(){
        Stack ms = new Stack();
        ms.push(1); //1
        ms.push(0); //1 0
        ms.push(0); //1 0 0
        System.out.println(ms.getMin()); //0
        ms.pop();//1 0
        System.out.println(ms.getMin());//0
        ms.push(-2);//1 0 -2
        System.out.println(ms.getMin());//-2
        ms.pop();//1 0
        System.out.println(ms.getMin());//0
        ms.pop();//1
        System.out.println(ms.getMin());//1
        ms.pop();//null
        System.out.println(ms.getMin());//null
    }
}
