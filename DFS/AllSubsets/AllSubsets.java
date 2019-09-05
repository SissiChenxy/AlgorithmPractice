package DFS.AllSubsets;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets {

    //no duplicates
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> result = new ArrayList<String>();
        if(set == null){
            return result;
        }
        char[] charArray = set.toCharArray();

        //to store the different combination
        StringBuilder sb = new StringBuilder();
        findSubSet(charArray, sb, 0, result);
        return result;
    }

    private void findSubSet(char[] input, StringBuilder sb, int index, List<String> list){
        if(index == input.length){
            //add the string builder into result list
            list.add(sb.toString());
            return;
        }

//not add element
        findSubSet(input, sb, index + 1, list);

        //add element
        findSubSet(input, sb.append(input[index]), index + 1, list);
        sb.deleteCharAt(sb.length() - 1);
    }
}
