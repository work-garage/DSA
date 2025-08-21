class Solution {
    public List<List<Integer>> permute(int[] arr) {

        List<List<Integer>> permutStore = new ArrayList<>();
        permutationI(0, arr, permutStore);
        return permutStore;
    }

    void permutationI(int i, int[] arr, List<List<Integer>> permutStore){

        if(i == arr.length){
            //store copy of arr(snapshot of arr) in ArrayList (just like we store copy of ArrayList in ArrayList)
            List<Integer> snapOfArr = new ArrayList<>();
            for(int a:arr){
                snapOfArr.add(a);
            }
            permutStore.add( new ArrayList<>(snapOfArr) );
            //

            return;
        }

        for(int idx = i; idx<arr.length; idx++){

            swap(i,idx, arr);     //swap

            permutationI(i+1, arr, permutStore);

            swap(i,idx, arr);     //undo the swap

        }
    }

    void swap(int i1, int i2, int[] arr){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}