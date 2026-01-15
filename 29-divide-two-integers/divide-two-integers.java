class Solution {
    public int divide(int dividend, int divisor) {

        // Edge case: overflow
        // -2^31 / -1 = 2^31 (out of int range)
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // If both are equal, result is 1
        if (dividend == divisor)
            return 1;

        // Determine sign of result
        boolean sign = true;
        if (dividend < 0 && divisor >= 0) sign = false;
        if (dividend >= 0 && divisor < 0) sign = false;

        // Convert both to positive (use long to avoid overflow)
        long n = Math.abs((long) dividend);
        long q = Math.abs((long) divisor);

        int ans = 0;

        // Main division loop
        while (n >= q) {

            int count = 0;

            // Find the maximum power of 2 such that (q << (count+1)) <= n
            while (n >= (q << (count + 1))) {
                count++;
            }

            // Add corresponding power of 2 to answer
            ans += (1 << count);

            // Reduce n by the largest shifted divisor
            n -= (q << count);
        }

        // Apply sign
        return sign ? ans : -ans;
    }
}
