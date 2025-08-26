class Solution {

    String result = "";

    public String getPermutation(int n, int k){
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = i+1;
        }
        ArrayList<ArrayList<Integer>> permutStore = new ArrayList<>();
        AtomicInteger currK = new AtomicInteger(0);
        returnKthPermut(currK, k, arr, new ArrayList<>(), new boolean[arr.length], permutStore);
        return result;
    }

    boolean returnKthPermut(AtomicInteger currK, int maxK, int[] arr, ArrayList<Integer> permut, boolean[] idxUsed, ArrayList<ArrayList<Integer>> permutStore){
        if(permut.size() == arr.length){
            permutStore.add(new ArrayList<>(permut));

            if(currK.incrementAndGet() == maxK){
                StringBuilder sb = new StringBuilder();
                for (int v : permut) sb.append(v);
                result = sb.toString();
                return true;
            }
            
            return false;
        }

        for(int idx = 0; idx<arr.length; idx++){

            if(idxUsed[idx]){
                continue;
            }

            permut.add(arr[idx]);
            idxUsed[idx] = true;
            if(returnKthPermut( currK, maxK, arr, permut, idxUsed, permutStore)) return true;
            permut.removeLast();
            idxUsed[idx] = false;
        }
        return false;
    }
}