package BFS.BFS2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LargestProductOfLength {
    /*
    BFS2 - dijkstra
    data structure: priority queue -- maxheap (sort according to the product of two string)
    algorithm:
        1. initial state: PQ = {input[0].length * input[1].length}
        2. expand/generate rule:
            expand: top of the PQ Element(i, j, product)
                if nodup, return product
            generate:  input[i+1][j], input[i][j+1]
                if not visited, offer in PQ
        3. termination condition:
            for loop k-1 times
            return minheap.peek()
        4. deduplication: boolean[][] / hashmap<> / set<int[2]>
    preprocessing: sort string[] in descending order
     */

    public int largestProduct(String[] dict) {
        // Write your solution here
        Arrays.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return 0;
                }
                return o1.length() > o2.length() ? -1 : 1;
            }
        });

        Queue<Element> maxHeap = new PriorityQueue<>(11, new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2){
                if(e1.product == e2.product){
                    return 0;
                }
                return e1.product > e2.product ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[dict.length][dict.length];
        maxHeap.offer(new Element(0, 1, dict[0].length() * dict[1].length()));
        while(!maxHeap.isEmpty()){
            Element max = maxHeap.poll();
            int row = max.row;
            int col = max.col;
            visited[row][col] = true;
            if(noDup(dict[row], dict[col])){
                return max.product;
            }
            if(col + 1 < dict.length && !visited[row][col + 1]){
                maxHeap.offer(new Element(row, col + 1, dict[row].length() * dict[col + 1].length()));
            }
            if(row + 1 < col && !visited[row + 1][col]){
                maxHeap.offer(new Element(row + 1, col, dict[row + 1].length() * dict[col].length()));
            }
        }
        return 0;
    }

    public boolean noDup(String s1, String s2){
        int temp = 0;
        for(char c : s1.toCharArray()){
            temp = temp | 1 << (c - 'a');
        }

        for(char c : s2.toCharArray()){
            int index = c - 'a';
            if((temp >> index & 1) == 0){
                return true;
            }
        }
        return false;
    }

    static class Element{
        int row;
        int col;
        int product;
        public Element(int i, int j, int p){
            row = i;
            col = j;
            product = p;
        }
    }
}
