package com.interview.solution;

/**
 * @author : liushaogeng
 * create at:  2021/7/9
 * @description:
 */
public class FirstBadVersion extends VersionControl{
    /**
     * create by shaogeng at 2021/7/9 19:38
     * description: 第一个错误版本
     *
     * @param version
     * @return
     */
    public int firstBadVersion(int version){
        int start = 1;
        int end = version;
        int mid = 1;

        while(start < end){
            mid = start + (end-start)/2;
            // 非坏版本
            if(!isBadVersion(mid)){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return mid;
    }
}
