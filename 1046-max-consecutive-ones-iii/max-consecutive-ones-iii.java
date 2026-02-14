class Solution {
        public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int maxLen=0;
        Queue<Integer> seqOfZeroesInSequence = new ArrayDeque<>();

        while(j<nums.length){
            if(nums[j]==1){
                maxLen=Math.max(j-i+1,maxLen);
                j++;
            }
            else{

                seqOfZeroesInSequence.add(j);

                if(k>0){
                    k--;
                    maxLen=Math.max(j-i+1,maxLen);
                    j++;
                }
                else{

                    i=seqOfZeroesInSequence.peek()+1;
                    seqOfZeroesInSequence.remove();

                    maxLen=Math.max(j-i+1,maxLen);
                    j++;
                    // can also do k++; instead of above 2 lines, but in that case, loop will run again for same value of j
                    // and seqOfZeroesInSequence.add(j); will happen 2 times.
                    // We can also prevent that by writing seqOfZeroesInSequence.add(j); inside if(k>0){ } condition.
                }
            }
        }
        return maxLen;
    }
}



    // Approach 3: Sliding window + last seen concept (but here for last seen, we can't keep 1 index variable. We need to keep a Queue of all the zeroes found till now, to put i after first zero each time we have new 0 but also k=0)






    // Approach 1: brute-force
    // try to create and accept/reject if meet/not meet requirement for all subarrays




    // Approach 2: Sliding window + Wait until i removes 0 from left and k increases (Wait until valid seq formed from left i

    // public int longestOnes(int[] nums, int k) {
    //     int i=0;
    //     int j=0;
    //     int maxLen=0;

    //     while(j<nums.length){
    //         if(nums[j]==1){
    //             maxLen=Math.max(j-i+1,maxLen);
    //             j++;
    //         }
    //         else{
    //             if(k>0){
    //                 k--;
    //                 maxLen=Math.max(j-i+1,maxLen);
    //                 j++;
    //             }
    //             else{
    //                 if(nums[i]==0){
    //                     k++;
    //                 }
    //                 i++;
    //                 maxLen=Math.max(j-i+1,maxLen);
    //             }
    //         }
    //     }
    //     return maxLen;
    // }

    // we can more reduce the structure of above as: do not repeat yourself, but above is for understanding

    // public int longestOnes(int[] nums, int k) {
    //     int i=0;
    //     int j=0;
    //     int maxLen=0;

    //     while(j<nums.length){
    //         if(nums[j]==0){
    //             if(k>0){
    //                 k--;
    //             }
    //             else{
    //                 if(nums[i]==0){
    //                     k++;
    //                 }
    //                 i++;
    //                 maxLen=Math.max(j-i+1,maxLen);
    //                 continue;
    //             }
    //         }
    //         maxLen=Math.max(j-i+1,maxLen);
    //         j++;
    //     }
    //     return maxLen;
    // }

    