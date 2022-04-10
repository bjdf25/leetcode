package com.example.leetcode.sword;

import java.util.Arrays;

/**
 * 最小的k个数
 */
public class TopK {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr,k,0,arr.length - 1);
        return Arrays.copyOf(arr,k);
    }
    public void quickSort(int[] arr, int k, int l, int h) {
        if(l >= h) return;
        int i = l;
        int j = h + 1;
        while(i < j) {
            // 前面的比较条件一定要等于，因为等于之后也需要做一次判断，判断索引最后一位数与参考数的大小关系
            while(++i <= h && arr[i] < arr[l]);
            while(--j >= l && arr[j] > arr[l]);
            if( i >= j) break;
            swap(arr,i,j);
        }
        swap(arr,l,j);
        if(k == j) return;
        quickSort(arr,k,l,j-1);
        quickSort(arr,k,j+1,h);

    }
    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
