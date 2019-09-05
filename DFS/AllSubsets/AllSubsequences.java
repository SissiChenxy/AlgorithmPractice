package DFS.AllSubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllSubsequences {
    //duplicates
    public List<String> subSetsII(String set) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if(set == null){
            return result;
        }
        char[] setArray = set.toCharArray();
        Arrays.sort(setArray);
        StringBuilder sb = new StringBuilder();
        helper2(setArray, result, sb, 0);
        Collections.sort(result);
        return result;
    }

    private void helper(char[] input, List<String> result, StringBuilder sb, int index){
        result.add(sb.toString());
        if(index == input.length){
            return;
        }

        sb.append(input[index]);
        helper(input, result, sb, index + 1);
        sb.deleteCharAt(sb.length() - 1);

        while(index < input.length - 1 && input[index+1] == input[index]){
            index++;
        }

        helper(input, result, sb, index + 1);
    }

    private void helper2(char[] input, List<String> result, StringBuilder sb, int index){
        //走一层打印一次，按序添加到result里
        result.add(sb.toString());
        for(int i = index; i < input.length; i++){
            if(i == index || input[i] != input[i - 1]){
                sb.append(input[i]);
                helper2(input, result, sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
}
