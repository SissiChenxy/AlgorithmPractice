package Bit;

public class AllUnique {
    public boolean allUnique(String word) {
        // Write your solution here
        //each int value represents 32 digits, so we need 8 int to represents 256 digits
        int[] vec = new int[8];
        char[] array = word.toCharArray();
        for(char c : array){
            //c / 32 is the index, c % 32 is the exact digit
            //先大定位
            int cInt = vec[c / 32];
            //判读是否该位为1，如果是1说明之前有此元素；0说明没有
            if((cInt >>> (c % 32)) == 1){
                return false;
            }
            vec[c / 32] |= 1 << (c % 32);
        }
        return true;
    }
}
