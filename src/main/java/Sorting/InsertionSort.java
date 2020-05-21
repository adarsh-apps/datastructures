package Sorting;

public class InsertionSort {
    public static void insertionSort(int[] a) {
        int element;

        for (int i = 1; i < a.length; i += 1) {
            element = a[i];
            int j = i - 1;

            while (j >= 0&&  a[j] > element) {
                a[j + 1] = a[j];
                j -= 1;
            }

            a[j + 1] = element;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 10, 15, 2, 13, 5};

        insertionSort(a);

        for (int i = 0; i < a.length; i += 1)
            System.out.print(a[i] + " ");
    }
}
// time complexity o(n^2)