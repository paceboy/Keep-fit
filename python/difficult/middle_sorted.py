
# 2023.4.8

# 给定两个大小分别为m和n的正序（从小到大）数组nums1和nums2。请你找出并返回这两个正序数组的中位数。
# 算法的时间复杂度应该为O(log(m + n))。

# 示例 1：
# 输入：nums1 = [1,3], nums2 = [2]
# 输出：2.00000
# 解释：合并数组 = [1,2,3] ，中位数 2
#
# 示例 2：
# 输入：nums1 = [1,2], nums2 = [3,4]
# 输出：2.50000
# 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

# 1)第K小的数
# 2）合并两个有序数据组
from typing import List

class MiddleSorted:
    def findMidSortedArr(self, nums1: List[int], nums2: List[int]) -> float:
        def findKthElement(k: int) -> int:
            idx1, idx2 = 0, 0
            while True:
                if idx1 == m:
                    return nums2[idx2+k-1]
                if idx2 == n:
                    return nums1[idx1+k-1]
                if k == 1:
                    return min(nums1[idx1], nums2[idx2])
    
                newIndex1 = min(idx1 + k // 2 - 1, m-1)
                newIndex2 = min(idx2 + k // 2 - 1, n-1)
    
                pivot1 = nums1[newIndex1]
                pivot2 = nums2[newIndex2]
                if pivot1 < pivot2:
                    k -= newIndex1 - idx1 + 1
                    idx1 = newIndex1+1
                else:
                    k -= newIndex2 - idx2 + 1
                    idx2 = newIndex2 + 1
    
        m, n = len(nums1), len(nums2)
        if (m+n) % 2 != 0:
            return findKthElement((m+n)//2)
        else:
            return (findKthElement((m+n)//2) + findKthElement((m+n)//2+1)) / 2
        
ms = MiddleSorted()
print(ms.findMidSortedArr([1,3,5,7,9], [4,5,6,7]))

print(ms.findMidSortedArr([1, 3, 4, 9], [1, 2, 3, 4, 5, 6, 7, 8, 9]))

print(ms.findMidSortedArr([1, 3, 4, 9], [1, 2, 3, 4, 5, 6, 7, 8]))
