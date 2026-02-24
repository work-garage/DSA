class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal==0) return arrSum(nums,goal); //for goal=0, goal-1 will give -1, thats wrong to be taken. So did this.
        return arrSum(nums,goal) - arrSum(nums,goal-1);
    }
    int arrSum(int[] nums, int g){
        int i=0,j=0,cnt=0,sum=0;
        while(j<nums.length){
            
            sum+=nums[j];

            while(sum>g){
                sum-=nums[i];
                i++;
            }

            cnt+=j-i+1;
            j++;
        }
        return cnt;
    }
}