package RandomProblems;

public class MaxProfitByBuyAndSell {
    private static long getMaxProfit(int[] stock) {
        int maxProfit = 0;
        int buyValue = stock[0];

        for (int i = 1; i < stock.length; i += 1) {
            maxProfit = Math.max(maxProfit, stock[i] - buyValue);
            buyValue = Math.min(buyValue, stock[i]);
        }

        return maxProfit;
    }

    public static void main(String[] a) {
        int[] stock = {5, 7, 1, 1, 6, 3, 8};

        System.out.println(getMaxProfit(stock));
    }
}
