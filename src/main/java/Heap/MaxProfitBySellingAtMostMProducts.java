package Heap;

public class MaxProfitBySellingAtMostMProducts {
    public static void getMaxProfitBySellingproducts(int[] costPrices, int[] sellingPrices, int noOfProducts) throws Exception {
        for (int i = 0; i < costPrices.length; i += 1) {
            MaxHeap.insert(sellingPrices[i] - costPrices[i]);
        }

        int profit = 0;

        while (noOfProducts > 0) {
            int currentProfit = MaxHeap.delete();
            profit = Math.max(profit + currentProfit, profit);
            noOfProducts -= 1;
        }

        System.out.println(profit);
    }

    public static void main(String[] a) throws Exception {
        int[] costPrices = {17, 9, 8, 20};
        int[] sellingPrices = {10, 9, 8, 27};
        int noOfProducts = 2;
        getMaxProfitBySellingproducts(costPrices, sellingPrices, noOfProducts);
    }
}
