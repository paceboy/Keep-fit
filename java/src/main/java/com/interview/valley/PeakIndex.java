package com.interview.valley;

/**
 * @author : liushaogeng
 * create at:  2021/6/17
 * @description: 获取山峰数组的索引
 * @Example 输入：arr = [0,10,5,2]
 * 输出：1
 */
public class PeakIndex {
    /**
     * 获取山峰数组的索引
     *
     * @param
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1, ans = 0;
        while (left <= right) {
            int mid = (left + right)/2;
            if (arr[mid] > arr[mid+1]){
                ans = mid;
                right = mid-1;
            }else{
                ans = mid + 1;
                left = mid +1;
            }
        }
        return ans;
    }
}
