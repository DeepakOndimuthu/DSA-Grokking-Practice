package Strings.medium;

/*
 MEDIUM
 No. 10
 Problem: String Compression
 Pattern: Two Pointers / Counting
 Status: ✅ Solved

 LeetCode similar:
 - 443 (String Compression)

 Input:
 chars = ['a','a','b','b','c','c','c']

 Output:
 6
 chars becomes = ['a','2','b','2','c','3']

 Explanation:
 Consecutive repeating characters are compressed as:
 character + count.

 If count is 1, only the character is written.
 Compression must be done in-place.
*/

public class StringCompression10 {

    public static int compress(char[] chars) {

        int read = 0;   // reads original characters
        int write = 0;  // writes compressed result

        while (read < chars.length) {

            char currentChar = chars[read];
            int count = 0;

            // count repeating characters
            while (read < chars.length &&
                    chars[read] == currentChar) {
                read++;
                count++;
            }

            // write character
            chars[write++] = currentChar;

            // write count if more than 1
            if (count > 1) {

                String countStr = String.valueOf(count);

                for (char c : countStr.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }

    public static void main(String[] args) {

        char[] chars = {'a','a','b','b','c','c','c'};

        int length = compress(chars);

        System.out.println("Compressed Length: " + length);

        for (int i = 0; i < length; i++) {
            System.out.print(chars[i] + " ");
        }
    }
}

/*
Note
chars[write++] = currentChar;
Initially write = 0
So: chars[0] = 'a'
write becomes 1
[a, ?, ?, ?, ?, ?, ?]
     ↑
   write
countStr = "12" we save it 1 then 2 not 12
and for loop if count 1 above time array is
[a, 2, ?, ?, ?, ?, ?]
        ↑
      write
*************************
full visual
[a, ?, ?, ?, ?, ?, ?]
 ↑
written
[a, 2, ?, ?, ?, ?, ?]
     ↑
   write
[a, 2, b, ?, ?, ?, ?]
        ↑
      write
[a, 2, b, 2, ?, ?, ?]
           ↑
         write
[a, 2, b, 2, c, ?, ?]
              ↑
            write
[a, 2, b, 2, c, 3, ?]
                 ↑
               write

*/