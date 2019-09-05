package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutations {
    public List<String> permutations(String set) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if(set == null){
            return result;
        }

        char[] setArray = set.toCharArray();
        permutation(result, setArray, 0);
        return result;
    }

    private void permutation(List<String> result, char[] setArray, int index){
        if(index == setArray.length){
            result.add(new String(setArray));
            return;
        }

        //store the used characters
        Set<Character> usedChar = new HashSet<>();

        for(int i = index; i < setArray.length; i++){
            if(!usedChar.contains(setArray[i])){
                usedChar.add(setArray[i]);

                swap(setArray, index, i);
                permutation(result, setArray, index+1);
                swap(setArray, index, i);
            }
        }
    }

    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
