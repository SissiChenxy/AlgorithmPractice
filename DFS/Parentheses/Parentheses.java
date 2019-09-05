package DFS.Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {
    public List<String> validParentheses(int n) {
        // Write your solution here
        List<String> result = new ArrayList<String>();
        if(n == 0){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        findParentheses(n, result, 0, 0, sb);
        return result;
    }

    private void findParentheses(int n, List<String> result, int l, int r, StringBuilder sb){
        //don't have any parentheses left
        if(l == n && r == n){
            result.add(sb.toString());
            return;
        }

        //case1: 先放左半边
        if(l < n){
            sb.append("(");
            findParentheses(n, result, l+ 1, r, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        //再放右半边
        if(l > r){
            sb.append(")");
            findParentheses(n, result, l, r+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
