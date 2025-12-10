class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutList = new ArrayList<>();
        permutI(nums, new ArrayList<>(), permutList);
        return permutList;
    }

    void permutI( int[] arr, List<Integer> permut, List<List<Integer>> permutList){
        
        if(arr.length == 0) return;

        if(permut.size()>=arr.length){
            permutList.add(new ArrayList<>(permut));
            return;
        }

        for(int j=0; j<arr.length; j++ ){
            if(!permut.contains(arr[j])){
                permut.add(arr[j]);
                permutI(arr,permut,permutList);
                permut.removeLast();
            }
        }
    }
}