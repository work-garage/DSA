class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int maxLen = 0;
        int len = 0;
        int i=0;
        for(int j=0; j<s.length(); j++){
            if(!hm.containsKey(s.charAt(j))){
                hm.put(s.charAt(j),1);    //compx?
                len++;
                maxLen = Math.max(maxLen,len);
            }
            else{
                while(s.charAt(i)!=s.charAt(j) && i<j){
                    hm.remove(s.charAt(i));
                    i++;
                    len--;
                }
                i+=1;        //duplicate index next is given to i
            }
        }
        return maxLen;
    }
}