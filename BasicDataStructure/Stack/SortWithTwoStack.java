package BasicDataStructure.Stack;

import java.util.LinkedList;

public class SortWithTwoStack {
    public void sort(LinkedList<Integer> s1) {
        if(s1 == null || s1.size() <= 1){
            return;
        }

        //s1 input
        //s2 output | buffer
        LinkedList<Integer> s2 = new LinkedList<>();

        while(!s1.isEmpty()){
            int curMin = Integer.MAX_VALUE;
            int counter = 0;
            while(!s1.isEmpty()){
                curMin = Math.min(s1.peekFirst(),curMin);
                int ele = s1.pollFirst();
                if(ele != curMin){
                    s2.offerFirst(ele);
                }else if(ele == curMin){
                    counter++;
                }

            }

            while(!s2.isEmpty() && s2.peekFirst() >= curMin){
                int ele = s2.pollFirst();
                if(ele != curMin){
                    s1.offerFirst(ele);
                }
            }

            while(counter >= 1){
                s2.offerFirst(curMin);
                counter--;
            }
        }

        //s2 -> s1 ascending
        while(!s2.isEmpty()){
            s1.offerFirst(s2.pollFirst());
        }
    }

    public void solution2(LinkedList<Integer> s1){
        if(s1 == null || s1.size() <= 1){
            return;
        }

        LinkedList<Integer> s2 = new LinkedList<>();

        //put result in s2
        while(!s1.isEmpty()){
            int temp = s1.pollFirst();

            while(!s2.isEmpty() && s2.peekFirst() > temp){
                s1.offerFirst(s2.pollFirst());
            }
            s2.offerFirst(temp);
        }

        //reverse
        while(!s2.isEmpty()){
            s1.offerFirst(s2.pollFirst());
        }

    }
}
