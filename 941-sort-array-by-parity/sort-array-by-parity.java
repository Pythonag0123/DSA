class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int n=nums.length;
        int i=0;
        int k=0;
        int j=n-1;
        while(k<=j){
            if(nums[i]%2==0){
                swap(nums,k,i);
                i++;
                k++;
            }
            else{
                swap(nums,k,j);
                j--;
            }
        }
        return nums;

        
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}