class Solution {
    public int maxResult(int[] nums, int k) {
        int n=nums.length;
        int max=nums[0];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        pq.offer(new int[]{0,nums[0]});
        for(int i=1;i<n;i++){
            while(i-pq.peek()[0]>k){
                pq.poll();
            }
            int[] top=pq.peek();
            max=top[1]+nums[i];
            pq.offer(new int[]{i,max});
        }
        return max;
         

        
    }
}