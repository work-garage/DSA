class Solution {
    public int maximum69Number (int n) {
        String nStr = Integer.toString(n);
        StringBuilder s = new StringBuilder(nStr);
        for(int i = 0; i<nStr.length(); i++){
            if(s.charAt(i)=='6'){
                s.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(s.toString());
    }
}