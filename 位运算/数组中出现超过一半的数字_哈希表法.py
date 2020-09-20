class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        size = len(nums) // 2
        dict = {}
        for elem in nums:
            dict[elem] = 1 if dict.get(elem) is None else dict.get(elem) + 1
        for key in dict.iterkeys():
            if dict[key] > size:
                return key
