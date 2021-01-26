package com.interview.sort;

/**
 * @author : liushaogeng
 * create at:  2021/1/26
 * @description:
 */
public class QuickSort {
    public void quickSort(int a[], int i, int j){
        if(i>=j){
            return;
        }
        int standard = getStandard(a, i, j);
        quickSort(a, i, standard-1);
        quickSort(a, standard+1, j);
        return;
    }

    //获取中间点
    public int getStandard(int a[], int i, int j){
        int key = a[i];
        while(i<j){
            while(i<j && a[j] > key){
                j--;
            }
            if(i<j){
                a[i] = a[j];
            }

            while(i<j && a[i] < key){
                i++;
            }
            if(i<j){
                a[j] = a[i];
            }
        }
        a[i] = key;
        return i;
    }


    public void display(int array[]){
        for(int i:array){
            System.out.println(i);
        }
    }
}
