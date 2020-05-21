package Heap;

public class MaxProfitBySellingTickets {
    public static void getMaxProfitBySellingTickets(int [] seats, int members) throws Exception {
        for (int i = 0; i < seats.length; i += 1) {
            MaxHeap.insert(seats[i]);
        }

        int profit = 0;

        while (members > 0 && MaxHeap.getTopElement() != 0) {
            int currentProfit = MaxHeap.delete();
            profit += currentProfit;
            members -= 1;
            MaxHeap.insert(--currentProfit);
        }

        System.out.println(profit);
    }

    public static void main(String[] a) throws Exception {
        int[] seats = {2, 3, 4, 5, 1};
        int members = 6;
        getMaxProfitBySellingTickets(seats, members);
    }
}
