package DFS.Parentheses;

import java.util.ArrayList;
import java.util.List;

public class SpacesInString {
    /*
    permutation --- DFS, 枚举所有情况
    how many levels?
    what do we do at each branch? what are the branches?
        from the second character, before the character
            - add " "
            - not add " "
    base case
    recursion rule

    data structure:
        list<string>
        stringbuilder
            sb.append(s.charAt(0)) 第一个元素要先加入，因为第一个元素前不可能有空格
     */
    public List<String> permutations(String s){
        List<String> result = new ArrayList<>();
        if(s.length() <= 1){
            result.add(s);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        helper(s, result, 1, sb);
        return result;
    }

    private void helper(String s, List<String> result, int index, StringBuilder sb){
        if(index == s.length()){
            result.add(new String(sb));
            return;
        }

        //no space
        sb.append(s.charAt(index));
        helper(s, result, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        //add space
        if(index > 0){
            sb.append(' ');
            sb.append(s.charAt(index));
            helper(s, result, index + 1, sb);
            //remove current character
            sb.deleteCharAt(sb.length() - 1);
            //remove space
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public void test1(){
        String s = "ABC";
        System.out.println(permutations(s));
    }
}


