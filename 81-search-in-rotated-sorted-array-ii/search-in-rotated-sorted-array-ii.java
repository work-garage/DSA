class Solution {
    // Rotated array Binary Search (sorted and unsorted part approach)

    // Q With duplicate elements
    public boolean search(int[] nums, int target) {
        int s=0,e=nums.length-1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(nums[mid]==target) return true;

            else if(nums[s]==nums[mid] && nums[mid]==nums[e]){
                s++;
                e--;
            }

            else if(nums[mid]<=nums[e]){        //checking is right sorted part?

                if(nums[mid]<target && target<=nums[e]){    // if target in right sorted part, we go to that part
                    s=mid+1;
                }
                else e=mid-1;       // otherwise to go left unsorted part
            }

            else if(nums[mid]>=nums[s]){        //checking is left sorted part?

                if(nums[mid]>target && target>=nums[s]){        // if target in left sorted part, we go to that part
                    e=mid-1;
                }
                else s=mid+1;       // otherwise to go right unsorted part
            }
        }

        return false;
    }
}