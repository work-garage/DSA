class Solution {
    // Rotated array Binary Search (sorted and unsorted part approach)

    public int findMin(int[] nums) {

        if(nums[nums.length-1]>=nums[0]) return nums[0];

        int s=0,e=nums.length-1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(nums[mid]<=nums[e]){
                if(nums[mid-1]>nums[mid]) return nums[mid];
                else e=mid-1;
            }
            else if(nums[mid]>=nums[0]) s=mid+1;

        }
        return nums[0];         // even though handled upper at nums[e]>=nums[s] but, phirbhi: if(nums.length==1)
    }
}

    // Approach 1: so much dense all possible condition wise
    // public int findMin(int[] nums) {

    //     if(nums.length==1) return nums[0];

    //     int s=0,e=nums.length-1;

    //     while(s<=e){
    //         int mid = s+(e-s)/2;

    //         if(nums[e]>nums[s]) return nums[0];
    //         else{                                          //  nums[e]<nums[s]
    //             if(mid-1<0) s=mid+1;
    //             else if(mid+1>=nums.length && nums[mid-1]>nums[mid]) return mid;
    //             else if(mid+1>=nums.length && nums[mid-1]<nums[mid]) e=mid-1; 
    //             else if(nums[mid-1]>nums[mid] && nums[mid]<nums[mid+1]) return nums[mid];
    //             else if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]) return nums[mid+1];
    //             else if(nums[mid-1]<nums[mid] && nums[mid]<nums[mid+1] && nums[mid]<nums[e]) e=mid-1;
    //             else if(nums[mid-1]<nums[mid] && nums[mid]<nums[mid+1] && nums[mid]>nums[s]) s=mid+1;
    //         }
    //     }
    //     return -1;
    // }





// class Solution {
//     // Rotated array Binary Search (sorted and unsorted part approach)

//     public int findMin(int[] nums) {

//         int s=0,e=nums.length-1;

//         while(s<=e){
//             int mid = s+(e-s)/2;

//             if(nums[e]>=nums[s]) return nums[0];    // handling not rotated array
//                                                     // and due to = in it, if(nums.length==1) => return nums[0]

//             else{                                   // nums[e]<nums[s]
//                 if(nums[mid]<=nums[e]){
//                     if(nums[mid-1]>nums[mid]) return nums[mid];
//                     else e=mid-1;
//                 }
//                 else if(nums[mid]>=nums[0]) s=mid+1;
//             }
//         }
//         return nums[0];         // even though handled upper at nums[e]>=nums[s] but, phirbhi: if(nums.length==1)
//     }
// }