class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count = 0
        candidate = -1
        for elem in nums:
            if count == 0:
                candidate = elem
            count += (1 if elem == candidate else -1)
        return candidate
