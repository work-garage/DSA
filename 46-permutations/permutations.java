class Solution {
    public List<List<Integer>> permute(int[] arr) {

        List<List<Integer>> permutStore = new ArrayList<>();
        permutationI(arr, new ArrayList<>(), new boolean[arr.length], permutStore);
        return permutStore;
    }

    void permutationI(int[] arr, List<Integer> permut, boolean[] idxUsed, List<List<Integer>> permutStore){

        if(permut.size() == arr.length){
            permutStore.add(new ArrayList<>(permut));
            return;
        }

        for(int idx = 0; idx<arr.length; idx++){

            if(idxUsed[idx]){
                continue;
            }

            permut.add(arr[idx]);
            idxUsed[idx] = true;
            permutationI( arr, permut, idxUsed, permutStore);
            permut.removeLast();
            idxUsed[idx] = false;
        }
    }
}