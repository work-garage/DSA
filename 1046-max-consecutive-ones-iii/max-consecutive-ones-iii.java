class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int maxLen=0;

        while(j<nums.length){
            if(nums[j]==1){
                maxLen=Math.max(j-i+1,maxLen);
                j++;
            }
            else{
                if(k>0){
                    k--;
                    maxLen=Math.max(j-i+1,maxLen);
                    j++;
                }
                else{
                    if(nums[i]==0){
                        k++;
                    }
                    i++;
                    maxLen=Math.max(j-i+1,maxLen);
                }
            }
        }
        return maxLen;
    }
}