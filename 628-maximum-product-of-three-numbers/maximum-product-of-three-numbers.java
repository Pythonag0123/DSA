class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int product=1;
        int maxProduct=1;
        for(int i=0;i<2;i++){
            maxProduct*=nums[i];
        }
        maxProduct*=nums[n-1];
        for(int i=1;i<4;i++){
            product*=nums[n-i];
        }
        return Math.max(product,maxProduct);
        

    
            
        
        
    }
}