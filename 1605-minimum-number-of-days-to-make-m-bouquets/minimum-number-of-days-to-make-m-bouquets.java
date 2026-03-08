class Solution {
    public int minDays(int[] bloomDay, int m, int k) { // Time: O(N*logD)
        if( bloomDay.length < m*k ) return -1;
                                                                // D is number of unique bloom days in array
                                                                // Or D can be range of bloom days (maxDay - minDay)

                                                                //Binary search takes O(log2 D)
        int ans = -1;
        int s = Integer.MAX_VALUE;
        int e = Integer.MIN_VALUE;
        for(int num : bloomDay){
            s = Math.min(s, num);
            e = Math.max(e, num);
        }
        // Here we take our answer range as: range of bloom days (maxDay - minDay)
        // We can also take: array of unique bloom days as range of possible answers

        while(s<=e){
            int mid = s+(e-s)/2;
            if(isBouquetPossible(mid,m,k,bloomDay)){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;        
    }

    public boolean isBouquetPossible(int day,int m,int k,int[] bloomDay){
                                                                // needs O(N) to check, is bouquet Possible
                                                                // N is length of bloomDay Array
        int flowers = 0;
        int bouquets = 0;

        for (int currBloom : bloomDay) {
            if (currBloom <= day) {
                flowers++;
                if (flowers >= k) {
                    bouquets++;
                    flowers = 0;
                    if (bouquets >= m) return true;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}
