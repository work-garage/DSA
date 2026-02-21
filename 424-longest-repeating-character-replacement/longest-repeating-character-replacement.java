class Solution {
    // O(N)
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

    // O(N+N+26)

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
    //                 maxFreq = Math.max(maxFreq,f);           //makes n^2 or what?
    //             }
    //         }

    //         maxLen = Math.max(maxLen, j-i+1);
    //         j++;

    //     }
    //     return maxLen;
    // }

    
    // O(N+N)

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
    //                          // Optimization: remove for loop, bcz less freq was not contributing to maxLen
    //                          // if any new elem with more good freq comes, maxFreq will auto get it
    //                          // no need to do manually with a for loop
    //         }

    //         maxLen = Math.max(maxLen, j-i+1);
    //         j++;

    //     }
    //     return maxLen;
    // }
