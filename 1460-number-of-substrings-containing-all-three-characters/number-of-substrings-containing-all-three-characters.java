class Solution {

    // O(2N)
    /////////////// Approach 3(new): Sliding Window Approach: Use when, we got valid, and all other containg valid are also valid
    // As here, if we get a valid string, we add count of all right side strings containing selected window as well by: count+= length-j
    // then increase i, if still valid, update count (repeat same until valid)
    // then increase j (do same in loop)

    public int numberOfSubstrings(String s) {
        int cnt=0,i=0,j=0;
        HashMap<Character,Integer> hm = new HashMap<>();  // as only 3 characters a,b,c So, space is O(1)
                                                          // can use instead:     int[] freq = new int[3];
                                                          // increase char count  freq[curr - 'a']++;
        while(j<s.length()){

            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j),0)+1);

            while(isValid(hm)){        //add all substring count which contains current valid substring
                cnt+=s.length()-j;
                hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0)-1);
                if(hm.get(s.charAt(i))<=0) hm.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        return cnt;
    }

    //check if all character exist, all are >=1 in count
    boolean isValid(HashMap<Character,Integer> hm){       //time: O(3) = O(1)
        if(hm.size()<3) return false;            // are all a,b,c present in hashmap
        for (Integer value : hm.values()) {    // do all are >=1 in count
            if(value<1) return false;
        }
        return true;          // if use array: return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}






    // O(2N)
    /////////////// Approach 4: Last Position Tracking

    // Instead of thinking in terms of a sliding window, we can take a different perspective: for each position in the string, how many valid substrings end at this position? The key observation is that a substring is valid if it contains at least one occurrence of each required character (a, b, and c). However, instead of tracking exact counts, we only care about where the most recent occurrence of each character is.

    // This reveals an important pattern. At every position, we determine the leftmost occurrence among the last seen positions of 'a', 'b', and 'c'. The number of valid substrings ending at this position is simply the number of possible starting points, which range from the beginning of the string up to this leftmost position.


    ///// InShort: if Valid, we add count of all left side strings containing valid substring (valid substring is from min index among all a,b,c in lastPos to j)


    // public int numberOfSubstrings(String s) {
    //     int len = s.length();
    //     // Track last position of a, b, c
    //     int[] lastPos = { -1, -1, -1 };
    //     int total = 0;

    //     for (int pos = 0; pos < len; pos++) {
    //         // Update last position of current character
    //         lastPos[s.charAt(pos) - 'a'] = pos;

    //         // Add count of valid substrings ending at current position
    //         // If any character is missing, min will be -1
    //         // Else min gives leftmost required character position
    //         total += 1 + Math.min(lastPos[0], Math.min(lastPos[1], lastPos[2]));
    //     }

    //     return total;
    // }




    /////////////// Approach 1: Brute force O(N^2)

    /////////////// Approach 2: All sliding window approach learnt till now, won't work here