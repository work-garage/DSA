class Solution {
    // Without Stack: depth based approach ( most Efficient) my code

    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();

        int o = 0;      //open bracket depth

        for(char c : s.toCharArray()){

            if(c=='('){
                if(o>0)ans.append(c);
                o++;
            }
            else{                       // if( c==')' )
                if(o>1)ans.append(c);
                o--;
            }

        }
        return ans.toString();
    }
}


// OR


// Without Stack: depth based approach ( most Efficient 2)  externalCode

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



// VS Stack approach



// 1) using Stack (myCode less optimised structure-wise)

// public String removeOuterParentheses(String s) {
//         Stack<Character> st = new Stack<>();
//         //if(s.length()%2!=0) return "";

//         String ans = "";            //should use StringBuilder(as its mutable) and String is immutable(when changed, creates new object and assigns value to ans)
//                                     //String usage In loops causes repeated object creation + copying, leading to O(n²) behavior

//         for(int i=0; i<s.length(); i++){      // can use for-each loop, but need to do: s.toCharArray()
            
//             //if(st.size%2!=0)
            
//             if(st.size()>0 ){                 // OR !st.isEmpty()
//                 if(st.peek()==s.charAt(i)){
//                     ans+=""+s.charAt(i);
//                     st.add(s.charAt(i));
//                 }
//                 else{
//                     if(st.size()==1){
//                         st.pop();
//                         continue;
//                     }
//                     st.pop();
//                     ans+=""+s.charAt(i);    // "" added, as to concatenate, otherwise st.pop() and s.charAt(i) will add their ascii eg('a'+'b'=>97+98= 195)    Thus its done as, String+char = String
//                 }
//             }
//             else{
//                 st.add(s.charAt(i));
//             }
//         }

//         return ans;
//     }


// VS

// 2) using Stack   (More optimised structure-wise)


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
