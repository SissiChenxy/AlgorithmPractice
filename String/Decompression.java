package String;

public class Decompression {
    public String decompress(String input) {
        // Write your solution here
        if(input == null || input.length() <= 1){
            return input;
        }

        int i = 1;
        int newSize = 0;
        while(i < input.length()){
            newSize += Character.getNumericValue(input.charAt(i));
            i += 2;
        }

        char[] result = new char[newSize];
        int index = 0;
        for(int num = 1; num < input.length(); num +=2){
            if(Character.isDigit(input.charAt(num))){
                int count = Character.getNumericValue(input.charAt(num));
                while(count > 0){
                    result[index] = input.charAt(num - 1);
                    index++;
                    count--;
                }
            }
        }
        return new String(result);
    }
}
