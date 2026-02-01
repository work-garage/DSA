class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(hm.containsKey(s.charAt(i))){
                if(!(hm.get(s.charAt(i))).equals(t.charAt(i))) return false;
            }
            else{
                if(hm.containsValue(t.charAt(i))) return false;
                hm.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}

// Below is optimised approach as time: O(N)
// IMP: my HashMap approach is O(N*M) as containsValue takes O(M) and is inside a loop. So, runs N times
//So, we can also make Hashmap approach otimize by creating another array/HashMap and not using containsValue().
//ContainsKey only takes O(1)


// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         if(s.length()!=t.length())  return false;
//         int[] sarr  = new int[256];
//         int[] tarr = new int[256];
//         for(int i =0;i<s.length();i++){
//             char ch1 = s.charAt(i);
//             char ch2 = t.charAt(i);
//             if(sarr[ch1]==0 && tarr[ch2]==0){
//                 sarr[ch1] = ch2;
//                 tarr[ch2] = ch1;

//             }
//             else if(sarr[ch1]!=ch2 || tarr[ch2]!=ch1){
//                 return false;
//             }

//         }
//         return true;
//     }
// }
