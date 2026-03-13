// my Daily Question

class Solution {

    // Optimised: Binary Search

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;
        long H = mountainHeight;

        int maxW = Arrays.stream(workerTimes).max().orElse(1);
        long high = (long) maxW * (H * (H + 1L) / 2L);
        long low = 0L;

        while (low < high) {
            long mid = low + (high - low) / 2L;
            if (feasible(mid, H, workerTimes)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean feasible(long T, long H, int[] workerTimes) {
        long total = 0L;
        for (int w : workerTimes) {
            long base = w;
            if (T < base) continue;
            long k = T / base;

            double val = 1.0 + 8.0 * (double) k;
            long x = (long) ((Math.sqrt(val) - 1.0) / 2.0);

            while ((x + 1) * (x + 2) / 2 <= k) x++;
            while (x * (x + 1) / 2 > k) x--;

            total += x;
            if (total >= H) return true;
        }
        return total >= H;
    }
}

    // Brute Force: gives tle

    // public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
    //     int n = workerTimes.length;
    //     int[] assigned = new int[n];
    //     long[] best = new long[] { Long.MAX_VALUE };

    //     dfs(0, mountainHeight, workerTimes, assigned, 0L, best);
    //     return best[0];
    // }

    // public long workerTimeForUnits(long baseTime, int units) {
    //     long tri = (long) units * (units + 1L) / 2L;
    //     return baseTime * tri;
    // }

    // public void dfs(int idx, int remaining, int[] workerTimes, int[] assigned, long currentMaxTime, long[] best) {
    //     int n = workerTimes.length;

    //     if (currentMaxTime >= best[0]) return;

    //     if (idx == n) {
    //         if (remaining == 0) {
    //             best[0] = Math.min(best[0], currentMaxTime);
    //         }
    //         return;
    //     }

    //     if (idx == n - 1) {
    //         assigned[idx] = remaining;
    //         long t = workerTimeForUnits(workerTimes[idx], assigned[idx]);
    //         long newMax = Math.max(currentMaxTime, t);
    //         if (newMax < best[0]) {
    //             if (remaining >= 0) best[0] = Math.min(best[0], newMax);
    //         }
    //         assigned[idx] = 0;
    //         return;
    //     }

    //     for (int x = 0; x <= remaining; x++) {
    //         assigned[idx] = x;
    //         long t = workerTimeForUnits(workerTimes[idx], x);
    //         long newMax = Math.max(currentMaxTime, t);
    //         if (newMax < best[0]) {
    //             dfs(idx + 1, remaining - x, workerTimes, assigned, newMax, best);
    //         }
    //         assigned[idx] = 0;
    //     }
    // }