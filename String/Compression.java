package String;

public class Compression {
    public String compress(String input) {
        // Write your solution here
        if(input.isEmpty()){
            return input;
        }

        char[] inputArray = input.toCharArray();
        int slow = 0;
        int fast = 0;
        int newLength = 0;

//step 1: replace all multi characters with its size and get the number of single character
        while(fast < inputArray.length){
            int begin = fast;
            //move fast to the correct position which is not same at the begin char
            while(fast < inputArray.length && inputArray[fast] == inputArray[begin]){
                fast++;
            }
            inputArray[slow++] = inputArray[begin];
            if(fast - begin == 1){
                //2 positions for character and 1
                newLength += 2;
            }else{
                //return digits it used
                int len = copyDigits(inputArray, slow, fast - begin);
                slow += len;
                newLength += len + 1;
            }
        }

//step 2: deal with the character whose occurance is only one
        char[] result = new char[newLength];
        //at this time, slow - 1 is the last element in the string
        fast = slow - 1;
        slow = newLength - 1;

        while(fast >= 0){
            if(Character.isDigit(inputArray[fast])){
                while(Character.isDigit(inputArray[fast])){
                    result[slow--] = inputArray[fast--];
                }
            }else{
                result[slow--] = '1';
            }
            result[slow--] = inputArray[fast--];
        }
        return new String(result);
    }

    private int copyDigits(char[] input, int index, int count){
        int len = 0;
        for(int i = count; i > 0; i /= 10){
            index++;
            len++;
        }
        for(int i = count; i > 0; i /= 10){
            int digit = i % 10;
            input[--index] = (char)('0' + digit);
        }
        return len;
    }

}
