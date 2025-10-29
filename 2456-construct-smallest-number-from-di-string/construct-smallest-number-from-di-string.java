class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int n = pattern.length();
        
        for (int i = 0; i <= n; i++) {
            st.push(i + 1);
            
            
            if (i == n || pattern.charAt(i) == 'I') {
                while (!st.isEmpty()) {
                    ans.append(st.pop());
                }
            }
        }
        
        return ans.toString();
    }
}
