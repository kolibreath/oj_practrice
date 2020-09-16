class Solution(object):
    def toChar(self, num):
        if num < 10:
            return chr(num + 48)
        else:
            return chr(97 + num - 10)

    def toHex(self, num):
        result = ""
        if num < 0:
            num = (abs(num) ^ (2 ** 32 - 1)) + 1
        elif num == 0:
            return '0'
        while num != 0:
                c = self.toChar(num % 16)
                result += c
                num = num >> 4

        return ''.join(reversed(result))


if __name__ == '__main__':
    c = Solution()
    print(c.toHex(-1))
