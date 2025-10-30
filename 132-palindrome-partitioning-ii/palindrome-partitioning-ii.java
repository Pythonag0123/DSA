class Solution {
    String s1;
    int[] dp;
    public int minCut(String s) {
        int n = s.length();
        s1 = s;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return cut(0) - 1; // Convert segments to cuts
    }
    private int cut(int i){
        if(i == s1.length()){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int minCost = Integer.MAX_VALUE;
        for(int j = i; j < s1.length(); j++){
            if(isPalin(i, j)){
                minCost = Math.min(minCost, 1 + cut(j + 1));
            }
        }
        return dp[i] = minCost;
    }
    private boolean isPalin(int i, int j){
        while(i < j){
            if(s1.charAt(i) == s1.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}