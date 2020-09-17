class Solution(object):
    def isPowerOfTwo(self, n):
        if n == 0 : return False
        negetive = ~n + 1
        if negetive & n == n:
            return True
        else:
            return False


if __name__ == "__main__":
    print( Solution().isPowerOfTwo(0))