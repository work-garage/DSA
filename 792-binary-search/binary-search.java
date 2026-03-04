class Solution {
    public int search(int[] nums, int target) {
        int s=0,e=nums.length-1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(nums[mid]==target) return mid;
            else if(nums[mid]>target){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }

        return -1;
    }
}


    //////// Using recursion

    // public int search(int[] nums, int target) {
    //     int s=0,e=nums.length-1;

    //     return recur(s,e,nums,target);
    // }

    // int recur(int s, int e, int[] nums, int target){

    //     if(s<=e){
    //         int mid = s+(e-s)/2;

    //         if(nums[mid]==target) return mid;
    //         else if(nums[mid]>target){
    //             return recur(s,mid-1,nums,target);
    //         }
    //         else{
    //             return recur(mid+1,e,nums,target);
    //         }
    //     }

    //     return -1;
    // }
