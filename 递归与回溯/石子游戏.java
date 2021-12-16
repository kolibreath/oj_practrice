public class 石子游戏 {
    static class Solution {
        public boolean stoneGame(int[] piles) {
            int sum = 0;
            for(int p : piles) sum += p;
            int alice = before(piles, 0, piles.length - 1);
            int bob = sum - alice;
            return alice >= bob;
        }

        private int before(int[] piles, int left, int right) {
            if (left == right) return piles[left];
            return Math.max(
                    piles[left] + after(piles, left + 1, right),
                    piles[right] + after(piles, left, right - 1)
                    );
        }

        private int after(int[] piles, int left, int right) {
            if (left < 0 || right >= piles.length || left >= right ) return 0;
            return Math.min(before(piles, left + 1, right), before(piles, left, right - 1));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] piles = new int[]{1,5,233,7};
        System.out.print(solution.stoneGame(piles));
    }
}
