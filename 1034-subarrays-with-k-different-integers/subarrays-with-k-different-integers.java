class Solution {

    // Optimised: O(4N) = 2N of Check(nums, k) and 2N of Check(nums, k-1)
    
    // Approach 3: WE HAVE TO FIND count of subarrays with NUMBER OF K DIFFERENT INTEGERS IN THAT ARRAY
    // So, [count of Unique elem = K] = [count of Unique elem <= K ]-[count of Unique elem <= K-1]

    // How: we first were able to count all subarrays with <= K Unique numbers
    // So, we wanted to remove  all subarrays with < K Unique numbers
    // but then instead of doing changes in same method for taking only count of Unique elem = K, 
    // we find all subarrays with < K-1 Unique numbers, and subtract from subarrays with <= K Unique numbers
    // So, we got our: count of subarrays with = K Unique numbers

    public int subarraysWithKDistinct(int[] nums, int k) {
        int answer = Check(nums, k) - Check(nums, k-1);
        return answer;
    }

    public int Check(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;
        int left =0;
        for(int right =0;right < nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) +1);
            while(map.size() > k){                               //for: do not take subarrays above k unique num
                map.put(nums[left], map.get(nums[left]) -1);
                if(map.get(nums[left]) == 0)map.remove(nums[left]);
                left++;
            }
            count = count + (right - left +1);
        }
        return count;
    }
}



    // Approach 1: Brute-Force: use 2 loops, but TLE as O(N^2)




    // Approach 2: Sliding Window + need of iterate selected window to include all needed subarrays


    // Note: TLE as this approach is may be O(n^2) worst-case because you copy the map and loop for many j

    // public int subarraysWithKDistinct(int[] nums, int k) {
    //     HashMap<Integer,Integer> hm = new HashMap<>();

    //     int i = 0, j = 0, subKCnt=0;
    //     while(j<nums.length){
    //         hm.put(nums[j], hm.getOrDefault(nums[j],0)+1);
    //         while(hm.size()>k){
    //             hm.put(nums[i], hm.get(nums[i])-1);
    //             if(hm.get(nums[i])<=0) hm.remove(nums[i]);  //never forget to do this if using condition having (hm.size) eg. hm.size>k, because some elements with frequency 0 or -ve are still counted in hm.size()
    //             i++;
    //         }
    //         if(hm.size()==k){
    //             HashMap<Integer,Integer> hmTemp = new HashMap<>(hm);      // for duplicate: shallow copy: -Keys and values are copied as references   -Map structure is new   -Objects inside are NOT duplicated(so can create problem of doing changes in both hm and hmTemp if you modify reference object (not if you replace old object. Know examples from gpt saved chats) )
    //             int l = i;
    //             while (l <= j && hmTemp.size() == k) {
    //                 subKCnt++;
    //                 int cnt = hmTemp.getOrDefault(nums[l], 0) - 1;
    //                 if (cnt <= 0) hmTemp.remove(nums[l]);
    //                 else hmTemp.put(nums[l], cnt);
    //                 l++;
    //             }
    //         }
    //         j++;
    //     }
    //     return subKCnt;
    // }




    // by mistake, i wrote code for numOfSubarraysWithDistinctElemOnly:

    // public int func(int[] nums, int k) {
    //     HashSet<Integer> set = new HashSet<>();

    //     int i = 0, j = 0, subCnt=0;
    //     while(j<nums.length){

    //         while(set.contains(nums[j])){
    //             set.remove(nums[i]);
    //             i++;
    //         }

    //         subCnt++;
    //         subCnt+=j-i;

    //         set.add(nums[j]);
    //         j++;
    //     }
    //     return subCnt;
    // }
