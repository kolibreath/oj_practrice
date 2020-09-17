class Solution(object):
    def xorOperation(self, n, start):
        result = 0
        i = 0
        next = 0
        while i < n:
            next = start + i * 2
            result ^= next
            i = i + 1
        return result


if __name__ == "__main__":
    print(Solution().xorOperation(10, 5))
