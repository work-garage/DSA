class Solution {
    public int findKthLargest(int[] arr, int k) {

        // 1)Brute force: sort    N log N

        // 2)Optimised: Heap      N log K

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){
            minHeap.add(arr[i]);
            if(minHeap.size()>k) minHeap.remove();
        }
        return minHeap.peek();
    }
}