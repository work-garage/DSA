class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,maxLen=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int maxFreq=0;

        while(j<s.length()){

            hm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)+1);
            maxFreq = Math.max(maxFreq,hm.get(s.charAt(j)));

            while(j-i+1-maxFreq>k){
                hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                i++;
                for(Integer f: hm.values()){        //find new max among hm
                    maxFreq = Math.max(maxFreq,f);
                }
            }

            maxLen = Math.max(maxLen, j-i+1);
            j++;

        }
        return maxLen;
    }
}
