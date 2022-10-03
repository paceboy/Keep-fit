package com.accumulation.summary.before.start;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liushaogeng
 * @date 2022/10/3 14:55
 * @description
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class AppearOnce {

    public static int singleNumber(int[] nums) {
        int method = 1;
        // 使用Set方法的方案
        if (method == 1){
            return singleNumberBySet(nums);
        } else {
            return singleNumberByXor(nums);
        }
    }

    /*
       * @Desc:使用xor异或
       * @param nums
        a^a=0；自己和自己异或等于0
        a^0=a；任何数字和0异或还等于他自己
        a^b^c=a^c^b；异或运算具有交换律
    */
    private static int singleNumberByXor(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }

    /*
       * @Desc:使用hashset
       * @param nums
        */
    private static int singleNumberBySet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if (false == set.add(i)) {
                set.remove(i);
            }
        }
        Object[] ret = set.toArray();
        return (int)ret[0];
    }
}
