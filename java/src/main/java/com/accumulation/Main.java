package com.accumulation;

import com.accumulation.summary.before.start.AppearOnce;

import java.awt.*;
import java.util.Arrays;

/**
 * @author liushaogeng
 * @date 2022/10/3 14:59
 * @description
 */
public class Main {
    public static void main(String[] args) {
        int a[] = {1, 2, 2, 3, 1};
        for(int i : a){
            System.out.printf("%d,", i);
        }
        System.out.printf("singleNumber singleNumber() = %d\n", AppearOnce.singleNumber(a));
        a = new int[]{1, 3, 2, 2, 3};
        for(int i : a){
            System.out.printf("%d,", i);
        }
        System.out.printf("singleNumber() = %d \n", AppearOnce.singleNumber(a));
        a = new int[]{3, 2, 2, 3, 0};
        for(int i : a){
            System.out.printf("%d,", i);
        }
        System.out.printf("singleNumber() = %d\n", AppearOnce.singleNumber(a));
    }
}
