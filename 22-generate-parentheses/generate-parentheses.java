class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, "", 0, 0, ans);
        return ans;
    }

    public void helper(int n, String str, int countOpen, int countClose, List<String> ans) {
        
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }

        
        if (countOpen < n) {
            helper(n, str + "(", countOpen + 1, countClose, ans);
        }

        
        if (countClose < countOpen) {
            helper(n, str + ")", countOpen, countClose + 1, ans);
        }
    }
}
