class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int s = 1;
        int e = 0;
        
        for (int n : nums) e = Math.max(e, n);
        
        int ans = e;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            
            if (isValid(nums, threshold, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
    
    public boolean isValid(int[] nums, int threshold, int mid) {
        int sum = 0;
        
        for (int n : nums) {
            int ans = n / mid;      // integer division

            if (n % mid != 0) ans++;  // manual ceiling: works for n>mid or even if n<mid
            sum += ans;               // OR for ceiling, we can also do: sum += (n + mid - 1) / mid; OR Math.ceil()
            
            if (sum > threshold) return false; // early stop
        }
        return sum <= threshold;
    }
}