package slidingWindow.traps;

/*
 No. 5
 Problem: Complexity Confusion
 Pattern: Sliding Window Analysis Trap
 Status: ✅ Trap Covered

 Wrong Thinking:
 Nested loops = O(n^2)

 Correct:
 Sliding window = O(n)

 Logic:
 1. Each element visited at most 2 times
 2. start and end both move forward
*/

public class ComplexityTrap05 {

    public static void main(String[] args) {

        System.out.println("Sliding window is O(n), not O(n^2)");

        System.out.println("Reason:");
        System.out.println("Each element added once (end)");
        System.out.println("Each element removed once (start)");
    }
}

/*

loop inside loop → O(n²) ❌
for (end = 0 ... n) {
    while (condition) {
        start++;
    }
}

Easy example
Think:
end → walks from 0 to n
start → also walks from 0 to n
Nobody walks backward
So total walking = linear

*********************

start and end both move only forward
👉 They never go backward

arr = [1,2,3,4,5]
🔹 end pointer
end moves:
0 → 1 → 2 → 3 → 4
👉 total = n steps

🔹 start pointer
start also moves:
0 → 1 → 2 → 3 → 4
👉 total = n steps
✅ Total operations
end moves n times
start moves n times

Total ≈ 2n → O(n)

*******************

❗ Important insight
👉 Even though while is inside for:

start does NOT reset to 0 each time
👉 It only moves forward

 */