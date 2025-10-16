class Solution {
    public double myPow(double x, int n) {
        // Base cases
        if (n == 0) return 1.0;
        if (x == 0) return 0.0;

        // Handle negative powers
        if (n < 0) {
            // Special handling for Integer.MIN_VALUE
            if (n == Integer.MIN_VALUE) {
                // Use reciprocal base properly
                return (1.0 / x) * myPow(1 / x, Integer.MAX_VALUE);
            }
            return myPow(1 / x, -n);
        }

        return powerHelper(x, n);
    }

    private double powerHelper(double x, int n) {
        if (n == 0) return 1.0;

        double half = powerHelper(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else
            return x * half * half;
    }
}
