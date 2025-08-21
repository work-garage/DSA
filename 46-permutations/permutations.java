class Solution {
    public List<List<Integer>> permute(int[] arr) {

    List<List<Integer>> permutStore = new ArrayList<>();
        permutationI(arr, new ArrayList<>(), new ArrayList<>(),permutStore);
        return permutStore;
    }
    
    void permutationI(int[] arr, List<Integer> permut, List<Integer> idxUsed,List<List<Integer>> permutStore){

        if(permut.size() == arr.length){
            permutStore.add(new ArrayList<>(permut));
            return;
        }
        
        for(int idx = 0; idx<arr.length; idx++){
            
            if(idxUsed.contains(idx)){
                continue;
            }
            
            permut.add(arr[idx]);
            idxUsed.add(idx);
            permutationI( arr, permut, idxUsed, permutStore);
            permut.removeLast();
            idxUsed.removeLast();
        }
    }
}