class Solution {

    // Superb Question:
    // 1) Not given array is sorted (so we can use binary search in non sorted questions as well)
    // 2) In interview, We need to optimize the linear iteration solution.
    // So, The art of identifying the Q can be solved by Binary Search approach is most amazing.
    // As array not sorted given and we can return any of the peak.

    // Approach: Imagine you are blindfolded on a mountain trail and can only feel the ground:
    // If the ground is going up, keep going forward (right).
    // If the ground is going down, turn back (left).
    // Eventually, you'll be at the top — the peak. These line helps alot to understand the logic ...

    //////// Reason
    // It worked because we are going towards greater element and we can return any one of the peak.
    // If i go towards greater element, cases: 
    // 1) Its next/prev elem is also greater: then that greater can be potential answer
    // 2) Its next/prev elem is smaller than this: then this greater elem is peak itself
    // 3) Its next/prev elem is element array end(from start or last): then this greater elem is peak itself 

    // O(log2 N)

    public int findPeakElement(int[] nums) {
        int s=0,e=nums.length-1;

        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(mid-1>=0 && mid+1<=nums.length-1 && nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;                 // conditions first 2 parts are to prevent index out of bound
            }

            else if(mid-1>=0 && nums[mid-1]>nums[mid]){
                e=mid-1;                    // conditions first part is to prevent index out of bound
            }
            else if(mid+1<=nums.length-1 && nums[mid]<nums[mid+1]){
                s=mid+1;                    // conditions first part is to prevent index out of bound
            }
        }

        return -1;    // for no use, as here no testcase will come to it
                      // and it is must to return in: return type function
    }
}


// Approach 1: Linear Search O(N)