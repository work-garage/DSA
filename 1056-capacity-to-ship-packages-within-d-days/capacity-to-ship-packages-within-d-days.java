class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int s = 0, e = 0;              // Answer lie in range of: max weight to total weight
                                       // Binary Search on answers
        for (int w: weights) {         // s: max of conveyer belt weight        e: total weight of conveyer belt
            s = Math.max(s, w);
            e += w;
        }
        while (s < e) {
            int mid = (s + e) / 2, need = 1, cur = 0;
            for (int w: weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (need > D) s = mid + 1;
            else e = mid;
        }
        return s;
    }
}