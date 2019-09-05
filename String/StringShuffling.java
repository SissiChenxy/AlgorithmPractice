package String;

public class StringShuffling {
    public int[] reorder(int[] array) {
        // Write your solution here
        if(array.length % 2 == 0){
            convert(array, 0 , array.length - 1);
        }else{
            //奇数时，中线卡在元素上，忽略最后一个元素，因为最后一个元素位置不变
            convert(array, 0 , array.length - 2);
        }
        return array;
    }

    private void convert(int[] array, int left, int right){
        //0 or 1 element
        if(right - left <= 1){
            return;
        }

        int size = right - left + 1;
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + 3 * size / 4;

        reverse(array, leftMid, mid - 1);
        reverse(array, mid, rightMid - 1);

        reverse(array, leftMid, rightMid - 1);

        convert(array, left, left + 2 * (leftMid - left) - 1);
        convert(array, left + 2 * (leftMid - left), right);
    }

    private void reverse(int[] a, int left, int right){
        while(left < right){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }
}
