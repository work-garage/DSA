class Solution {

    ///// Binary Search on Answer Space

    ///// Approach 2: Binary Search check in range of [1 to max_elem_of_(Arr)] for array elements:
                      // O( log( max(Arr) ) * N)

    public int minEatingSpeed(int[] piles, int h) {

        long max=piles[0], ans=Integer.MAX_VALUE;
        for(long a:piles) max=Math.max(max,a);                       // finding max elem

        long s = 1;  
        long e = max;

        while (s <= e) {                                            // check in range [1 to max_elem_of_(Arr)]
                                                                    // O(log( max ))
            long mid = s + (e - s) / 2;
            if ( isSpeedSufficient( mid, h, piles) ) {
                ans = mid;     
                e = mid - 1;
            } else {
                s = mid + 1; 
            }
        }

        return (int) ans;
    }

    public boolean isSpeedSufficient(long i, int h, int[] piles){
        long hrsTakenWithRate_i=0;
        for(long pile: piles){                                       // O( N )
            hrsTakenWithRate_i+= pile/i;
            if( pile % i !=0 ) hrsTakenWithRate_i++; 
        }
        return hrsTakenWithRate_i <= h;
    }
}


    ///// Approach 1: linearly check for 1 to max_elem_of_(Arr) for each array element: O( max*N )

    // public int minEatingSpeed(int[] piles, int h) {
        
    //     int max=piles[0], ans=Integer.MAX_VALUE;
    //     for(int a:piles) max=Math.max(max,a);                       // finding max elem

    //     for(int i=1; i<=max; i++){                                  // check from 1 to max_elem_of_(Arr)
    //                                                                 // O( max )
    //         if(isSpeedSufficient(i,h,piles)) ans = Math.min(ans,i);
    //     }

    //     return ans;
    // }

    // public boolean isSpeedSufficient(int i, int h, int[] piles){
    //     int hrsTakenWithRate_i=0;
    //     for(int pile: piles){                                       // O( N )
    //         hrsTakenWithRate_i+= pile/i;
    //         if( pile % i !=0 ) hrsTakenWithRate_i++; 
    //     }
    //     return hrsTakenWithRate_i <= h;
    // }
