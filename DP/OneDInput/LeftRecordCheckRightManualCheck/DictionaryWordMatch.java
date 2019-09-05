package DP.OneDInput.LeftRecordCheckRightManualCheck;

import java.util.HashSet;
import java.util.Set;

public class DictionaryWordMatch {
    /*
    Given a word, can it be composed by concatenating words from a give dictionary
    dic = {bob, cat, rob}
    bobcatrob --- true, bobro --- false

    data structure:
        M[i] -- represents whether the word of length i can be composed by words in dictionary
    algorithm:
        M[0] = true -- for && convenience
        M[1] b = false
               | b = M[0] && 'b' is in dict = false
        M[2] b o = false
            case1: | b o = M[0] && 'bo' is in dict = false
            case2: b | o = M[1] && 'o' is in dict = false
          false || false == false
        M[3] b o b = true
            case1: | b o b = M[0] && 'bob' is in dict = true
            case2: b | o b = M[1] && 'ob' is in dict = false
            case3: b o | b = M[2] && 'b' is in dict = false
          true || false || false == true
     */

    public boolean canBreak(String input, String[] dict) {
        // Write your solution here
        Set<String> dictSet = new HashSet<String>();
        for(String word : dict){
            dictSet.add(word);
        }

//boolean[] 初始化时，所有都set为false了，所以后面不需要再set false一遍
        boolean[] record = new boolean[input.length() + 1];
        record[0] = true;
        for(int i = 1; i <= input.length(); i++){
            for(int j = 0; j < i; j++){
                //record[j] 为true表示已被前一个单词占用，从那个位置可以切断
                if(record[j] && dictSet.contains(input.substring(j, i))){
                    record[i] = true;
                    break;
                }
            }
        }
        return record[input.length()];
    }

    public void test1(){
        String s = "bobcatrob";
        String[] dict = {"bob", "rob", "cat"};
        System.out.println(canBreak(s, dict));
    }
}
