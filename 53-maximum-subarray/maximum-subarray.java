// 1) Brute Force:
// O(N^2)
// Take sum on the way, do not recalculate again and again

// 2) Kadane's Algo:
// O(N)

class Solution {
    public int maxSubArray(int[] arr) {
        
        int max = Integer.MIN_VALUE;
        int currMax = -999999;

        for(int i=0; i<arr.length; i++){
            
            currMax = Math.max( arr[i], currMax+arr[i]);
            // -> adding new elem to subarray sum. But Intuition is
            // -> If the previous sum is hurting you, drop it and start fresh.(arr[i])
            // -> If the previous sum is helping you, carry it forward.(currMax+arr[i])

            // if(currMax<0) currMax=0;    // if subarray value(currSum) is -ve
                                        // again start from empty subset: sum=0 as largest

            if(currMax>max) max=currMax;        // storing max sum found till now
            
        }

        return max;
    }
}


// Here, its non-empty subarray question (this Q)

// if its empty subarray question: means if empty subarray is allowed to take, if largest sum is (-ve) we have to take empty subarray: sum = 0