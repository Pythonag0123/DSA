class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        int[] frq=new int[26];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            frq[s.charAt(i)-'a']++;
            q.add(i);
            while (!q.isEmpty() && frq[s.charAt(q.peek()) - 'a'] > 1) {
                q.poll();
            }
        }
        if (q.isEmpty()) {
            return -1;
        }

        return q.peek();
    }
}