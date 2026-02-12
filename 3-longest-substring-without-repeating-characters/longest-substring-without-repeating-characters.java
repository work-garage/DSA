class Solution {

    // Approach 2: Sliding window: Move pointer after first occurance

    // time compx: O(N)
    // Way 2: uses LastSeen array or hashmap to: move after first duplicate occurance using LastSeen index
    //        More Optimized:  time compx: O(N) ,space: O(1) as int[256] is static size array or hashmap wont go greater than 256 character, so its max is also independent of N

        public int lengthOfLongestSubstring(String s) {
            if (s == null) return 0;

            Map<Character, Integer> lastIndex = new HashMap<>();
            int maxLen = 0;
            int i = 0; // window is [i, j]

            for (int j = 0; j < s.length(); j++) {

                if (lastIndex.containsKey(s.charAt(j)) && i <= lastIndex.get(s.charAt(j)) ) {       //very IMP condition i <= lastIndex.get(s.charAt(j)), as it dont consider elements that are in hashmap but before the i index: As moving after first occurance does not remove previous included elements
                    i = lastIndex.get(s.charAt(j)) + 1;  //Move pointer after first occurance
                }

                lastIndex.put(s.charAt(j), j);
                maxLen = Math.max(maxLen, j - i + 1);
            }

            return maxLen;
        }
}



// Approach 1: brute force

// time compx: O(N^2)
// create all subarrays and while creating, check for duplicates using hashset etc, take max frm all valid subarrays







// Approach 2: Sliding window: Move pointer after first duplicate


// time compx: O(2N)
// Way 1: uses present array and extra internal while loop to: move after first duplicate occurance
//        Less Optimized:  time compx: O(2N) extra N is of internal while loop ,space: O(1) as boolean[256] is static size array

    // public int lengthOfLongestSubstring(String s) {
    //     // HashMap<Character,Integer> hm = new HashMap<>();     //could use HashMap, but thats inefficient here
    //     boolean[] present = new boolean[256];          // extended ascii has 256 characters
    //     int maxLen = 0;
    //     int len = 0;                                   // can use j-i+1 instead of len
    //     int i=0;
    //     for(int j=0; j<s.length(); j++){
    //         if(present[s.charAt(j)]==false){
    //             present[s.charAt(j)]=true;           // hm.put(s.charAt(j),1);
    //             len++;
    //             maxLen = Math.max(maxLen,len);
    //         }
    //         else{
    //             while(s.charAt(i)!=s.charAt(j) ){       //can also do:   && i<j
    //                 // hm.remove(s.charAt(i));     //IMP Mistake: do not do hm.put(s.charAt(i), 0 );
    //                                             // as after this, hm.containsKey still return true
    //                 present[s.charAt(i)]=false;
    //                 i++;
    //                 len--;
    //             }
    //             i+=1;        //duplicate index next is given to i
    //         }
    //     }
    //     return maxLen;
    // }










// time compx: O():   ❌But this approach wont work here in O(N) as valid check will take N checks also each time using HashMap, so O(N^2)
                    // This approach is more optimised on other sliding window question, but here its not more optimised

// Approach 3: No need to check by reducing len got till now, just dont take invalid cases in maxLen, where duplicates are present. 
    // Because why check those cases, which are giving less max than before.

    //HERE, Optimization is, do not check for cases which are of less length than current maxLen. So, increase both i and j if not valid to keep len const


    // public int lengthOfLongestSubstring(String s) {
    //     int i=0;
    //     int j=0;
    //     int maxLen = 0;
    //     boolean[] present = new boolean[256];

    //     for(int j; j<s.length(); j++){                           //can also do while(j<s.length)
    
    //             present[s.charAt(j)]=true;
    //             if(valid){
    //                  maxLen = Math.max(maxLen,j-i+1);
    //             }
    //             else{
    //                 present[s.charAt(i)]=false;
    //                 i++;
    //             }
    //             j++;
    //     }
    // }
