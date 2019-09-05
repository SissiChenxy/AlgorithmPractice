package DFS.Permutations;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {
    public List<String> permutations(String set) {
        // Write your solution here
        List<String> result = new ArrayList<String>();
        if(set == null){
            return result;
        }
        char[] charArray = set.toCharArray();
        helper(charArray,result,0);
        return result;
    }

    private void helper(char[] array, List<String> result, int index){
        if(index == array.length){
            //since we did the swap on the original array, so we just need to add the array
            result.add(new String(array));
            return;
        }

        for(int i = index; i < array.length; i++){
            swap(array, index, i);
            helper(array, result, index + 1);
            //back track
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int a, int b){
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
