
class Solution(object):
    def majorityElement(self, nums):
        candi = -1
        count = 0
        for elem in nums:
            if count == 0:
                candi = elem
            count += (1 if candi == elem else -1)
        return candi

