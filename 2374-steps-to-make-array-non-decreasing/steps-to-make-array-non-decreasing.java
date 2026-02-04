class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> st=new Stack<>();
        int ans=0;
        for(int num: nums){
            int steps=0;
            while(!st.isEmpty() && num>=st.peek()[0]){
                steps=Math.max(steps,st.pop()[1]);
            }
            if(st.isEmpty()) steps=0;
            else{
                steps++;
            }
            ans=Math.max(ans,steps);
            st.push(new int[]{num,steps});
        }
        return ans;
       


        
    }
}