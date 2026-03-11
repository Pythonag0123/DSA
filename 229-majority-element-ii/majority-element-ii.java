class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        int num = nums[0];
        int count = 1;

        for(int i = 1; i < n; i++){

            if(nums[i] == num){
                count++;
            }
            else{

                if(count > n/3){
                    ans.add(num);
                }

                num = nums[i];
                count = 1;
            }
        }

        if(count > n/3){
            ans.add(num);
        }

        return ans;
    }
}