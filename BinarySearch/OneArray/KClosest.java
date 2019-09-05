package BinarySearch.OneArray;

import java.util.Arrays;

public class KClosest {
    /*
    中心开花，谁近移谁
        先找最接近target的，再L, R两指针向两边移动
        time = O（logn + k）
     */
    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        if(array.length == 0){
            return array;
        }

        if(k == 0){
            return new int[0];
        }
        int[] result = new int[k];
        int left = findMid(array,target);
        int right = left + 1;
        for(int i = 0; i < k; i++){
            //取等号的情况: 因为我们优先考虑right元素，所以 mid 向上取，left是最后一个元素
            if(right >= array.length || left >= 0 && target - array[left] < array[right] - target){
                result[i] = array[left--];
            }else{
                result[i] = array[right++];
            }
        }
        return result;
    }

    private int findMid(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(target <= array[mid]){
                right = mid;
            }else{
                left = mid;
            }
        }

        //deal with 2 elements situation, consider right first
        if(array[right] <= target){
            return right;
        }else if(array[left] <= target){
            return left;
        }
        return -1;
    }

    /*
    优化：
        不适用于print(k) ----- 一定是 O(k)
        适用于找边界，k个数index的范围

        优化找k个这一步，k --> logk
        站在中点往左右看，左右两个数组中距离target的distance是升序排列的
            找A, B中前k-1小的数(按distance)
        time = O（logn + logk）
     */
    public int[] kClosest2(int[] array, int target, int k){
        if(array.length == 0){
            return array;
        }

        if(k == 0){
            return new int[0];
        }
        //左右边界 闭区间
        int[] result = new int[2];

        int mid = findMid(array, target);
        helper(array,mid - 1, mid + 1, k - 1, target, result);
        return result;
    }

    private void helper(int[] array, int aLeft, int bLeft, int k, int target, int[] result){
        if(aLeft < 0){
            result[0] = aLeft + 1;
            result[1] = bLeft + k - 1;
            return;
        }
        if(bLeft >= array.length){
            result[0] = aLeft - k + 1;
            result[1] = bLeft - 1;
            return;
        }
        if(k == 1){
            if(Math.abs(array[aLeft] - target) > Math.abs(array[bLeft] - target)){
                result[0] = aLeft + 1;
                result[1] = bLeft;
            }else{
                result[0] = aLeft;
                result[1] = bLeft - 1;
            }
            return;
        }

        int amid = aLeft - k / 2 + 1;
        int bmid = bLeft + k / 2 - 1;
        int aval = amid < 0 ? Integer.MAX_VALUE : Math.abs(array[amid] - target);
        int bval = bmid >= array.length ? Integer.MAX_VALUE : Math.abs(array[bmid] - target);
        if(aval < bval){
            helper(array, amid - 1, bLeft, k - k / 2, target, result);
        }else {
            helper(array, aLeft, bmid + 1, k - k / 2, target, result);
        }
    }

    public void test1(){
        int[] a = new int[]{3,3,4,8,9};
        System.out.println(kClosest2(a, 5, 3)[0] + " " + kClosest2(a, 5, 3)[1]);
    }
}
