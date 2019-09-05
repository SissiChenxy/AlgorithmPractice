package BFS.BFS2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    /*
    BFS2 - dijkstra
    data structure: priority queue --- minheap (sort according to the value)
    algorithm:
        1. initial state: PQ = {input[0][0]}
        2. expand/generate rule:
            expand: top of the PQ input[i][j]
            generate:  input[i+1][j], input[i][j+1]
                if not visited, offer in PQ
        3. termination condition:
            for loop k-1 times
            return minheap.peek()
        4. deduplication: boolean[][] / hashmap<> / hashset<int[2]>
     */

    /*
    assumptions:
        matrix is not null, n > 0 && m > 0
        k > 0 && k <= m*n
     */
    public int kSmallest(int[][] matrix, int k){
        PriorityQueue<Element> minHeap = new PriorityQueue<>(k, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.value == o2.value){
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });

        minHeap.offer(new Element(0, 0, matrix[0][0]));
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++){
            Element current = minHeap.poll();
            if(current.row + 1 < rows && !visited[current.row + 1][current.col]){
                minHeap.offer(new Element(current.row + 1, current.col, matrix[current.row + 1][current.col]));
                visited[current.row + 1][current.col] = true;
            }
            if(current.col + 1 < cols && !visited[current.row][current.col + 1]){
                minHeap.offer(new Element(current.row, current.col + 1, matrix[current.row][current.col + 1]));
                visited[current.row][current.col + 1] = true;
            }
        }
        return minHeap.peek().value;
    }

    static class Element{
        int row;
        int col;
        int value;
        public Element(int r, int c, int v){
            row = r;
            col = c;
            value = v;
        }
    }
}
