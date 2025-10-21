class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, 0, "", ans);
        return ans;
    }

    public void helper(String s, int idx, String current, List<String> ans) {
        
        if (idx == s.length()) {
            ans.add(current);
            return;
        }

        char ch = s.charAt(idx);

        if (Character.isDigit(ch)) {
            
            helper(s, idx + 1, current + ch, ans);
        } else {
            
            helper(s, idx + 1, current + Character.toLowerCase(ch), ans);
            helper(s, idx + 1, current + Character.toUpperCase(ch), ans);
        }
    }
}

        