package Arrays.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/*
 MEDIUM
 No. 18
 Problem: Find Intersection of Two Arrays
 Pattern: Two Pointers + Sorting
 Status: ✅  Solved
 LeetCode similar: 349 & 350

 Input:
 nums1 = [1, 2, 2, 1]
 nums2 = [2, 2]

 Output:
 [2]

 Logic:
 1. Sort both arrays
 2. Use two pointers i and j
 3. If nums1[i] == nums2[j]:
      - add to result (avoid duplicates)
      - i++, j++
 4. If nums1[i] < nums2[j]: i++
 5. Else: j++
*/

public class IntersectionOfTwoArrays08 {
    public static int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {

                // avoid duplicates in result
                if (result.isEmpty() || result.get(result.size() - 1) != nums1[i]) {
                    result.add(nums1[i]);
                }
                i++;
                j++;

            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // convert list to array
        int[] ans = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            ans[k] = result.get(k);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] res = intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
