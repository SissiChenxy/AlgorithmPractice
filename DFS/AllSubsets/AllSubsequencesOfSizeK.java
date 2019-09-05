package DFS.AllSubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsequencesOfSizeK {
    public List<String> subSetsIIOfSizeK(String set, int k) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if(set == null || k < 0){
            return result;
        }
        char[] setArray = set.toCharArray();
        Arrays.sort(setArray);
        StringBuilder sb = new StringBuilder();
        helper(setArray, result, sb, 0, k);
        return result;
    }

    private void helper(char[] input, List<String> result, StringBuilder sb, int index, int k){
        if(sb.length() == k){
            result.add(sb.toString());
            return;
        }

        if(index == input.length){
            return;
        }

        sb.append(input[index]);
        helper(input, result, sb, index + 1, k);
        sb.deleteCharAt(sb.length() - 1);

        while(index < input.length - 1 && input[index+1] == input[index]){
            index++;
        }

        helper(input, result, sb, index + 1, k);
    }
}
