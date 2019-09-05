package BasicDataStructure.Array.Sort;

public class MergeSort {
    public void mergeSort(int[] nums ,int lo, int hi){
        if(nums != null || nums.length > 1){
            if(lo >= hi) return;
            int mid = lo + (hi - lo)/2;
            mergeSort(nums,lo,mid);
            mergeSort(nums,mid+1,hi);
            if(nums[mid] < nums[mid+1]) return;
            int[] helper = new int[nums.length];
            merge(nums,helper,lo,mid,hi);
        }
    }

    private static int[] merge(int[] nums, int[] helper, int lo, int mid, int hi){
        for(int i = 0; i<nums.length;i++){
            helper[i] = nums[i];
        }

        int i = lo, j = mid + 1, k = lo;
        while( i <= mid && j <= hi){
            if(helper[i] < helper[j]){
                nums[k] = helper[i];
                i++;
            }else{
                nums[k] = helper[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            nums[k] = helper[i];
            i++;
            j++;
        }
        return nums;
    }
}
