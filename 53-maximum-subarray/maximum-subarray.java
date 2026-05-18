// 1) Brute Force:
// O(N^2)
// Take sum on the way, do not recalculate again and again

// 2) Kadane's Algo:
// O(N)

class Solution {
    public int maxSubArray(int[] arr) {
        
        int max = Integer.MIN_VALUE;
        int currMax = -999999;          //not taken MIN_VALUE here because some elems eg -2 were doing: MIN_VALUE-2=> makes it +ve 2147483647 as numbers are in loop

        for(int i=0; i<arr.length; i++){
            
            currMax = Math.max( arr[i], currMax+arr[i]);
            // -> adding new elem to subarray sum. But Intuition is
            // -> If the previous sum is hurting you, drop it and start fresh.(arr[i])
            // -> If the previous sum is helping you, carry it forward.(currMax+arr[i])

            if(currMax>max) max=currMax;        // storing max sum found till now
        }

        return max;
    }
}

//-> Striver version is little different


//-> Here, its non-empty subarray question (this Q)

// if its empty subarray question: means if empty subarray is allowed to take, if largest sum is (-ve) we have to take empty subarray: sum = 0. But here its not the case.