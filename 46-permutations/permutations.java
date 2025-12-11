class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutList = new ArrayList<>();
        permutI(0, nums, permutList);
        return permutList;
    }

    void permutI( int i, int[] arr, List<List<Integer>> permutList){

        if(i>=arr.length-1){    // 2
            List<Integer> permut = new ArrayList<>();
            for(int n:arr){ permut.add(n); }
            permutList.add(new ArrayList<>(permut));
            return;
        }

        for(int j=i; j<arr.length ; j++){
            swapArr(arr,i,j);
            permutI(i+1,arr,permutList);
            unswapArr(arr,j,i);
        }
    }

    void swapArr(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    void unswapArr(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}