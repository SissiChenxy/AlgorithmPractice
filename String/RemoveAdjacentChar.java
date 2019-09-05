package String;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjacentChar {
    public String deDup1(String input) {
        // Write your solution here
        if(input == null || input.length() <= 1){
            return input;
        }

        char[] inputArray = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<Character>();
        int j = 0;
        while(j < inputArray.length){
            if(stack.isEmpty() || inputArray[j] != stack.peek()){
                stack.offerFirst(inputArray[j]);
                j++;
            }else{
                while(j < inputArray.length && inputArray[j] == stack.peek()){
                    j++;
                }
                stack.poll();
            }
        }

        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for(int i = 0; i < size; i++){
            sb.append(stack.pollFirst());
        }

        return sb.reverse().toString();
    }

    public String deDup2(String input) {
        if(input == null || input.length() <= 1){
            return input;
        }

        char[] inputArray = input.toCharArray();
        int end = 0;

        for(int j = 1; j < inputArray.length; j++){
            if(end == -1 || inputArray[j] != inputArray[end]){
                end++;
                inputArray[end] = inputArray[j];
                j++;
            }else{
                end--;
                while(j + 1 < inputArray.length && inputArray[j] == inputArray[j+1]) {
                    j++;
                }
            }
        }

        return new String(inputArray,0,end + 1);
    }
}
