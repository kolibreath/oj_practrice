import random


class Solution(object):
    def majorityElement(self, nums):
        count = len(nums) // 2
        while True:
            candi = random.choice(nums)
            if sum(1 for elem in nums if elem == candi) > count:
                return candi
