class Solution {
    public void nextPermutation(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i]) j--;
            swap(i, j, arr);
        }
        
        reverse( i + 1, arr.length - 1, arr);
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