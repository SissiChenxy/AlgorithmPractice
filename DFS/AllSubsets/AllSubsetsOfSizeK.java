package DFS.AllSubsets;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfSizeK {
    public List<String> subSetsOfSizeK(String set, int k) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if(set == null){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        char[] setArray = set.toCharArray();
        helper(setArray, result, k, sb, 0);
        return result;
    }

    private void helper(char[] setArray, List<String> result, int k, StringBuilder sb, int index){
        if(sb.length() == k){
            result.add(sb.toString());
            return;
        }

        if(index == setArray.length){
            return;
        }

        sb.append(setArray[index]);
        helper(setArray, result, k, sb, index + 1);
        sb.deleteCharAt(sb.length() - 1);

        helper(setArray, result, k, sb, index + 1);
    }
}
