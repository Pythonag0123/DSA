class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 0;

        for (int p : piles) {
            hi = Math.max(hi, p);
        }

        int ans = hi;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canEat(piles, h, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public boolean canEat(int[] piles, int h, int speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours <= h;
    }
}
