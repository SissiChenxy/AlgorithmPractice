package String;

public class CompareByFrequency {
    /*
    https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
    Given string arrays queries and words, return an integer array answer,
    where each answer[i] is the number of words such that f(queries[i]) < f(W)
    queries = ["cbd"], words = ["zaaaz"] [1]
    queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"] [1,2]

    data structure:
        int[] bucket -- index == freq, value == amount
            bucket[i] represents the number of word >= freq i in total
    algorithm:
        words --- check every query to get how many are larger than particular frequency
            1. count the freq of rhe smallest character in each word -- int[26] (c - 'a')++
            2. map the freq and number to see how many words share the same freq -- int[] index==freq, value==number
            3. reorganize the "map", make map[i] stores how many are larger than this freq
        queries --- count freq of each query and search in "map" array
     Time = O(queries.length * query.length)
     Space = O(n)
     */

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //words[i].length <= 10, the max of the same character is 10
        int[] bucket = new int[11];
        //words.length * word.length
        for(String w : words){
            int freq = getMinFrequency(w);
            bucket[freq]++;
        }
        //11
        int sum = 0;
        for(int i = bucket.length - 1; i >= 0; i--){
            int temp = bucket[i];
            bucket[i] = sum;
            sum += temp;
        }
        //queries.length * query.length
        int[] result = new int[queries.length];
        int i = 0;
        for(String q : queries){
            int freq = getMinFrequency(q);
            result[i++] = bucket[freq];
        }
        return result;
    }

    private int getMinFrequency(String s){
        int[] record = new int[26];
        for(char c : s.toCharArray()){
            record[c - 'a'] ++;
        }
        for(int i = 0; i < record.length; i++){
            if(record[i] > 0){
                return record[i];
            }
        }
        return -1;
    }

    public void test1(){
        String[] queries = new String[]{"bbb","cc"};
        String[] words = new String[]{"a","aa","aaa","aaaa"};
        System.out.println(numSmallerByFrequency(queries, words));

    }
}
