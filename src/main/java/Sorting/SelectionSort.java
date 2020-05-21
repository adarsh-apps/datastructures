package Sorting;

public class SelectionSort {
    public static void selectionSort(int[] a) {
        int element, k;

        for (int i = 0; i < a.length; i += 1) {
            element = a[i];
            k = i;

            for (int j = i; j < a.length; j += 1) {
                if (a[k] > a[j])
                    k = j;
            }

            a[i] = a[k];
            a[k] = element;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 10, 15, 2, 13, 5};

        selectionSort(a);

        for (int i = 0; i < a.length; i += 1)
            System.out.print(a[i] + " ");
    }
}
// time complexity o(n^2)