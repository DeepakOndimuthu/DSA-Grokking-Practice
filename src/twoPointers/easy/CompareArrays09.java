package twoPointers.easy;

/*
 EASY
 No. 9
 Problem: Compare Two Arrays
 Pattern: Two Pointers
 Status: ✅ Solved

 Input:
 arr1 = [1,2,3]
 arr2 = [1,2,3]

 Output:
 true

 Explanation:
 Compare elements one by one using pointers.
*/

public class CompareArrays09 {

    public static boolean isEqual(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length) return false;

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] != arr2[j]) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};

        System.out.println(isEqual(arr1, arr2));
    }
}

/*
Compare element by element
If any mismatch → false
Else → true
 */