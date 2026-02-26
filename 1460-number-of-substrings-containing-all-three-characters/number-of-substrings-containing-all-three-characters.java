class Solution {
    //Approach 2: Sliding Window
    public int numberOfSubstrings(String s) {
        int cnt=0,i=0,j=0;
        HashMap<Character,Integer> hm = new HashMap<>();  //as only 3 characters a,b,c So, space is O(1)
        while(j<s.length()){

            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j),0)+1);

            while(isValid(hm)){        //add all substring count which contains current valid substring
                cnt+=s.length()-j;
                hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0)-1);
                if(hm.get(s.charAt(i))<=0) hm.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        return cnt;
    }

    //check if all character exist, all are >=1 in count
    boolean isValid(HashMap<Character,Integer> hm){       //time: O(3) = O(1)
        if(hm.size()<3) return false;            // are all a,b,c present in hashmap
        for (Integer value : hm.values()) {    // do all are >=1 in count
            if(value<1) return false;
        }
        return true;
    }
}