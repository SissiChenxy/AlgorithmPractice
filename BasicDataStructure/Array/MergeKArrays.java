package BasicDataStructure.Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKArrays {

    /*
    iterative way

     */

    /*binary deduction 两两解决

     */
    public int[] merge(int[][] arrayOfArrays) {
        // Write your solution here
        if(arrayOfArrays.length <= 1){
            return arrayOfArrays[0];
        }
        return partition(arrayOfArrays, 0, arrayOfArrays.length - 1);
    }

    private int[] partition(int[][] arrayOfArrays, int left, int right){
        if(left == right) return arrayOfArrays[left];
        //recursive call mergeTwoArray method
        if(left < right){
            int mid = left + (right - left) / 2;
            int[] array1 = partition(arrayOfArrays, left, mid);
            int[] array2 = partition(arrayOfArrays, mid+1, right);
            return mergeTwoArray(array1, array2);
        }
        return null;
    }

    private int[] mergeTwoArray(int[] array1, int[] array2){
        int p1 = 0, p2 = 0, p = 0;
        int[] result = new int[array1.length + array2.length];
        while(p1 < array1.length && p2 < array2.length){
            if(array1[p1] < array2[p2]){
                result[p] = array1[p1];
                p1++;
            }else{
                result[p] = array2[p2];
                p2++;
            }
            p++;
        }
        while(p1 < array1.length){
            result[p++] = array1[p1++];
        }
        while(p2 < array2.length){
            result[p++] = array2[p2++];
        }
        return result;
    }


    /*k-way together
    data structure: heap


     */
    public int[] merge2(int[][] arrayOfArrays) {
        // Write your solution here
        if(arrayOfArrays.length == 0){
            return null;
        }

        //initialize: put all zero element in the minheap
        PriorityQueue<Element> minHeap = new PriorityQueue<>(arrayOfArrays.length, new MyComparator());
        int length = 0;
        for(int i = 0; i < arrayOfArrays.length; i++){
            int[] array = arrayOfArrays[i];
            length += array.length;
            if(array.length != 0){
                minHeap.offer(new Element(i, 0, array[0]));
            }
        }

        int[] result = new int[length];
        int tail = 0;
        while(!minHeap.isEmpty()){
            Element e = minHeap.poll();
            result[tail++] = e.value;
            if(e.indexInArray + 1 < arrayOfArrays[e.indexOfArray].length){
                e.indexInArray++;
                e.value = arrayOfArrays[e.indexOfArray][e.indexInArray];
                minHeap.offer(e);
            }
        }

        return result;
    }

    static class Element{
        int indexOfArray;
        int indexInArray;
        int value;
        public Element(int x, int y, int v){
            indexOfArray = x;
            indexInArray = y;
            value = v;
        }
    }

    static class MyComparator implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2){
            if(e1.value == e2.value){
                return 0;
            }
            return e1.value < e2.value ? -1 : 1;
        }
    }
}
