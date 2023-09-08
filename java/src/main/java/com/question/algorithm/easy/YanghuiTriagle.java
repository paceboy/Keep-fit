package com.question.algorithm.easy;

import java.util.*;


/*
*
* 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

  在「杨辉三角」中，每个数是它左上方和右上方的数的和。
  *
示例 1:

输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
示例 2:

输入: numRows = 1
输出: [[1]]
*
* */
public class YanghuiTriagle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                Integer meta;
                if (j == 0 || j == i) {
                    meta = 1;
                } else {
                    meta = ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j);
                }

                innerList.add(meta);
            }

            ret.add(innerList);
        }
        return ret;
    }

    /*
    转换为有效ip
    @param
    @return
*/
    public List<String> getIP(String s) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < i + 1 + 3; j++) {
                for (int k = j + 1; k < j + 1 + 3; k++) {
                    int l = s.length() - i - j - k;
                    if (l >= 1 && l <= 3) {
                        int num1 = Integer.parseInt(s.substring(0, i + 1));
                        int num2 = Integer.parseInt(s.substring(i + 1, i + 1 + j));
                        int num3 = Integer.parseInt(s.substring(i + 1 + j, i + j + k));
                        int num4 = Integer.parseInt(s.substring(i + j + k ));

                        if (num1 < 256 && num2 < 256 && num3 < 256 && num4 < 256) {
                            String temp = num1 + "." + num2 + "." + num3 + "." + num4;
                            ret.add(temp);
                        }
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        YanghuiTriagle yanghuiTriagle = new YanghuiTriagle();
        List ret = yanghuiTriagle.getIP("12345");
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
//        YanghuiTriagle yanghuiTriagle = new YanghuiTriagle();
//        for (int numRows = 0; numRows<30; numRows++) {
//            List<List<Integer>> yanghuiTriagleContent = yanghuiTriagle.generate(numRows);
//            for (int i = 0; i < yanghuiTriagleContent.size(); i++) {
//                for (int j = 0; j < yanghuiTriagleContent.get(i).size(); j++) {
//                    System.out.printf("%d %d %d %d \n", numRows, i, j, yanghuiTriagleContent.get(i).get(j));
//                }
//                System.out.println();
//            }
//        }
    }
}
