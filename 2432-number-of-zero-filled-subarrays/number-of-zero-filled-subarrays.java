class Solution {
    public long zeroFilledSubarray(int[] arr) {
        if(arr.length==0) return 0;
        int i=0, j=0;
        long ans = 0;
        while(i<arr.length){
            while(j<arr.length && arr[j]!=0) j++;
            i=j;
            while(j<arr.length && arr[j]==0) j++;
            //num of 0 = j-i
            ans+=sumFromNto1(j-i);
            i=j;
        }
        return ans;
    }
    long sumFromNto1(int n){
        long sum = 0;
        while(n>0){
            sum+=n;
            n--;
        }
        return sum;
    }
}
