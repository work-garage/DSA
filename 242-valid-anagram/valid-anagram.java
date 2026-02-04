class Solution {
    public boolean isAnagram(String s, String t) {

        //Frequency based approach using character ASCII arrays

        if(s.length()!=t.length()) return false;

        int[] a = new int[128];
        
        for(int i=0; i<s.length(); i++){
            
            a[s.charAt(i)]++;

            a[t.charAt(i)]--;
            
        }

        //OR can only do: because only 26 alphabets are needed, i took 128 for all ascii but not need of that
        // int[] freq=new int[26];
        // for(int i=0;i<s.length();i++){
        //     freq[s.charAt(i)-97]++;
        //     freq[t.charAt(i)-97]--;
        // }

        for(int val: a){
            if(val!=0) return false;
        }

        return true;
        
    }

    //Frequency based approach using Hashmap

    // public boolean isAnagram(String s, String t) {
    //     HashMap<Character,Integer> hm = new HashMap<>();

        // if(s.length()!=t.length()) return false;
        
        // for(int i=0; i<s.length(); i++){
        //     if(hm.containsKey(s.charAt(i))) hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
        //     else hm.put(s.charAt(i), 1);

        //     if(hm.containsKey(t.charAt(i))) hm.put(t.charAt(i), hm.get(t.charAt(i))-1);
        //     else hm.put(t.charAt(i), -1);
        // }

        // for(Integer val: hm.values()){
        //     if(val!=0) return false;
        // }

        // return true;
    // }
}