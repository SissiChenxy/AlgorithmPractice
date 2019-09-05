package DFS.Parentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Parentheses3Types {
    public List<String> validParentheses(int l, int m, int n) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque();
        int[] remain = new int[]{l, l, m, m, n, n};
        int sum = 2 * (l + m + n);
        char[] options = new char[]{'(', ')', '[', ']', '{', '}'};
        helper(sum, result, sb, stack, remain, options);
        return result;
    }

    private void helper(int sum, List<String> result, StringBuilder sb, Deque<Character> stack, int[] remain, char[] options){
        if(sb.length() == sum){
            result.add(sb.toString());
            return;
        }

        for(int i = 0; i < remain.length; i++){
            //left element
            if(i % 2 == 0){
                if(remain[i] > 0){
                    sb.append(options[i]);
                    stack.offerFirst(options[i]);
                    remain[i]--;
                    helper(sum, result, sb, stack, remain, options);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    remain[i]++;
                }
            }else{
                if(stack.peekFirst() == options[i-1]){
                    sb.append(options[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(sum, result, sb, stack, remain, options);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(options[i-1]);
                    remain[i]++;
                }
            }
        }

    }
}
