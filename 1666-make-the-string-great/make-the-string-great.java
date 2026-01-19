class Solution {
    public String makeGood(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);

            if (!st.isEmpty()) {
                char top = st.peek();

                // Same letter but different case
                if (Character.toLowerCase(curr) == Character.toLowerCase(top)
                    && curr != top) {
                    st.pop();
                    continue;
                }
            }

            st.push(curr);
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
