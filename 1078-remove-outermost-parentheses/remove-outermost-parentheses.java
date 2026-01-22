class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        //if(s.length()%2!=0) return "";

        String ans = "";

        for(int i=0; i<s.length(); i++){
            
            //if(st.size%2!=0)
            
            if(st.size()>0 ){
                if(st.peek()==s.charAt(i)){
                    ans+=""+s.charAt(i);
                    st.add(s.charAt(i));
                }
                else{
                    if(st.size()==1){
                        st.pop();
                        continue;
                    }
                    st.pop();
                    ans+=""+s.charAt(i);    // "" added, as to concatenate, otherwise st.pop() and s.charAt(i) will add their ascii eg('a'+'b'=>97+98= 195)    Thus its done as, String+char = String
                }
            }
            else{
                st.add(s.charAt(i));
            }
        }

        return ans;
    }
}


// VS

// 2) using Stack

// class Solution {
//     public String removeOuterParentheses(String s) {
//         StringBuilder sb = new StringBuilder();
//         Stack<Character> st = new Stack<>();

//         for (char c : s.toCharArray()) {
//             if (c == '(') {
//                 if (!st.isEmpty()) sb.append('(');
//                 st.push('(');
//             } else { // c == ')'
//                 st.pop();
//                 if (!st.isEmpty()) sb.append(')');
//             }
//         }

//         return sb.toString();
//     }
// }


//VS

// Without Stack ( most Efficient)

// class Solution {
//     public String removeOuterParentheses(String s) {
//         StringBuilder sb = new StringBuilder();
//         int depth = 0;

//         for (char c : s.toCharArray()) {
//             if (c == '(') {
//                 if (depth > 0) sb.append(c); // not an outermost '('
//                 depth++;
//             } else { // c == ')'
//                 depth--;
//                 if (depth > 0) sb.append(c); // not an outermost ')'
//             }
//         }

//         return sb.toString();
//     }
// }