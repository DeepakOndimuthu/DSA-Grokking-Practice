package Arrays.InterviewTraps;

/*
 No. 2
 Problem: Index vs Value Confusion (Trap Question)
 Pattern: Logical understanding
 Status: ✅ Solved

 Input: nums = [10, 20, 30]
 Task: Print index and value correctly
*/

public class IndexValueTrap {

    public static void main(String[] args) {
        int[] nums = {10, 20, 30};

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Index: " + i + " Value: " + nums[i]);
        }
    }
}

