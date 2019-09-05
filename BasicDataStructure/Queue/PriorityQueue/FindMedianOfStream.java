package BasicDataStructure.Queue.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianOfStream {
    /*

     */
    private PriorityQueue<Integer> minheap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxheap = new PriorityQueue<>(new Comparator<Integer>(){
        public int compare(Integer num1, Integer num2){
            if(num1 == num2){
                return 0;
            }
            return num1 - num2 > 0 ? -1 : 1;
        }
    });

    public void addNum(int num){

        while(!minheap.isEmpty()) {
            maxheap.offer(minheap.poll());
        }
        maxheap.offer(num);
    }

    public double findMedian(){
        if(maxheap.isEmpty()){
            return Integer.MIN_VALUE;
        }else{
            int size = maxheap.size();
            int count = size % 2 == 0 ? size / 2 : size / 2 + 1;
            while(count > 0){
                minheap.offer(maxheap.poll());
                count--;
            }
            if(minheap.size() == maxheap.size()){
                return (minheap.peek() + maxheap.peek()) / 2.0;
            }else{
                return minheap.peek();
            }
        }
    }

    public void addNum1(int num){
        if(maxheap.isEmpty()){
            maxheap.offer(num);
        }else if(num <= maxheap.peek()){
            maxheap.offer(num);
        }else{
            minheap.offer(num);
        }

        if(maxheap.size() - minheap.size() > 1){
            minheap.offer(maxheap.poll());
        }else if(minheap.size() - maxheap.size() > 0){
            maxheap.offer(minheap.poll());
        }
    }

    public double findMedian1(){
        if(maxheap.isEmpty() && minheap.isEmpty()){
            return Integer.MIN_VALUE;
        }else if(minheap.isEmpty() || maxheap.isEmpty()){
            return minheap.isEmpty() ? maxheap.peek() : minheap.peek();
        }else if(minheap.size() == maxheap.size()){
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }else{
            return maxheap.peek();
        }
    }


    public void test(){
        for(int i = 0; i < 10; i++) {
            addNum(i);
            System.out.println(findMedian());
        }
    }
}
