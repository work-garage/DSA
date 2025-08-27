class Solution {
    public boolean canJump(int[] arr) {
        int j = arr.length-1;
        for(int i=arr.length-2; i>=0; i--){
            if(j-i<=arr[i]){
                j=i;
            }
        }
        if(j==0){
            return true;
        }
        return false;
    }
}