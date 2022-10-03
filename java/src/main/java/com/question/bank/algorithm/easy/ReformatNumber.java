package com.question.bank.algorithm.easy;

/**
 * @author liushaogeng
 * @date 2022/10/3 15:43
 * @description
 */
public class ReformatNumber {
    /**
     * @description 格式化为有规则的电话号码
     * @param phonenumbers 不规则的电话号码
     */
    public static String formatNumber(String phonenumbers) {
        String finalRet = "";
        String ret = "";
        for(char c : phonenumbers.toCharArray()) {
            if (c == '-' || c == ' '){
                continue;
            }
            ret += c;
        }
        if(ret.length() < 3){
            return ret;
        }

        if(ret.length() == 4){
            finalRet += ret.substring(ret.length()-4, ret.length()-2);
            finalRet += "-" + ret.substring(ret.length()-2, ret.length());
            return finalRet;
        }

        int length = ret.length();
        int mod = length % 3;
        if (mod == 0){ // 被3整除
            finalRet = splitByNum(ret, 3);
        }else if(mod == 1) { //
            finalRet = splitByNum(ret.substring(0, ret.length()-4), 3);
            finalRet += "-" + ret.substring(ret.length()-4, ret.length()-2);
            finalRet += "-" + ret.substring(ret.length()-2, ret.length());
        }else {
            finalRet = splitByNum(ret.substring(0, ret.length()-2), 3);
            finalRet += "-" + ret.substring(ret.length()-2, ret.length());
        }
        return finalRet;
    }


    /**
     * @author liushaogeng
     * @date
     * @description
     * @param s 字符串
     * @param n 按照多长分割
     */
    private static String splitByNum(String s, int n){
        String ret = "";
        for (int i=0;i<s.length();i+=n){
            ret += s.substring(i, i+n);
            if (i+n < s.length()){
                ret += '-';
            }
        }
        return ret;
    }
}
