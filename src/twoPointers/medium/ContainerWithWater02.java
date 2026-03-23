package twoPointers.medium;

/*
 MEDIUM
 No. 2
 Problem: Container With Most Water
 Pattern: Opposite Direction Two Pointers
 Status: ✅ Solved

 LeetCode:
 - 11 (Container With Most Water)

 Input:
 height = [1,8,6,2,5,4,8,3,7]

 Output:
 49

 Explanation:
 Choose two lines that form container.
 Area = width * height
 width = right - left
 height = min(height[left], height[right])
*/

public class ContainerWithWater02 {

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = h * width;

            maxArea = Math.max(maxArea, area);

            // move smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));
    }
}

/*
One wall is short, one wall is tall
Water always leaks from short wall

👉 So fixing tall wall is useless
👉 Fix short wall

so Move pointer of smaller height
Because only that can increase area

small height to max we go then find area max

We move smaller height pointer
to try getting bigger height
to maximize area

area = min(height[left], height[right]) * (right - left)
this concept get min heigh first

area = height * width

Concept:
1. Start with max width
2. Calculate area using min height
3. Move smaller pointer
4. Repeat
5. Track max area

For every pair → take smaller height → calculate area


 */