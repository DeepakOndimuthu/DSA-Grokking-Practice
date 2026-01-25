package Arrays.medium;

/*
 MEDIUM
 No. 19
 Problem: Find Union of Two Arrays
 Pattern: Two Pointers + Sorting
 Status: ✅ Solved
 LeetCode similar: 349 / 88 / GFG Union of Two Sorted Arrays

 Input:
 nums1 = [1, 2, 2, 1]
 nums2 = [2, 3, 4]

 Output:
 [1, 2, 3, 4]

 Logic:
 1. Sort both arrays
 2. Use two pointers
 3. Add smaller value
 4. If equal, add once and move both
 5. Avoid duplicates using last added value
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class UnionOfTwoArrays09 {

    public static int[] union(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {
                addUnique(result, nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                addUnique(result, nums1[i]);
                i++;
            } else {
                addUnique(result, nums2[j]);
                j++;
            }
        }

        // add remaining elements
        while (i < nums1.length) {
            addUnique(result, nums1[i]);
            i++;
        }

        while (j < nums2.length) {
            addUnique(result, nums2[j]);
            j++;
        }

        // convert list to array
        int[] ans = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            ans[k] = result.get(k);
        }

        return ans;
    }

    // helper to avoid duplicates
    private static void addUnique(List<Integer> result, int value) {
        if (result.isEmpty() || result.get(result.size() - 1) != value) {
            result.add(value);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 3, 4};

        System.out.println(Arrays.toString(union(nums1, nums2)));
    }
}
