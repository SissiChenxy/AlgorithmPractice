package BinarySearch.OneArray;

public class ShiftedSorted {
    public int search(int[] array, int target) {
        // Write your solution here
        if(array == null || array.length == 0){
            return -1;
        }

        if(array.length == 1 && target == array[0]){
            return 0;
        }else if(array.length == 1 && target != array[0]){
            return -1;
        }

        int shift = 1;
        while(shift < array.length && array[shift - 1] < array[shift]){
            shift++;
        }
        if(shift == array.length - 1 && array.length != 2){
            shift = 0;
        }

        return binarySearch(array, shift, shift + array.length - 1, target);
    }

    private int binarySearch(int[] array, int left, int right, int target){
        if(target > array[right % array.length] || target < array[left % array.length]){
            return -1;
        }

        while(left <= right){
            int mid = left + (right - left) / 2;
            int midEle = array[mid % array.length];
            if(midEle == target){
                return mid % array.length;
            }else if(midEle > target){
                right = mid - 1;
            }else if(midEle < target){
                left = mid + 1;
            }
        }
        return -1;
    }
}
