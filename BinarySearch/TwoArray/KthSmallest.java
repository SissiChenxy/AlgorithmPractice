package BinarySearch.TwoArray;

public class KthSmallest {
    /*
    two pointers i and j, 谁小移谁
        做k次循环，不超界时比大小，谁小移谁；超界时，移动未超界的那一个
        time = O(k)
        space = O(1)
     */

    public int kth(int[] a, int[] b, int k) {
        // Write your solution here
        int i = 0;
        int j = 0;
        int number = 0;
        while(k > 0){
            int aval = i < a.length ? a[i] : Integer.MAX_VALUE;
            int bval = j < b.length ? b[j] : Integer.MAX_VALUE;
            if(aval < bval){
                number = aval;
                i++;
            }else{
                number = bval;
                j++;
            }
            k--;
        }
        return number;
    }

    /*
    优化：
    binary search, 谁小删除谁 (不断缩小搜索空间)
        a，b中找第k/2小的数，谁小删除谁以及前半部分 --- 问题规模减半，找第k/2小的
        找第k小
        找第k/2小
        找第k/4小
        。。。
        找第1小

        time = O(logk)
        space = O(logk)
     */

    public int kthSmallest(int[] a, int[] b, int k){
        return helper(a, b, 0, 0, k);
    }

    private int helper(int[] a, int[] b, int aLeft, int bLeft, int k){
        //aLeft points to the first undeleted number in A
        //bLeft points to the first undeleted number in B
        //base case
        if(aLeft >= a.length){
            return b[bLeft + k - 1];
        }
        if(bLeft >= b.length){
            return a[aLeft + k - 1];
        }

        if(k == 1){
            return Math.min(a[aLeft], b[bLeft]);
        }

        int amid = aLeft + k / 2 - 1;
        int bmid = bLeft + k / 2 - 1;

        //if a's index is out of bound, remove the elements from b first
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
        if(aval < bval){
            return helper(a, b, amid + 1, bLeft, k - k/2);
        }else{
            return helper(a, b, aLeft, bmid + 1, k - k/2);
        }

    }

    public void test1(){
        int[] a = new int[]{1,2,3,4};
        int[] b = new int[]{5};
        System.out.println(kth(a, b, 5));
    }
}
