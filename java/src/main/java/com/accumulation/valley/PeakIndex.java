package com.accumulation.valley;

/**
 * @author : liushaogeng
 * create at:  2021/6/17
 * @description: 获取山峰数组的索引
 * @Example 输入：arr = [0,10,5,2]
 * 输出：1
 *
 * 选择「二分」还是「三分」取决于要解决的是什么问题：
 * 二分通常用来解决单调函数的找target问题，但进一步深入我们发现只需要满足「二段性」就能使用「二分」来找分割点；
 * 三分则是解决单峰函数极值问题。
 * 因此一般我们将「通过比较两个端点，每次否决 1/3 区间 来解决单峰最值问题」的做法称为「三分」；而不是简单根据单次循环内将区间分为多少份来判定是否为「三分」。
 *
 */
public class PeakIndex {
    /**
     * 获取山峰数组的索引
     * 2分法
     * @param
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length ==1 ){
            return 0;
        }
        if (arr.length == 2 ){
            return arr[0] > arr[1]?0:1;
        }
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

    /**
     * 获取山峰数组的索引
     * 3分法
     * @param
     * @return
     */
    public int peakIndexInMountainArrayByThree(int[] arr) {
        int l, r, m1, m2;
        l = 0;
        r = arr.length-1;
        while(l < r){
            m1 = l + (r-l)/3;
            m2 = r - (r-l)/3;
            if(arr[m1] > arr[m2]){
                r = m2-1;
            }else{
                l = m1+1;
            }
        }
        return r;
    }
}
