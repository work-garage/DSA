class Solution {

    // Optimize level 3: O(N) of same approach 2
    // reduced O(N+N) to O(N) by not checking for subarray cases having less len than max len got till now.
    // by removing so, changed internal while(j-i+1-maxFreq>k) to if(j-i+1-maxFreq>k) to increase both i and j

    public int characterReplacement(String s, int k) {
        int i=0,j=0,maxLen=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int maxFreq=0;

        while(j<s.length()){

            hm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)+1);
            maxFreq = Math.max(maxFreq,hm.get(s.charAt(j)));

            if(j-i+1-maxFreq>k){
                hm.put(s.charAt(i), hm.get(s.charAt(i))-1);
                i++;
            }

            if(j-i+1-maxFreq<=k) maxLen = Math.max(maxLen, j-i+1);
            j++;

        }
        return maxLen;
    } 
}

    // Approach 2: we can replace k times, and want max len.
    //             IMP: thus, we will replace characters which are occuring the least in substring.
    //             and keep that, which has occured most. So, to maximize length.
    //  So, we find max freq character as while loop runs, and except that, we replace all other( count how many to replace).
    //  how many to replace = substring length - max character freq



    // Optimize level 1: O(N+N+26)

    // public int characterReplacement(String s, int k) {
    //     int i=0,j=0,maxLen=0;
    //     HashMap<Character,Integer> hm = new HashMap<>();
    //     int maxFreq=0;

    //     while(j<s.length()){

    //         hm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)+1);
    //         maxFreq = Math.max(maxFreq,hm.get(s.charAt(j)));

    //         while(j-i+1-maxFreq>k){
    //             hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
    //             i++;
    //             for(Integer f: hm.values()){        //find new max among hm
    //                 maxFreq = Math.max(maxFreq,f);
    //             }
    //         }

    //         maxLen = Math.max(maxLen, j-i+1);
    //         j++;

    //     }
    //     return maxLen;
    // }

    
    // Optimize level 2: O(N+N) of same approach 2
    // removed O(26) by not doing: for(Integer f: hm.values()): Optimization: remove for loop, bcz less freq was not contributing to maxLen. if any new elem with more good freq comes, maxFreq will auto get it. no need to do manually with a for loop

    // public int characterReplacement(String s, int k) {
    //     int i=0,j=0,maxLen=0;
    //     HashMap<Character,Integer> hm = new HashMap<>();     
    //     Instead of HM, we can also use: int[] f = new int[26]; and s.charAt(r)-'A' OR int[] f = new int[256];

    //     int maxFreq=0;

    //     while(j<s.length()){

    //         hm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)+1);
    //         maxFreq = Math.max(maxFreq,hm.get(s.charAt(j)));

    //         while(j-i+1-maxFreq>k){
    //             hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
    //             i++;
    //                          // Optimization: remove for loop, bcz less freq was not contributing to maxLen
    //                          // if any new elem with more good freq comes, maxFreq will auto get it
    //                          // no need to do manually with a for loop
    //         }

    //         maxLen = Math.max(maxLen, j-i+1);
    //         j++;

    //     }
    //     return maxLen;
    // }




    // Approach 1: Brute force: O(N^2)