class Solution {

    //IMP: Best way for checking Bijection(mapping between two sets where each element of the first set (domain) pairs with exactly one unique element of the second set (codomain), and vice versa)
    // Below is optimised approach as time: O(N)

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] lastS = new int[256];
        int[] lastT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (lastS[s.charAt(i)] != lastT[t.charAt(i)])
                return false;
            lastS[s.charAt(i)] = i + 1;
            lastT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}



//HashMap Approaches:


    //Unoptimised: O(N*M)


    // IMP: my HashMap approach is O(N*M) as containsValue takes O(M) and is inside a loop. So, runs N times => O(N^2) in worst
    //So, we can also make Hashmap approach otimize by creating another HashMap/HashSet and not using containsValue().
    //ContainsKey only takes O(1)



    // public boolean isIsomorphic(String s, String t) {
    //     HashMap<Character,Character> hm = new HashMap<>();
    //     for(int i=0; i<s.length(); i++){
    //         if(hm.containsKey(s.charAt(i))){
    //             if(!(hm.get(s.charAt(i))).equals(t.charAt(i))) return false;
    //         }
    //         else{
    //             if(hm.containsValue(t.charAt(i))) return false;
    //             hm.put(s.charAt(i),t.charAt(i));
    //         }
    //     }
    //     return true;
    // }




//Optimizing the above single HashMap approach:


//✅ Version 1: HashMap + HashSet

//Slightly fewer hash operations

//Less memory than 2 HashMaps

//Faster in practice by a small constant factor

//Most robust & clean (engineering + interviews)

//✅ Version 2: Two HashMaps

//IMP:  Explicit bijection

//Easier to reason about correctness

//Harder to break accidentally

//Preferred in interviews



    //More Optimised: O(N)
    //But takes more space


    //Version 1:


    // public boolean isIsomorphic(String s, String t) {
    //     HashMap<Character,Character> hm1 = new HashMap<>();
    //     HashSet<Character> hm2 = new HashSet<>();      
                //HashSet internally backed by  HashMap<E, Object>      
                //Each element is stored as a key in a HashMap        
                //The value is a dummy constant (PRESENT)

    //     for(int i=0; i<s.length(); i++){
    //         if(hm1.containsKey(s.charAt(i))){
    //             if(!(hm1.get(s.charAt(i))).equals(t.charAt(i))) return false;
    //         }
    //         else{
    //             if(hm2.contains(t.charAt(i))) return false;
    //             hm1.put(s.charAt(i),t.charAt(i));
    //             hm2.add(t.charAt(i));
    //         }
    //     }
    //     return true;
    // }



    //More Optimised: O(N)
    //But takes more space



    //Version 2:

    // public boolean isIsomorphic(String s, String t) {
    // if (s.length() != t.length()) return false;
    // HashMap<Character, Character> mapST = new HashMap<>();
    // HashMap<Character, Character> mapTS = new HashMap<>();

    //     for (int i = 0; i < s.length(); i++) {
    //         char cs = s.charAt(i);
    //         char ct = t.charAt(i);

    //         // forward mapping check
    //         if (mapST.containsKey(cs)) {
    //             if (mapST.get(cs) != ct) return false; // unbox comparison
    //         } else {
    //             mapST.put(cs, ct);
    //         }

    //         // reverse mapping check
    //         if (mapTS.containsKey(ct)) {
    //             if (mapTS.get(ct) != cs) return false;
    //         } else {
    //             mapTS.put(ct, cs);
    //         }
    //     }
    //     return true;
    // }




    //VS




// ArrayList Approach:


    //It is also unoptimised as: uses func like indexOf() inside a loop.
    //So worst case: O(N*M)


    // public boolean isIsomorphic(String s, String t) {
    //     ArrayList<Character> a1 = new ArrayList<>();
    //     ArrayList<Character> a2 = new ArrayList<>();
    //     for(int i=0; i<s.length(); i++){
    //         if(a1.contains(s.charAt(i))){
    //             if(!(a2.get(a1.indexOf(s.charAt(i)))).equals(t.charAt(i))) return false;
    //         }
    //         else{
    //             if(a2.contains(t.charAt(i))) return false;

    //             a1.add(s.charAt(i));
    //             a2.add(t.charAt(i));
    //         }
    //     }
    //     return true;

