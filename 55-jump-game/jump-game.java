class Solution {
    public boolean canJump(int[] arr) {
        int maxIdxReach = 0;
        for(int i=0; i<arr.length; i++){
            if(i>maxIdxReach) return false;
            maxIdxReach = Math.max(maxIdxReach,i+arr[i]);
        }
        return true;
    }
}