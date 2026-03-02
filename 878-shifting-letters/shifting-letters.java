class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        StringBuilder sb = new StringBuilder(s);

        // Step 1: Make shifts cumulative from right
        for(int i = n - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }

        // Step 2: Apply shifts
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int newChar = (ch - 'a' + shifts[i]) % 26;
            sb.setCharAt(i, (char)(newChar + 'a'));
        }

        return sb.toString();
    }
}