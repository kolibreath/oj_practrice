class Solution:
    def reverseBits(self, n):
        ret, power = 0, 31
        while n != 0:
            ret = ret + ((n & 1) << power)
            n = n >> 1
            power -= 1
        return ret % 0x100000000

