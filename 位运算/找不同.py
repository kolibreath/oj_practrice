class Solution(object):
    def findTheDifference(self, s, t):
        result = 0
        for c in s:
            result ^= ord(c)
        for c in t:
            result ^= ord(c)
        return chr(result)

if __name__ == "__main__":
    print(Solution().findTheDifference("abcd","abcde"))