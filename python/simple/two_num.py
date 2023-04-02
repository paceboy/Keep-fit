# 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
#
# 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
#
# 你可以按任意顺序返回答案。
from typing import List


class TwoNum(object):
    def twoNum(self, nums: List[int], target: int) -> List[int]:
        # ret = []
        # for i in range(1, len(nums)):
        #     if target == nums[i] + nums[i - 1]:
        #         ret.append(i - 1)
        #         ret.append(i)
        #         break
        #
        # return ret

        hash = dict()
        for i, num in enumerate(nums):
            if target - num in hash:
                return [hash[target - num], i]
            hash[num] = i
        return []


two_num = TwoNum()
nums = [2, 7, 11, 15]
target = 9
ret = two_num.twoNum(nums, 9)
print(nums)
print('target = ' + str(target))
print(ret)

nums = [3, 2, 4]
target = 6
ret = two_num.twoNum(nums, 6)
print(nums)
print('target = ' + str(target))
print(ret)

nums = [3, 3]
target = 6
ret = two_num.twoNum(nums, 6)
print(nums)
print('target = ' + str(target))
print(ret)

nums = [1, 2, 3, 4, 5, 6]
target = 6
ret = two_num.twoNum(nums, 6)
print(nums)
print('target = ' + str(target))
print(ret)
