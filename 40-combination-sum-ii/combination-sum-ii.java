class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);                            //  Now, sort the arr: arr= {1,1,2,2};
        List<List<Integer>> combiStore_ = new ArrayList<>();
        combinationSumII(candidates,0, target, new ArrayList<>(), combiStore_);
        return combiStore_;
    }
    void combinationSumII(int[] arr, int i, int K, ArrayList<Integer> combi, List<List<Integer>> combiStore_) {

        if( K==0 ) {
            combiStore_.add(new ArrayList<>(combi));
            return;
        }

        for(int j = i; j < arr.length; j++){

            if(j > i && arr[j] == arr[j-1]) continue;
            if(arr[j]>K) break;

            combi.add(arr[j]);
            combinationSumII(arr,j+1, K-arr[j], combi, combiStore_);
            combi.removeLast();
        }
    }
}
