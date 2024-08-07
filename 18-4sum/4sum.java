class Solution {
// public List<List<Integer>> fourSum(int[] nums, long target) {
//         List<List<Integer>> list = new ArrayList<>();
//                 if (nums == null || nums.length < 4) {
//             return list;
//         }
//         int var = Integer.MIN_VALUE;
//         Arrays.sort(nums);
//         int n = nums.length;
//         for (int i = 0; i < n; i++) {
//             if (i > 0 && nums[i] == nums[i - 1]) {
//                 continue;
//             }
//             for (int j = i + 1; j < n; j++) {
//                 if (j > i + 1 && nums[j] == nums[j - 1]) {
//                     continue;
//                 }
//                 int k = j + 1;
//                 int l = n - 1;
//                 while (k < l) {
//                     long sum = nums[i] + nums[j] + nums[k] + nums[l];
//                     if(sum < var ){
//                         List<Integer> temp  = new ArrayList<>();
//                         list.add(temp);
//                         return list;
//                     }
//                     if (sum == target) {
//                         list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
//                         while (k < l && nums[k] == nums[k + 1]) {
//                             k++;
//                         }
//                         while (k < l && nums[l] == nums[l - 1]) {
//                             l--;
//                         }
//                         k++;
//                         l--;
//                     } else if (sum < target) {
//                         k++;
//                     } else {
//                         l--;
//                     }
//                 }
//             }
//         }
//         return list;
//     }

public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }

        return ans;
    }

}