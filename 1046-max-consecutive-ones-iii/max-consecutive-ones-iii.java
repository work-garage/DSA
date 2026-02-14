class Solution {

    //time: O(N): Most optimised: Very IMP approach
    //Approach 4: Optimization: do not check for cases less than maxLen got till now. So increase both i,j to keep length= maxLen till now and not check for non useful cases. Check only for cases > maxLen.

    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int maxLen=0;
        int zero = 0;

        while(j<nums.length){
            if(nums[j]==0){
                zero++;
            }
            if(zero>k){
                if(nums[i]==0){
                    zero--;
                }
                i++;
            }

            if(zero<=k) maxLen = Math.max(j-i+1,maxLen);
            j++;
        }
        return maxLen;
    }
}




    // time: O(N) and space: O(number of 0's), if all 0's then O(N)
    // Approach 3: Sliding window + last seen concept (but here for last seen, we can't keep 1 index variable. We need to keep a Queue of all the zeroes found till now, to put i after first zero each time we have new 0 but also k=0)

    //IMP: but in some questions this approach takes space O(256)=O(1) not O(N) eg Q. Longest Substring Without Repeating Characters, we need not to create a Queue, only character array of 256 is sufficient. So, there this approach is more good

    // public int longestOnes(int[] nums, int k) {
    //     int i=0;
    //     int j=0;
    //     int maxLen=0;
    //     Queue<Integer> seqOfZeroesInSequence = new ArrayDeque<>();

    //     while(j<nums.length){
    //         if(nums[j]==1){
    //             maxLen=Math.max(j-i+1,maxLen);
    //             j++;
    //         }
    //         else{

    //             seqOfZeroesInSequence.add(j);

    //             if(k>0){
    //                 k--;
    //                 maxLen=Math.max(j-i+1,maxLen);
    //                 j++;
    //             }
    //             else{

    //                 i=seqOfZeroesInSequence.peek()+1;
    //                 seqOfZeroesInSequence.remove();

    //                 maxLen=Math.max(j-i+1,maxLen);
    //                 j++;

    //                 //IMP: We can also do k++; instead of above 2 lines, but in that case, loop will run again for same value of j
    //                 // and seqOfZeroesInSequence.add(j); will happen 2 times.
    //                 // We can also prevent that by writing seqOfZeroesInSequence.add(j); inside if(k>0){ } condition.
    //             }
    //         }
    //     }
    //     return maxLen;
    // }






    // O(N^2)
    // Approach 1: brute-force
    // try to create and accept/reject if meet/not meet requirement for all subarrays







    // O(2N)
    // Approach 2: 


    // Way 1: Sliding window + use inner while to move i forward until i crosses 0

    // public int longestOnes(int[] nums, int k) {
    //     int i = 0, maxLen = 0, zeroCount = 0;
    //     for (int j = 0; j < nums.length; j++) {
    //         if (nums[j] == 0) zeroCount++;
    //         while (zeroCount > k) {
    //             if (nums[i] == 0) zeroCount--;
    //             i++;
    //         }
    //         maxLen = Math.max(maxLen, j - i + 1);
    //     }
    // }


    
    //Way 2: Sliding window + Wait until in outer loop and do not increase j, until i removes 0 from left and k increases (Wait until valid seq formed from left i)

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
