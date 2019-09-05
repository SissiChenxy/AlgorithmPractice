package BFS.BFS2;

import java.util.*;

public class KthClosestPoint {
    /*
    BFS2 - dijkstra
    Data Structure: PriorityQueue -- minheap (sort according to the distance --- calculated from index array)
    Algorithm:
        1. initial state: PQ = {[0, 0, 0]}
        2. expand/generate rule:
            expand: top of the minheap [i, j, k]
            generate: [i+1, j, k], [i, j+1, k], [i, j, k+1]
                if not visited, offer in PQ
        3. termination condition:
            while/for loop k times, update global index array each time
            return according value array of the global index array
        4. deduplication:
            set<int[3]>
     */

    public int[] closest(int[] a, int[] b, int[] c, int k) {
        // Write your solution here

        //int[] is index of a,b,c
        Queue<int[]> minHeap = new PriorityQueue<int[]>(k, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                long d1 = distance(arr1, a, b, c);
                long d2 = distance(arr2, a, b, c);
                if(d1 == d2){
                    return 0;
                }
                return d1 < d2 ? -1 : 1;
            }
        });
        int[] cur = new int[]{0, 0, 0};
        minHeap.offer(cur);

        Set<int[]> visited = new HashSet<>();
        while(k > 0){
            cur = minHeap.poll();
            int[] n = new int[]{cur[0] + 1, cur[1], cur[2]};
            if(n[0] < a.length && visited.add(n)){
                minHeap.offer(n);
            }

            n = new int[]{cur[0], cur[1] + 1, cur[2]};
            if(n[1] < b.length && visited.add(n)){
                minHeap.offer(n);
            }

            n = new int[]{cur[0], cur[1], cur[2] + 1};
            if(n[2] < c.length && visited.add(n)){
                minHeap.offer(n);
            }

            k--;
        }

        //return is actual value in a,b,c corresponding to the index in cur
        cur[0] = a[cur[0]];
        cur[1] = b[cur[1]];
        cur[2] = c[cur[2]];

        return cur;
    }

    private long distance(int[] array, int[] a, int[] b, int[] c){
        long distance = a[array[0]] * a[array[0]] + b[array[1]] * b[array[1]] + c[array[2]] * c[array[2]];
        return distance;
    }
}
