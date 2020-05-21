package Sorting;

public class QuickSort {
    public static int partition(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        int pivot = a[mid];
        int i = low, j = high;
        int temp;

        while (i < j) {
            while (a[i] < pivot) {
                i += 1;
            }

            while (pivot < a[j]) {
                j -= 1;
            }

            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;

                j -= 1;
                i += 1;
            }
        }

        temp = a[low];
        a[low] = a[j];
        a[j] = temp;

        return j;
    }

    public static void quickSort(int[] a, int l, int h) {
        if (l < h) {
            int partition = partition(a, l, h);

            quickSort(a, l, partition);
            quickSort(a, partition + 1, h);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 10, 15, 2, 13, 5};

        quickSort(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i += 1)
            System.out.print(a[i] + " ");
    }
}

//time complexity o(nlogn)