package com.example.leetcode.sort;

class QuicklySort {
    public int[] quicklysort( int[] nums) {
        if(nums.length == 0 || nums.length == 0) return nums;
        sort(nums,0,nums.length - 1);
        return nums;
    }
    public void sort(int nums[], int lo, int hi){
        if(lo >= hi) return; // lo == hi时数组只有一个元素了，不用比较
        int i= lo, j = hi + 1;
        while(true){
            while(++i <= hi && nums[i] < nums[lo]); // 前面的判断条件要等于的原因是需要让增加的i与hi进行比较，如果去掉等于就比较不了了
            while(--j >= lo && nums[j] > nums[lo]); // 后面的判断条件不能等于的原因是，如果等于之后将会进入下一次循环，i继续加或者j继续减就会数组越界，例如4,2,3,4比较到hi的时候如果相等再继续++i就越界了
            if(i >= j) break;// 等于就退出循环，没必要继续换位
            swap(nums,i,j);
        }
        swap(nums,lo,j); // 退出循环之后，说明num[j] <= nums[lo]且num[i] >= nums[lo],此时基准点为nums[lo],左边的比它小，右边的比它大，比它大的i已经跑到右边了，不需要换位，比它小的j还在右边，需要换位。
        sort(nums,lo,j-1);// 基准点变为nums[j]，左边的都比它小，右边的都比它大
        sort(nums,j+1,hi);
    }
    public void swap(int nums[], int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

