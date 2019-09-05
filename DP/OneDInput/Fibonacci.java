package DP.OneDInput;

public class Fibonacci {
        /*
        DP --- 从小到大累计计算
        data structure：
            int[] record --- index: n, record[i]: fib(n)
            (hashmap --- space consuming)
        algorithm:
            from base case(0,1) to n, f(n) = f(n-1) + f(n-2) 一步一步填表格
        Time = O(n)
        Space = O(n)
         */

    public long fibonacci(int n) {
        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i <= n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    /*
    空间优化：只用两个int来存f(n-1) 和 f(n-2), 因为f(n)只依赖于这两个值
    Space = O(1)
     */
    public long fibonacci2(int n) {
        long fib1 = 0;
        long fib2 = 1;
        long fib = 1;
        for(int i = 2; i <= n; i++){
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }
        return fib;
    }

    public void test1(){
        System.out.println(fibonacci2(4));
    }
}
