class Solution {


    // O(numberOfUniqueCharacters * N) = O(26*N) = O(N) [numberOfUniqueCharacters can maximum be 26]

    ////////// Approach 3: Instead of trying to do in one pass, try multiple pass with: 1 unique character then 2 unique characters then 3 and so on till number of unique characters in the array.
    // This converts a hard problem into manageable sliding windows.
    
    // 1. Why normal sliding window is not enough?
    // Typical sliding window works when condition depends on:
    // sum,count,distinct elements limit
    // But here condition is tricky:
    // EVERY character frequency ≥ k
    // This is a global constraint, not local.
    // So we use a smart trick.
    // 2. Core Idea (Most Important Part)
    // Instead of directly checking validity…
    // We fix the number of unique characters allowed in the window.
    // Why? Because:
    // A valid substring must have:
    // some number of unique characters
    // AND
    // each of them occurs ≥ k times
    // So we try ALL possibilities:
    // 1 unique character
    // 2 unique characters
    // 3 unique characters
    // ...
    // max unique characters in string

    // If the number of unique character in the sliding window is less than or equal to currUnique, expand the
    // window from the right by adding a character to the end of the window given by windowEnd

    // Otherwise, shrink the window from the left by removing a character from the start of the window given by 
    // windowStart.

    // Keep track of the number of unique characters in the current sliding window having at least k frequency given 
    // by countAtLeastK. Update the result if all the characters in the window have at least k frequency.


    public int longestSubstring(String s, int k) {

        int maxLen=0;

        HashSet<Character> hs = new HashSet<>();    // Counting number of unique characters in array
        for(int l=0; l<s.length(); l++){
            hs.add(s.charAt(l));
        }
        int maxUnique = hs.size();

        for(int toSelectUnique=1; toSelectUnique<=maxUnique; toSelectUnique++){ //toSelectUnique = 1 to maxUnique

            HashMap<Character,Integer> hm = new HashMap<>();
            
            int i=0,j=0;

            while(j<s.length()){        // do normal checking of longest substring with x number of unique characters

                hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j),0)+1);

                while(hm.size()>toSelectUnique){
                    hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0)-1);
                    if(hm.get(s.charAt(i))<=0) hm.remove(s.charAt(i));
                    i++;
                }

                if(isValid(hm,k)) maxLen = Math.max(maxLen, j-i+1);

                j++;
            }

        }
        return maxLen;
    }

    boolean isValid(HashMap<Character,Integer> hm , int k){
        for(Integer n : hm.values()){
            if(n<k) return false;
        }
        return true;
    }
}




/////////////// Approach 1: Brute Force: O(N^2)





/////////////// Approach 2: Divide and Conquer(recursion): O(N^2)


// Divide the problem into subproblems. (Divide Phase).
// Repeatedly solve each subproblem independently and combine the result to solve the original problem. (Conquer Phase).
// We could apply this strategy by recursively splitting the string into substrings and combine the result to find the longest substring that satisfies the given condition. The longest substring for a string starting at index start and ending at index end can be given by,

// longestSustring(start, end) = max(longestSubstring(start, mid), longestSubstring(mid+1, end))
// Finding the split position (mid)

// The string would be split only when we find an invalid character. An invalid character is the one with a frequency of less than k. As we know, the invalid character cannot be part of the result, we split the string at the index where we find the invalid character, recursively check for each split, and combine the result.

// Algorithm

// Build the countMap with the frequency of each character in the string s.
// Find the position for mid index by iterating over the string. The mid index would be the first invalid character in the string.
// Split the string into 2 substrings at the mid index and recursively find the result.
// To make it more efficient, we ignore all the invalid characters after the mid index as well, thereby reducing the number of recursive calls.

// class Solution {
//     public int longestSubstring(String s, int k) {
//         return longestSubstringUtil(s, 0, s.length(), k);
//     }

//     int longestSubstringUtil(String s, int start, int end, int k) {
//         if (end < k) return 0;
//         int[] countMap = new int[26];
//         // update the countMap with the count of each character
//         for (int i = start; i < end; i++)
//             countMap[s.charAt(i) - 'a']++;
//         for (int mid = start; mid < end; mid++) {
//             if (countMap[s.charAt(mid) - 'a'] >= k) continue;
//             int midNext = mid + 1;
//             while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k) midNext++;
//             return Math.max(longestSubstringUtil(s, start, mid, k),
//                     longestSubstringUtil(s, midNext, end, k));
//         }
//         return (end - start);
//     }
// }

// Complexity Analysis

// Time Complexity : O(N^2), where N is the length of string s. Though the algorithm performs better in most cases, the worst case time complexity is still O(N^2).
// In cases where we perform split at every index, the maximum depth of recursive call could be O(N). For each recursive call it takes O(N) time to build the countMap resulting in O(n^2) time complexity.

// Space Complexity: O(N) This is the space used to store the recursive call stack. The maximum depth of recursive call stack would be O(N).


