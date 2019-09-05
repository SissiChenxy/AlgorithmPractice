package String;

import java.util.ArrayDeque;
import java.util.Deque;

public class RightShift {
    public String rightShift1(String input, int n) {
        // Write your solution here
        if(input.length() <= 1 || n == 0){
            return input;
        }

        Deque<Character> queue = new ArrayDeque<Character>();
        for(int i = 0; i< input.length(); i++){
            queue.offerLast(input.charAt(i));
        }

        int count = n % input.length();
        for(int i = 1; i <= count; i++){
            queue.offerFirst(queue.pollLast());
        }

        StringBuilder sb = new StringBuilder();
        int size = queue.size();
        while(size > 0){
            sb.append(queue.pollFirst());
            size--;
        }

        return new String(sb);
    }

    public String rightShift2(String input, int n){
        if(input.length() <= 1 || n == 0){
            return input;
        }

        char[] array = input.toCharArray();
        n = n % array.length;
        reverse(array, array.length - n, array.length - 1);
        reverse(array, 0, array.length - n - 1);
        reverse(array, 0, array.length - 1);

        return new String(array);
    }

    private void reverse(char[] array, int left, int right){
        while(left < right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
