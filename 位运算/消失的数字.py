class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result = 0
        for index in range(len(nums)):
            result = result ^ index ^ nums[index]
        result ^= len(nums)
        return result
