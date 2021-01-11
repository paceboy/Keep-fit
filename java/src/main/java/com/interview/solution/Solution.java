package com.interview.solution;

public class Solution {
    public int rotate(int i){

        int ret = 0;
        int mod;
        while(i != 0){
            if (ret > Integer.MAX_VALUE/10 || ret < Integer.MIN_VALUE/10){
                return 0;
            }
            mod = i%10;
            ret = ret * 10 + mod;
            i = i/10;
        }
        return ret;
    }
}