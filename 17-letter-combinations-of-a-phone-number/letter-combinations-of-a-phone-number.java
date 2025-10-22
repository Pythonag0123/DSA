class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();

        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        List<String> ans = new ArrayList<>();
        helper(digits, mapping, 0, "", ans);
        return ans;
    }

    public void helper(String digits, String[] mapping, int idx, String str, List<String> ans) {
        // Base case
        if (idx == digits.length()) {
            ans.add(str);
            return;
        }

        // Get letters for current digit
        String letters = mapping[digits.charAt(idx) - '0'];

        // Recurse for each letter
        for (int i = 0; i < letters.length(); i++) {
            helper(digits, mapping, idx + 1, str + letters.charAt(i), ans);
        }
    }
}
