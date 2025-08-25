class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> allAns = new ArrayList<>();
        List<String> currPartition = new ArrayList<>();
        palindromePartition(0, s, currPartition, allAns);
        return allAns;
    }

    void palindromePartition(int i, String s, List<String> currPartition, List<List<String>> allAns){

        //if(isValid(currPartition)){          //checks every piece of the partition every recursive call — that's wasteful.
                                               // Instead check the single substring we're about to add. in below for loop code
        //    allAns.add(new ArrayList<>(currPartition));
        //}

        if(i == s.length()){
            allAns.add(new ArrayList<>(currPartition));
            return;
        }

        for(int j= i; j<s.length(); j++){
            if(isValidPalindrome(s, i, j)){
                currPartition.add(s.substring(i,j+1));            //i is inclusive, j is exclusive

                palindromePartition(j+1, s, currPartition, allAns);         //⭐Note: Unlike other backtracking Q like N Queen and Sudoku, etc we are doing  j+1 here, not i+1

                currPartition.removeLast();
            }
        }
    }

    boolean isValidPalindrome(String s, int l, int r){
        while (l < r) {                                                //palindrome check code
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}