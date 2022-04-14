package com.example.leetcode.sword.easy;

/**
 * 在排序数组中查找数字 I
 * 递增数组优先考虑二分法
 */
public class SearchInSortArray {
    // 搜索target左右边界
    public int search1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                // 保持i在target后一位，右边界
                i = m + 1;
            } else if (nums[m] > target) {
                j = m - 1;
            }
        }
        int right = i;
        // 提前返回，target存在于数组中时这个时候nums[j]必定等于target
        if (j >= 0 && nums[j] != target) return 0;
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] >= target) {
                // 保持j在target前一位，左边界
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            }
        }
        int left = j;
        return right - left - 1;
    }

    // target右边界 - (target - 1)右边界
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    // helper方法会返回比target大的数中离target最近的数的索引位置，以解决target不存在或target-1不存在的场景
    // [5,7,7,8,8,10], target = 7 , index = 3; target - 1 = 6, index = 1;
    int helper(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,7,7,8,8,10};
        SearchInSortArray searchInSortArray = new SearchInSortArray();
        int search = searchInSortArray.search(nums, 7);
    }
}
