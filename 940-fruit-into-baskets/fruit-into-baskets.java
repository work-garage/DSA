class Solution {

    // Approach 3: Sliding Window + Optimization: do notcheck for cases having window size below maxLen got till now (do not shrink below maxLen window) as those less length cases have no meaning to maxLen answer
    
    public int totalFruit(int[] fruits) {

        int l = 0, r = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> mp = new HashMap<>(); // frequency map

        while (r < fruits.length) {
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0) + 1);                   // extend window to the right

            if (mp.size() > 2) {                                // if more than 2 distinct numbers, shrink from left (as in the original)
                int leftVal = fruits[l];
                mp.put(leftVal, mp.get(leftVal) - 1);
                if (mp.get(leftVal) == 0) {
                    mp.remove(leftVal);
                }
                l++;
            }

            if (mp.size() <= 2) {                                                   // update answer (window now has <= k distinct)
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }

        return maxLen;

    }

}



    // O(2N)
    // Approach 2: Sliding Window + use internal while loop to move i to make sequence valid
    // public int totalFruit(int[] fruits) {
    //     HashMap<Integer,Integer> hm = new HashMap<>();     //as 2 types of fruits only, so space: O(1) and can make only 

    //     int i = 0, j = 0, maxFruit = 0;
    //     while(j<fruits.length){

    //         if(hm.containsKey(fruits[j])){            //this structure can be reduced by: do not repeat yourself
    //             hm.put(fruits[j],hm.get(fruits[j])+1);
    //             maxFruit=Math.max(j-i+1,maxFruit);
    //             j++;
    //         }
    //         else{
    //             if(hm.size()<2){
    //                 hm.put(fruits[j],1);
    //                 maxFruit=Math.max(j-i+1,maxFruit);
    //                 j++;
    //             }
    //             else{   // size 2 or more
    //                 while(hm.size()>=2){      //Can make it more good by adding new elem, and checking hm.size()>2
    //                     hm.put(fruits[i],hm.get(fruits[i])-1);
    //                     if(hm.get(fruits[i])<=0) hm.remove(fruits[i]);
    //                     i++;
    //                     // maxFruit=Math.max(j-i+1,maxFruit);    // need not of it as shrinking
    //                 }
    //             }
    //         }
    //     }
    //     return maxFruit;
    // }






// O(N^2)
// Approach 1: brute force to generate all subarrays and continue acception/rejecting according to validity.
               // using Set(HashSet) or HashMap


// import java.util.HashSet;
// import java.util.Set;

// class Solution {
//     public int totalFruit(int[] fruits) {

//         int n = fruits.length;
//         int maxLen = 0;

//         // generate all subarrays
//         for (int i = 0; i < n; i++) {

//             Set<Integer> set = new HashSet<>();

//             for (int j = i; j < n; j++) {

//                 // add fruit into basket
//                 set.add(fruits[j]);

//                 // check validity
//                 if (set.size() <= 2) {
//                     maxLen = Math.max(maxLen, j - i + 1);
//                 } else {
//                     // more than 2 fruit types → invalid
//                     break;
//                 }
//             }
//         }

//         return maxLen;
//     }
// }


// OR using HashMap

// class Solution {
//     public int totalFruit(int[] fruits) {

//         int n = fruits.length;
//         int maxLen = 0;

//         // generate all subarrays
//         for (int i = 0; i < n; i++) {

//             // store frequency of fruits
//             HashMap<Integer, Integer> map = new HashMap<>();

//             for (int j = i; j < n; j++) {

//                 // include current fruit
//                 map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

//                 // check validity
//                 if (map.size() <= 2) {
//                     maxLen = Math.max(maxLen, j - i + 1);
//                 } else {
//                     // invalid → stop this subarray
//                     break;
//                 }
//             }
//         }

//         return maxLen;
//     }
// }
