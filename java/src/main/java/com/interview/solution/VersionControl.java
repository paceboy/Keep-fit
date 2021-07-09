package com.interview.solution;

/**
 * @author : liushaogeng
 * create at:  2021/7/9
 * @description:
 */
public class VersionControl {
    private int badVersion;
    /**
     * create by shaogeng at 2021/3/22 19:38
     * description: 二分法查找
     *
     * @param version
     * @return
     */
    public boolean isBadVersion(int version){
        return version <= badVersion ? true : false;
    }

    public int getBadVersion() {
        return badVersion;
    }

    public void setBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }
}
