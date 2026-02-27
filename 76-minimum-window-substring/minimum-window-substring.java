class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        
        for(int l=0; l<t.length(); l++){
            hm1.put(t.charAt(l), hm1.getOrDefault(t.charAt(l),0)+1);
        }

        int i=0,j=0,minI=0,minJ=Integer.MAX_VALUE;
        
        while(j<s.length()){

            hm2.put(s.charAt(j), hm2.getOrDefault(s.charAt(j),0)+1);

            while(isValid(hm1,hm2)){
                if(j-i < minJ-minI){
                    minJ=j;
                    minI=i;
                }
                
                hm2.put(s.charAt(i), hm2.get(s.charAt(i))-1);
                if(hm2.get(s.charAt(i))<=0) hm2.remove(s.charAt(i));
                i++;
            }

            j++;
        }

        if(minJ== Integer.MAX_VALUE) return "";
        return s.substring(minI, minJ+1);
        
    }

    boolean isValid(HashMap<Character,Integer> hm1, HashMap<Character,Integer> hm2){
        for (char ch : hm1.keySet()) {
        if (hm2.getOrDefault(ch, 0) < hm1.get(ch))
            return false;
        }
        return true;
    }
}