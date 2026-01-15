class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int k = 0; k < 32; k++) {
            int mask = 1 << k;
            int countOnes = 0;

            for (int num : nums) {
                if ((num & mask) != 0) {
                    countOnes++;
                }
            }

            if (countOnes % 3 != 0) {
                result |= mask;
            }
        }

        return result;
    }
}
