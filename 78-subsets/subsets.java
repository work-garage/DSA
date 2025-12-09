class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> combStore = new ArrayList<>();
        combiI(0, nums, new ArrayList<Integer>(), combStore);
        return combStore;
    }

    void combiI(int i, int[] arr, ArrayList<Integer> comb, List<List<Integer>> combStore){

        if(i>=arr.length){
            combStore.add(new ArrayList<>(comb));
            return;
        }

        comb.add(arr[i]);
        combiI(i+1,arr,comb,combStore);
        comb.removeLast();

        combiI(i+1,arr,comb,combStore);
    }
}