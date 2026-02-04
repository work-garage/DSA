class Solution {

    //IMP:Very good approach of checking Rotated sequence
    // Optimised

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        StringBuilder Double = new StringBuilder();  
        Double.append(s).append(s);                 

        return Double.toString().contains(goal);
    
        // OR can do below but as string is immutable, so used StringBuilder
        //   String Double = s+s;
        //  return Double.contains(goal);
    }
}


// VS


    //Below are brute force Unoptimised approaches.


    // public boolean rotateString(String s, String goal) {

    //     if (s.length() != goal.length()) return false;

    //     if(s.equals(goal)) return true;

    //     for(int i=1; i<s.length(); i++){

    //         String str = new String();
    //         str = s.substring(i,s.length())+s.substring(0,i);
            
    //         if(str.equals(goal)) return true;

    //     }
    //     return false;
    // }



// OR


    // public boolean rotateString(String s, String goal) {

    //     if (s.length() != goal.length()) return false;

    //     if(s.equals(goal)) return true;

    //     for(int i=1; i<s.length(); i++){

    //         boolean f = true;

    //         String str = new String();
    //         str = s.substring(i,s.length())+s.substring(0,i);
    //         for(int j=0; j<s.length(); j++){
    //             if(str.charAt(j)!=goal.charAt(j)){
    //                 f = false;
    //                 break;
    //             }
    //         }

    //         if(f){
    //             return true;
    //         }

    //     }
    //     return false;
    // }