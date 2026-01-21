package Arrays.medium;

/*
 No. 6
 Problem: Best Time to Buy and Sell Stock
 Pattern: Single Pass + Min Tracking
 LeetCode: 121 (Best Time to Buy and Sell Stock) & 122 , 123
 Status: ✅ Solved

 Input:
 prices = [7, 1, 5, 3, 6, 4]

 Output:
 5

 Explanation:
 Buy on day 2 at price 1.
 Sell on day 5 at price 6.
 Profit = 6 - 1 = 5.

 The goal is to maximize profit.
 You can complete only one transaction (buy once and sell once).
*/

public class BestTimeToBuySellStock06 {
    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            if (price < minPrice) {
                minPrice = price;   // best day to buy
            } else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;  // best profit
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
