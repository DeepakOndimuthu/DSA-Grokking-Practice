package slidingWindow.traps;

/*
 No. 2
 Problem: Incorrect Window Size
 Pattern: Sliding Window Trap
 Status: ✅ Trap Covered

 Input:
 start = 2, end = 4

 Wrong Output:
 size = 2

 Correct Output:
 size = 3

 Logic:
 1. Always use: end - start + 1
*/

public class WindowSizeTrap02 {

    public static void main(String[] args) {

        int start = 2;
        int end = 4;

        int wrongSize = end - start;       // ❌ wrong
        int correctSize = end - start + 1; // ✅ correct

        System.out.println("Wrong size: " + wrongSize);
        System.out.println("Correct size: " + correctSize);
    }
}