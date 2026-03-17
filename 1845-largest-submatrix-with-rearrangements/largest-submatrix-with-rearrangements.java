class Solution {
    
    // Optimized: sort heights per row (O(m · n log n))
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            // update heights for row i
            for (int j = 0; j < n; j++) {
                heights[j] = (matrix[i][j] == 1) ? heights[j] + 1 : 0;
            }

            // sort copy of heights
            int[] arr = heights.clone();
            Arrays.sort(arr); // ascending

            // iterate from largest to smallest: arr[n-1], arr[n-2], ...
            for (int k = 0; k < n; k++) {
                int h = arr[n - 1 - k];
                if (h == 0) break; // no larger area possible beyond this
                int width = k + 1;
                maxArea = Math.max(maxArea, h * width);
            }
        }

        return maxArea;
    }
}



// class Solution {

//     // Brute Force(using greedy and sorting)

//     // Approach: Steps:
//     // Step 1: Treat each row as the bottom of a rectangle
//     // Step 2: For each column, compute the number of consecutive 1s ending at the current row. (inplace without any extra space)
//     // • if matrix[i][j] == 0, height becomes 0
//     // • if matrix[i][j] == 1, height becomes matrix[i-1][j] + 1
//     // Step 3: Since columns can be rearranged, sort the heights
//     // Step 4: Try every possible width
//     // Step 5: Take maximum over all rows


//     public int largestSubmatrix(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int ans = 0;

//         // Build heights in-place
//         for (int i = 1; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (matrix[i][j] == 1) {
//                     matrix[i][j] += matrix[i - 1][j];
//                 }
//             }
//         }

//         for (int i = 0; i < m; i++) {
//             Integer[] row = new Integer[n];
//             for (int j = 0; j < n; j++) {
//                 row[j] = matrix[i][j];
//             }

//             Arrays.sort(row, Collections.reverseOrder());

//             for (int width = 1; width <= n; width++) {
//                 int h = row[width - 1];
//                 ans = Math.max(ans, h * width);
//             }
//         }

//         return ans;
//     }
// }