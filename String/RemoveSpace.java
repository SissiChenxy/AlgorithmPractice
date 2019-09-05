package String;

public class RemoveSpace {
    public String removeSpaces(String input) {
        // Write your solution here
        if(input == null || input.length() == 0){
            return input;
        }

        char[] inputArray = input.toCharArray();
        int i = 0;
        int j = 0;

        while(j <= inputArray.length - 1){
            if(inputArray[j] == ' ' && (i == 0 || inputArray[j-1] == ' ')){
                j++;
            }else{
                inputArray[i] = inputArray[j];
                i++;
                j++;
            }

        }

        if(i > 0 && inputArray[i-1] == ' '){
            i--;
        }

        return new String(inputArray, 0, i);
    }
}
