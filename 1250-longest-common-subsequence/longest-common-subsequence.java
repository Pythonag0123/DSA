class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return lcs(text1,text2,dp,0,0);
        
    }
    public int lcs(String text1,String text2,int[][] dp,int i,int j){
        if(i>=text1.length()||j>=text2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        if(text1.charAt(i)==text2.charAt(j)){
            ans=1+lcs(text1,text2,dp,i+1,j+1);
        }
        else{
            int f=lcs(text1,text2,dp,i+1,j);
            int s=lcs(text1,text2,dp,i,j+1);
            ans+=Math.max(f,s);
        }
        return dp[i][j]=ans;
    }
}