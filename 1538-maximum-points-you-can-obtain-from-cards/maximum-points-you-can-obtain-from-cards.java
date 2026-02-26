class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxSum=0,i=k-1,j=cardPoints.length-1;
        for(int l=0; l<=i; l++){
            maxSum+=cardPoints[l];
        }

        int sum = maxSum;

        while(i>=0){

            sum-=cardPoints[i];
            i--;
            sum+=cardPoints[j];
            j--;
            maxSum=Math.max(maxSum, sum);
        }
        return maxSum;
    }
}