package com.question.bank;

import com.question.bank.algorithm.easy.ClimbStairs;
import com.question.bank.algorithm.easy.ReformatNumber;

/**
 * @author liushaogeng
 * @date 2022/10/3 17:32
 * @description
 */
public class Main {
    public static void main(String[] args) {

        ClimbStairs climbStairs = new ClimbStairs();
        int ret = climbStairs.solution(7);
        System.out.printf("climbStairs ret = %d\n", ret);

//        String pn = "1-23-45 6";
//        System.out.printf("formatNumber : pn = %s, formatNumber = %s", pn, ReformatNumber.formatNumber(pn));
//
//        pn = "123 4-567";
//        ReformatNumber.formatNumber(pn);
//
//        System.out.printf("formatNumber : pn = %s, formatNumber = %s", pn, ReformatNumber.formatNumber(pn));
//
//        pn = "123 4-5678";
//        ReformatNumber.formatNumber(pn);
//        System.out.printf("formatNumber : pn = %s, formatNumber = %s", pn, ReformatNumber.formatNumber(pn));
//
//        pn = "12";
//        ReformatNumber.formatNumber(pn);
//        System.out.printf("formatNumber : pn = %s, formatNumber = %s", pn, ReformatNumber.formatNumber(pn));
//
//        pn = "--17-5 229 35-39475 ";
//        ReformatNumber.formatNumber(pn);
//        System.out.printf("formatNumber : pn = %s, formatNumber = %s", pn, ReformatNumber.formatNumber(pn));
//
//        pn = "1234";
//        ReformatNumber.formatNumber(pn);
//        System.out.printf("formatNumber : pn = %s, formatNumber = %s", pn, ReformatNumber.formatNumber(pn));
    }
}
