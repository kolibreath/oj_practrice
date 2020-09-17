class Solution(object):
    def getSum(self, a, b):
        mask = 0x100000000
        max = 0x7FFFFFFF
        min = max + 1
        while b != 0:
            carry = (a & b) <<1
            a = (a ^ b) % mask
            b = carry % mask
        return a if a <= max else ~((a % min) ^ max)

if __name__ == "__main__":
    print( Solution().getSum(-12, -8))