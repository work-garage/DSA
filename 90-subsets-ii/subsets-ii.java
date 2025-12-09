class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> combiStore = new ArrayList<>();
        Arrays.sort(nums);
        combinationSumII(0, nums, new ArrayList<>(), combiStore);
        return combiStore;
    }
    void combinationSumII(int i, int[] arr, List<Integer> combi, List<List<Integer>> combiStore) { 

        combiStore.add(new ArrayList<>(combi)); 
            
        for(int j = i; j < arr.length; j++){ 

            if(j > i && arr[j] == arr[j-1]) continue; 

            combi.add(arr[j]);
            combinationSumII(j+1,arr, combi,combiStore);
            combi.removeLast();
        }

    }
}