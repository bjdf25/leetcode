package com.example.leetcode.sword.mid;

/**
 * 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
public class MyPow {
    // 循环乘以x时间复杂度为O(n),超出时间限制，考虑用二分将幂数二分，幂数二分后需将底数增为二次幂（当幂数为奇数时由于向下整除漏一个数的问题，需将底数再次乘一个底数）
    public double myPow(double x, int n) {
        double res = 1.0;
        // Java 代码中 int32 变量 n ∈[−2147483648,2147483647] ，
        // 因此当 n=−2147483648 时执行 n = -n会因越界而赋值出错。解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
        long b = n;
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        while (n > 0) {
            // b为奇数时向下整除会漏掉一个:9 / 2 = 4;将漏掉的这个补进底数中
            // 2^9 = 2*(2^2)^4 = 2*((2^2)^2)^2 = 2*(((2^2)^2)^2)^1 = 2*(((2^2)^2)^2)
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
