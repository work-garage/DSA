class Solution {
    public void nextPermutation(int[] arr) {
        if(arr.length<=1) return;

        for(int i = arr.length-2; i>=0; i--){
            int j=arr.length-1;

            while(arr[i]>=arr[j]){
                if(i<j-1){
                    j--;
                }
                else{
                    break;
                }
            }
            if( i>=0 && arr[i]<arr[j] ){
                swap(i,j,arr);
                reverse( i+1, arr.length-1, arr);    //sort i+1 to arr.length-1
                break;
            }
            if(i==0){
                reverse( 0, arr.length-1, arr);      //sort 0 to arr.length-1
            }
        }
    }
    void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }
    void reverse( int i, int j, int[] arr){
        while(i<=j){
            swap(i,j,arr);
            i++;
            j--;
        }
    }
}