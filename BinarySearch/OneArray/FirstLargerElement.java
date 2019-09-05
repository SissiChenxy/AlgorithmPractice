package BinarySearch.OneArray;

public class FirstLargerElement {
    public int smallestElementLargerThanTarget(int[] array, int target) {
        // Write your solution here
        if(array == null || array.length == 0){
            return -1;
        }

        int index = binarySearch(array, 0, array.length - 1, target);

        return index;
    }

    private int binarySearch(int[] array, int left, int right, int target){
        if(target < array[left]){
            return 0;
        }
        if(target > array[right]) {
            return -1;
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] < target){
                left = mid + 1;
            }else if(array[mid] > target){
                right = mid;
            }
        }
        return right;
    }
}
