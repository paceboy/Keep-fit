package com.question.algorithm.easy;

/*
    给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
    请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

        */
public class SortedArray {
    /*
     *  合并有序数组
     *
     * */
    public void merge(int[] num1, int m, int[] num2, int n) {
        if(n == 0) {
            return;
        }
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (num1[i] > num2[j]) {
                swap(num1, num2, i, j);
                for (int k = 0; k < n-1; k++) {
                    if (num2[k] > num2[k + 1]) {
                        swap(num2, num2, k, k+1);
                    }
                }
            }else {
                i++;
            }
        }

        while (i < m + n) {
            num1[i] = num2[j];
            i++;
            j++;
        }
    }

    /*
     *  合并有序数组
     *
     * */
    public void swap(int []num1, int []num2, int before, int after) {
        int temp;
        temp = num1[before];
        num1[before] = num2[after];
        num2[after] = temp;
        return;
    }


    public static void main(String[] args) {
        int num1[] = {1, 2, 3, 0, 0, 0};
        int num2[] = {2, 5, 6};
        SortedArray sortedArray = new SortedArray();
        sortedArray.merge(num1, 3, num2, 3);
        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }
    }
}
