class Solution {
    // Approach 2: way 1: Sliding Window
    // O(2N) of arrSum func, contains 2 nested loop So, runs for (2N)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;              //
        int i=0,j=0,cnt=0,product=1;
        while(j<nums.length){
            
            product*=nums[j];

            while(product>=k){          //
                product/=nums[i];
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
