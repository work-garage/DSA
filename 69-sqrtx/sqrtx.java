class Solution {
    // Approach: Optimized: Binary Search
    public int mySqrt(int x) {
        long s=0,e=x,ans=0;

        while(s<=e){
            long mid = s+(e-s)/2;

            if(mid*mid<=x){             // if got a value, go for if there is more correct answer
                ans=mid;
                s=mid+1;
            }
            else if(mid*mid>x){
                e=mid-1;
            }
        }
        return (int) ans;
    }
}

    // Approach: brute force: linear search
    // but if we take int, it will give integer overflow, so used long

    // public int mySqrt(int x) {
    //     long ans=0;
    //     for(long i=0; i<=x; i++){
    //         if(i*i<=x) ans=i;
    //         else break;
    //     }
    //     return (int) ans;
    // }