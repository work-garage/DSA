class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        int startWith0 = 0;  // mismatches if pattern starts with '0'
        int startWith1 = 0;  // mismatches if pattern starts with '1'
        
        for(int i = 0; i < n; i++){
            char expected0;
            char expected1;
            
            if(i % 2 == 0){
                expected0 = '0';
                expected1 = '1';
            } else {
                expected0 = '1';
                expected1 = '0';
            }
            
            if(s.charAt(i) != expected0) startWith0++;
            if(s.charAt(i) != expected1) startWith1++;
        }
        
        return Math.min(startWith0, startWith1);
    }
}