class Solution {
    public int findContentChildren(int[] child, int[] cookie) {
        Arrays.sort(child);
        Arrays.sort(cookie);
        
        int i=0;    //for cookie
        int j=0;    //for child

        while(i<cookie.length && j<child.length){
            if(cookie[i]>=child[j]){
                i++;
                j++;
            }
            else{
                i++;
            }
        }

        return j;           //no need to store in contentChildCount
    }
}