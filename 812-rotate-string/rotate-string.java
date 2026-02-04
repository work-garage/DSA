class Solution {
    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) return false;

        if(s.equals(goal)) return true;

        for(int i=1; i<s.length(); i++){

            boolean f = true;

            String str = new String();
            str = s.substring(i,s.length())+s.substring(0,i);
            for(int j=0; j<s.length(); j++){
                if(str.charAt(j)!=goal.charAt(j)){
                    f = false;
                    break;
                }
            }

            if(f){
                return true;
            }

        }
        return false;
    }
}