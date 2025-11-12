class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return lcsbu(nums1,nums2);
        
    }
    public static int lcsbu(int[] s1,int[] s2){
        int n=s1.length;
        int m=s2.length;
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}