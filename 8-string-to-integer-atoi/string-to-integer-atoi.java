class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int idx = 0;
        int n = s.length(); // FIX: Use s.length() method

        // Skip leading whitespace
        while (idx < n && s.charAt(idx) == ' ') {
            idx++;
        }

        if (idx == n) return 0;

        int sign = 1;
        // FIX: Use 'if'/'else if' to handle signs correctly
        if (s.charAt(idx) == '+') {
            idx++;
        } else if (s.charAt(idx) == '-') {
            sign = -1;
            idx++;
        }

        // FIX: Must RETURN the result of the helper call
        // FIX: Must pass the CURRENT index, not 0
        return helper(s, idx, sign, 0L);
    }

    private int helper(String s, int idx, int sign, long result) {
        // --- BASE CASE ---
        // FIX: Use || and check index boundary first to prevent errors
        if (idx == s.length() || !Character.isDigit(s.charAt(idx))) {
            // FIX: Correct casting precedence
            return (int) (result * sign);
        }

        int digit = s.charAt(idx) - '0';
        long newResult = result * 10 + digit;

        // --- OVERFLOW CHECK (with corrected constants) ---
        if (sign == 1 && newResult > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        // FIX: Check negative newResult against MIN_VALUE
        if (sign == -1 && -newResult < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        // FIX: Must RETURN the result of the recursive call
        return helper(s, idx + 1, sign, newResult);
    }
}