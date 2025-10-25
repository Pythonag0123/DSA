class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0.0;
        if(n==0) return 1.0;
        if(n<0){
            if(n==Integer.MIN_VALUE){
                return (1.0/x)*myPow(1/x,Integer.MAX_VALUE);
            }
            return helper(1/x,-n);
        }
        return helper(x,n);
    }
    public double helper(double x,int n){
        if(n==0) return 1.0;
        double half=helper(x,n/2);
        if(n%2==0) return half*half;
        return half*half*x;
    }
}
