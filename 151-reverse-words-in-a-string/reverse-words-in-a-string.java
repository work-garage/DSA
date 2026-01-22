class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.strip().split(" +");  	    //OR s.split("\\s+");

        StringBuilder ans = new StringBuilder();

        for(int i=strArr.length-1; i>=0; i--){
            ans.append(strArr[i]);
            ans.append(" ");
        }

        return ans.toString().strip();
    }
}

//used regex(to remove multiple spaces):
//  You write	Regex engine understands
//  "."	        any character
//  "\\."   	literal dot
//  " "	        exactly one space
//  "\\s+"	    any whitespace, any amount
//  " +"	    spaces only

// VS

// Less efficient
// public String reverseWords(String s) {
//         Stack<Character> st = new Stack<>();
//         StringBuilder ans = new StringBuilder();

//         for(int i=s.length()-1; i>=0; i--){
//             if(s.charAt(i)!=' ') st.push(s.charAt(i));
//             else{
//                 if(!st.isEmpty()){
//                     while(!st.isEmpty()) ans.append(st.pop());
//                     ans.append(' ');
//                 }
//             }
//         }
//         if(!st.isEmpty()){
//             while(!st.isEmpty()) ans.append(st.pop());
//         }
//         //StringBuilder does not have trim()/strip()[strip() is modern as it removes non ascii spaces(unicode) also], use it on String
//         return ans.toString().strip();
// }