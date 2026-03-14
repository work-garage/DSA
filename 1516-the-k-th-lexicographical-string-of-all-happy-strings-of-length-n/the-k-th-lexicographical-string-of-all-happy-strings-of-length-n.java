// POTD
class Solution {


    //////////////////////////// Optimised Approach 1: Backtracking




    // class fields keep k and n so recursion can update k simply
    private int n;
    private int k;
    private final char[] letters = { 'a', 'b', 'c' }; // lexicographic order

    public String getHappyString(int n, int k) {
        this.n = n;
        this.k = k;

        // total = 3 * 2^(n-1). For constraints n >= 1 this fits in int (n <= 10).
        int total = 3 * (1 << Math.max(0, n - 1));
        if (k > total) return ""; // not enough strings

        StringBuilder sb = new StringBuilder();
        String result = dfs(0, '\0', sb);
        return result == null ? "" : result;
    }

    // returns the found string when done, or null if not found in this branch
    private String dfs(int pos, char prev, StringBuilder sb) {
        if (pos == n) {
            // built length n => this is the k-th string
            return sb.toString();
        }

        // number of positions remaining after choosing one character here:
        int remaining = n - pos - 1;
        // block size = 2^remaining (each further position has 2 choices)
        // remaining >= 0 here because pos < n
        int blockSize = 1 << remaining;

        for (int i = 0; i < 3; i++) {
            char c = letters[i];
            if (c == prev) continue; // cannot repeat adjacent

            if (k > blockSize) {
                // skip whole subtree starting with this char
                k -= blockSize;
                continue;
            }

            // the desired string is inside this subtree — choose c and go deeper
            sb.append(c);
            String found = dfs(pos + 1, c, sb);
            if (found != null) return found; // bubble up result
            // backtrack (shouldn't be needed often because we only descend when k <= blockSize)
            sb.setLength(sb.length() - 1);
        }

        // if we reach here, nothing matched (shouldn't happen when initial k was valid)
        return null;
    }
}




    //////////////////////////// Optimised Approach 2

    // public String getHappyString(int n, int k) {
    //     // total happy strings
    //     int total = 3 * (1 << Math.max(0, n - 1)); // safe for n >= 1
    //     if (k > total) return "";

    //     StringBuilder sb = new StringBuilder();
    //     char[] letters = new char[]{'a','b','c'};
    //     char prev = '\0';
    //     int remaining = n; // positions to fill

    //     while (remaining > 0) {
    //         remaining--; // we'll pick current char, then remaining positions after it = remaining
    //         int blockSize = 1 << Math.max(0, remaining); // 2^remaining
    //         boolean chosen = false;
    //         for (char c : letters) {
    //             if (c == prev) continue;
    //             if (k > blockSize) {
    //                 k -= blockSize; // skip this whole block
    //             } else {
    //                 // pick c
    //                 sb.append(c);
    //                 prev = c;
    //                 chosen = true;
    //                 break;
    //             }
    //         }
    //         if (!chosen) {
    //             // should not happen because we checked k <= total
    //             return "";
    //         }
    //     }

    //     return sb.toString();
    // }





    //////////////////////////// Brute force approach

    // public String getHappyString(int n, int k) {
    //     StringBuilder sb = new StringBuilder();
    //     ResultHolder res = new ResultHolder(k);
    //     char[] letters = new char[]{'a','b','c'};
    //     dfs(0, n, sb, '\0', letters, res);
    //     return res.answer == null ? "" : res.answer;
    // }

    // // holder to allow passing by reference
    // class ResultHolder {
    //     int k;
    //     String answer;
    //     ResultHolder(int k) { this.k = k; this.answer = null; }
    // }

    // void dfs(int pos, int n, StringBuilder sb, char prev, char[] letters, ResultHolder res) {
    //     if (res.answer != null) return; // early stop if found
    //     if (pos == n) {
    //         res.k--;
    //         if (res.k == 0) res.answer = sb.toString();
    //         return;
    //     }
    //     for (char c : letters) {
    //         if (c == prev) continue;
    //         sb.append(c);
    //         dfs(pos + 1, n, sb, c, letters, res);
    //         sb.deleteCharAt(sb.length() - 1);
    //         if (res.answer != null) return;
    //     }
    // }