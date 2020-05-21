package Sorting;

public class BubbleSort {
    private static int[] bubbleSort(int[] a) {
        int temp;

        for (int i = 0; i < a.length - 1; i += 1) {
            for (int j = 0; j < a.length - i - 1; j += 1) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        return a;
    }

    private static int[] optimizedBubbleSort(int[] a) {
        int temp;

        for (int i = 0; i < a.length - 1; i += 1) {
            boolean swapped = false;

            for (int j = 0; j < a.length - i - 1; j += 1) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }

        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 10, 15, 2, 13, 5};
        optimizedBubbleSort(a);

        for (int i = 0; i < a.length; i += 1)
            System.out.print(a[i] + " ");
    }
}

// time complexity o(n^2)