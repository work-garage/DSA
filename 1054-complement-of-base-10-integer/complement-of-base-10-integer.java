// Question
class Solution {

    // Optimize Approach: Bit Manipulation
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int mask = 0;
        int temp = n;
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>>= 1;  // unsigned shift or >> works too here since temp>=0
        }
        return n ^ mask;
    }
}

    // Bruteforce
    
    // public int bitwiseComplement(int n) {
    //     if (n == 0) return 1;
    //     String b = Integer.toBinaryString(n); // "101"
    //     StringBuilder sb = new StringBuilder();
    //     for (char c : b.toCharArray()) {
    //         sb.append(c == '0' ? '1' : '0');
    //     }
    //     return Integer.parseInt(sb.toString(), 2);
    // }