class Solution {

    /////// Approach: Even/Odd pattern

    // Array

    // Value:  1  1  2  2  3  3  4  5  5  6  6
    // Index:  0  1  2  3  4  5  6  7  8  9 10

    // Index Parity

    // 1    1    2    2    3    3    4    5    5    6    6
    // |    |    |    |    |    |    |    |    |    |    |
    // Even Odd  Even Odd  Even Odd  Even Odd  Even Odd  Even

    // Pair Structure

    // (1,1) (2,2) (3,3)  4  (5,5) (6,6)
    // E-O   E-O   E-O   S   O-E   O-E


    // S = Single element

    //     // Pattern Observation:                              // IMP

    // (even, odd) → single element is in the right half
    // (odd, even) → single element is in the left half

    ////////

    // Approach: Even/Odd pattern
    public int singleNonDuplicate(int[] nums) {
        int s=0,e=nums.length-1;

        if(nums.length==1) return nums[0];

        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];

        while(s<=e){
            int mid = s+(e-s)/2;

            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
            
            else if(nums[mid]==nums[mid-1]){            // if previous elem of mid same
                if((mid)%2==0) e=mid-1;                 // mid even
                else s=mid+1;                             // mid odd
            }
            else if(nums[mid]==nums[mid+1]){            // if next elem of mid same
                if((mid)%2==0) s=mid+1;               // mid even
                else e=mid-1;                             // mid odd
            }
        }
        return nums[0];
    }
}



    // this Approach❌ won't work as doing s=mid or e=mid instead of s=mid+1 or e=mid-1: starts infinity loop for cases like: [1,1,2]

    // public int singleNonDuplicate(int[] nums) {
    //     int s=0,e=nums.length-1;

    //     if(nums.length==1) return nums[0];

    //     while(s<=e){
    //         int mid = s+(e-s)/2;

    //         if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
    //         else if(nums[mid]==nums[mid-1]){            // if previous elem of mid same
    //             if((mid-s+1)%2==0) s=mid;               // length even
    //             else e=mid;                             // length odd
    //         }
    //         else if(nums[mid]==nums[mid+1]){            // if next elem of mid same
    //             if((e-mid+1)%2==0) e=mid;               // length even
    //             else s=mid;                             // length odd
    //         }
    //     }
    //     return nums[0];
    // }




    // this Approach❌ won't work until you add condition of not accseesing elem before s and after e: eg. testcase like: [1,1,2,2,3]

    // public int singleNonDuplicate(int[] nums) {
    //     int s=0,e=nums.length-1;

    //     if(nums.length==1) return nums[0];

    //     while(s<=e){
    //         int mid = s+(e-s)/2;

    //         // boolean n1 = nums[mid]!=nums[mid-1];
    //         // boolean n2 = nums[mid]!=nums[mid+1];

    //         if( (mid-1<0 && nums[mid]!=nums[mid+1])
    //         ||  ( mid+1>nums.length-1 && nums[mid]!=nums[mid-1])
    //         ||  (nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) ) return nums[mid];

    //         else if(nums[mid]==nums[mid-1]){            // if previous elem of mid same
    //             if((mid-s+1)%2==0) s=mid+1;               // length even
    //             else e=mid-1;                             // length odd
    //         }
    //         else if(nums[mid]==nums[mid+1]){            // if next elem of mid same
    //             if((e-mid+1)%2==0) e=mid-1;               // length even
    //             else s=mid+1;                             // length odd
    //         }
    //     }
    //     return nums[0];
    // }

    



    /////////////// Brute force O(N)

    // public int singleNonDuplicate(int[] nums) {

    //     if(nums.length==1) return nums[0];
        
    //     int n = nums.length;
        
    //     // Case 3: Middle element
    //     for(int i = 1; i < n-1; i++) {
    //         if(i==0) {                     // Case 1: First element
    //             if(nums[0] != nums[1]) return nums[0];
    //         }
    //         if(i==nums.length-1){          // Case 2: Last element
    //             if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];
    //         }
    //         if(nums[i] != nums[i-1] && nums[i] != nums[i+1])
    //             return nums[i];
    //     }
        
    //     return -1;
    // }
