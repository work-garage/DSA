class Solution {
    public int findPeakElement(int[] nums) {
        int s=0,e=nums.length-1;

        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(mid-1>=0 && mid+1<=nums.length-1 && nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }

            else if(mid-1>=0 && nums[mid-1]>nums[mid]){
                e=mid-1;
            }
            else if(mid+1<=nums.length-1 && nums[mid]<nums[mid+1]){
                s=mid+1;
            }
        }

        return -1;    // for no use, as here no testcase will come to it and it is must to return in return type function
    }
}