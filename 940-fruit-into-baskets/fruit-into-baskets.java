class Solution {

    // O(2N)
    // Approach 2: Sliding Window + use internal while loop to move i to make sequence valid
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        int i = 0, j = 0, maxFruit = 0;
        while(j<fruits.length){

            if(hm.containsKey(fruits[j])){
                hm.put(fruits[j],hm.get(fruits[j])+1);
                maxFruit=Math.max(j-i+1,maxFruit);
                j++;
            }
            else{
                if(hm.size()<2){
                    hm.put(fruits[j],1);
                    maxFruit=Math.max(j-i+1,maxFruit);
                    j++;
                }
                else{   // size 2 or more
                    while(hm.size()>=2){
                        hm.put(fruits[i],hm.get(fruits[i])-1);
                        if(hm.get(fruits[i])<=0) hm.remove(fruits[i]);
                        i++;
                        // maxFruit=Math.max(j-i+1,maxFruit);    // need not of it as shrinking
                    }
                }
            }
        }
        return maxFruit;
    }
}

// O(N^2)
// Approach 1: brute force to generate all subarrays and continue acception/rejecting according to validity.