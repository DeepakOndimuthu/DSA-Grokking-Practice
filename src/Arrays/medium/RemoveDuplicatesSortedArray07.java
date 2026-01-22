package Arrays.medium;

/*
 MEDIUM
 No. 17
 Problem: Remove Duplicates from Sorted Array
 Pattern: Two Pointers
 Status: ✅ Solved
 LeetCode similar: 26

 Input: nums = [1, 1, 2, 2, 3]
 Output: 3

 Logic:
 1. Use two pointers (i and j)
 2. i tracks position of last unique element
 3. j scans the array
 4. When nums[j] != nums[i]:
      - increment i
      - copy nums[j] to nums[i]
 5. Return i + 1
*/
import java.util.Arrays;
public class RemoveDuplicatesSortedArray07 {
    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        int k = removeDuplicates(nums);

        System.out.println("Unique count: " + k);
        System.out.print("Updated array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
