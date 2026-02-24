class Solution {

    // Approach 2: way 1: Sliding Window
    // O(2N) + O(2N) for 2 calls of arrSum func, ach contains 2 nested loop which runs for (2N)
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


    // This way Won't workhere, bcz we did this Optimization for: not going below max len got till now, but here in many cases our answer is also present in less length than max len got till now array
    // Approach 2: way 2: Sliding Window (Optimization of not going below max len got till now❌)

    // public int numSubarraysWithSum(int[] nums, int goal) {
    //     if(goal==0) return arrSum(nums,goal); //for goal=0, goal-1 will give -1, thats wrong to be taken. So did this.
    //     return arrSum(nums,goal) - arrSum(nums,goal-1);
    // }
    // int arrSum(int[] nums, int g){
    //     int i=0,j=0,cnt=0,sum=0;
    //     while(j<nums.length){
            
    //         sum+=nums[j];

    //         if(sum>g){
    //             sum-=nums[i];
    //             i++;
    //         }

    //         if(sum<=g) cnt+=j-i+1;
    //         j++;
    //     }
    //     return cnt;
    // }



    // Approach 1: Brute-force
