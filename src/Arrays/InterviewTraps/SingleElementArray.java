package Arrays.InterviewTraps;

/*
 Trap No. 3
 Problem: Single Element Array (Interview Edge Case)
 Pattern: Edge Case Handling
 Status: ✅ Solved

 Input: arr = [5]

 Output:
 Max = 5
 Min = 5
 Second largest = Not possible
 Array is sorted

 Explanation:
 When an array contains only one element:
 - That element is both minimum and maximum
 - Second largest element does not exist
 - A single element array is always considered sorted
*/

public class SingleElementArray {

    public static void main(String[] args) {
        int[] arr = {5};

        if (arr.length == 1) {
            System.out.println("Only one element present");
            System.out.println("Max = " + arr[0]);
            System.out.println("Min = " + arr[0]);
            System.out.println("Second largest = Not possible");
            System.out.println("Array is sorted");
        }
    }
}
