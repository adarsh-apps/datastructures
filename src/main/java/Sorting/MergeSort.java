package Sorting;

public class MergeSort {
    public static void merge(int[] a, int low, int mid, int high) {
        int b[] = new int[a.length];
        int i = low, j = mid + 1, k = low;

        while (i <= mid && j < high) {
            if (a[i] < a[j]) {
                b[k] = a[i];
                i += 1;
            } else {
                b[k] = a[j];
                j += 1;
            }

            k += 1;
        }

        while (i <= mid) {
            b[k] = a[i];
            i += 1;
            k += 1;
        }

        while (j < high) {
            b[k] = a[j];
            j += 1;
            k += 1;
        }

        for (i = low; i < high; i += 1) {
            a[i] = b[i];
        }
    }

    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 10, 15, 2, 13, 5};

        mergeSort(a, 0, a.length);

        for (int i = 0; i < a.length; i += 1)
            System.out.print(a[i] + " ");
    }
}

//time complexity nlogn
