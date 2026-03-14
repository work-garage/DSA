class Solution {

    // Brute force approach
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ResultHolder res = new ResultHolder(k);
        char[] letters = new char[]{'a','b','c'};
        dfs(0, n, sb, '\0', letters, res);
        return res.answer == null ? "" : res.answer;
    }

    // holder to allow passing by reference
    class ResultHolder {
        int k;
        String answer;
        ResultHolder(int k) { this.k = k; this.answer = null; }
    }

    void dfs(int pos, int n, StringBuilder sb, char prev, char[] letters, ResultHolder res) {
        if (res.answer != null) return; // early stop if found
        if (pos == n) {
            res.k--;
            if (res.k == 0) res.answer = sb.toString();
            return;
        }
        for (char c : letters) {
            if (c == prev) continue;
            sb.append(c);
            dfs(pos + 1, n, sb, c, letters, res);
            sb.deleteCharAt(sb.length() - 1);
            if (res.answer != null) return;
        }
    }
}