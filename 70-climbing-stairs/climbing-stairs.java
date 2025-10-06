class Solution {

    int[] dp; // to store ways
    public int recursion(int n){ // TC = O(n) with DP (Only recursion => O(2^n))
        if(n==0) return 1; // base case
        else if(n<0) return 0;

        if(dp[n]!=0){ // check if this value is already calculated
            return dp[n]; // directly return it, if yes
        }
        dp[n] = recursion(n-1) + recursion(n-2); // memoization step
        return dp[n];
    }

    public int iteration(int n){ // TC = O(n) with DP (Only recursion => O(2^n))
        int[] tb = new int[n+1]; // table
        tb[0] = 1; // initialize base value

        for(int i=1; i<n+1; i++){
            if(i==1){
                tb[i] = tb[i-1]+0;
            }else{
                tb[i] = tb[i-1] + tb[i-2]; // tabulation step
            }
        }

        return tb[n];
    }

    public int climbStairs(int n) {
        // fibonacci category question => f(n-1) + f(n-2) Pattern
        
        dp = new int[n+1]; // dynamic programming (memoization)
        // return recursion(n);

        return iteration(n); // tabulation
    }
}