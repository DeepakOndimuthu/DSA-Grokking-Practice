package slidingWindow.medium;

import java.util.HashMap;

/*
 MEDIUM
 No. 9
 Problem: Fruits into Baskets
 Pattern: Sliding Window (Variable Size + HashMap)
 Status: ✅ Solved

 LeetCode:
 - 904 (Fruit Into Baskets)

 Input:
 fruits = [1,2,1,2,3]

 Output:
 4

 Explanation:
 Pick max 2 types:
 [1,2,1,2] → length = 4
*/

public class FruitsIntoBaskets09 {

    public static int totalFruits(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < fruits.length; end++) {

            int fruit = fruits[end];

            map.put(fruit, map.getOrDefault(fruit, 0) + 1);

            // allow only 2 types
            while (map.size() > 2) {

                int leftFruit = fruits[start];
                map.put(leftFruit, map.get(leftFruit) - 1);

                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }

                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] fruits = {1,2,1,2,3};

        int result = totalFruits(fruits);

        System.out.println("Max fruits: " + result);
    }
}

/*

Concept
You have:
2 baskets only
Each basket can hold:
only ONE type of fruit
So total:
you can carry at most 2 types

Goal:
Find longest subarray with at most 2 different numbers

Simple Dry Idea
[1] → ok
[1,2] → ok
[1,2,1] → ok
[1,2,1,2] → ok (max = 4)
[1,2,1,2,3] → 3 types ❌ → shrink

🚍 Easy example
You have 2 baskets
Pick fruits from trees
If 3rd type comes → drop old fruits

 */