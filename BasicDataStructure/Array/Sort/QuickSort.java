package BasicDataStructure.Array.Sort;

import java.util.Random;

public class QuickSort {
    public void quickSort(int[] nums){
        if(nums == null || nums.length <= 1) return;
        quickSort(nums, 0, nums.length -1);
    }

    public void quickSort(int[] nums, int left, int right){
        //no need to sort
        if(right <= left) return;
        int pivot = partition(nums,left,right);

        quickSort(nums,left,pivot-1);
        quickSort(nums, pivot+1, right);

    }

    private int partition(int[] nums, int left, int right){
        Random r = new Random();
        //StdRandom.shuffle
        for(int i = 0; i< nums.length;i++){
            int j = r.nextInt(i+1);
            swap(nums,i,j);
        }

        int pivot = left + r.nextInt(right - left + 1);
        int pivotElement = nums[pivot];
        swap(nums,pivot,right);

        int i = left, j = right - 1;
        while(i <= j){
            if(nums[i] < pivotElement){
                i++;
            }else if(nums[j] >= pivotElement){
                j--;
            }else{
                swap(nums, i, j);
            }
        }
        swap(nums,i,right);
        return pivot;
    }

    public int[] swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}
