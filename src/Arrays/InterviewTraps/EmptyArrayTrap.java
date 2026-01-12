package Arrays.InterviewTraps;

/*
 No. 1
 Problem: Edge Case – Empty Array
 Pattern: Defensive Check
 Status: ✅ Trap Covered

 Input: nums = []
 Output: Handle safely (no crash)

 Logic:
 1. Check if array length is 0
 2. If empty, return default value or message
 3. Prevent ArrayIndexOutOfBoundsException
*/

public class EmptyArrayTrap {

    public static void checkArray(int[] nums) {
        if (nums.length == 0) {
            System.out.println("Array is empty");
            return;
        }

        System.out.println("First element: " + nums[0]);
    }

    public static void main(String[] args) {
        int[] nums = {};
        checkArray(nums);
    }
}

