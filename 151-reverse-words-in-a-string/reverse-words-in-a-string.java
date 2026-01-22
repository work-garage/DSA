class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.strip().split("\\s+");

        StringBuilder ans = new StringBuilder();

        for(int i=strArr.length-1; i>=0; i--){
            ans.append(strArr[i]);
            ans.append(" ");
        }

        String finalAns = ans.toString().strip();
        return finalAns;
    }
}

//used regex(to remove multiple spaces): 

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
//         String finalAns = ans.toString().trim();

//         return finalAns;
// }