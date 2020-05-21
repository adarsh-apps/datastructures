package Sorting;

public class HeapSort {
    public static void heapSort(int[] a) {
        for (int i = a.length / 2; i >= 0; i -= 1)
            heapify(a, a.length, i);


        for (int i = a.length - 1; i > 0; i -= 1) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapify(a, i, 0);
        }
    }

    public static void heapify(int[] a, int n, int index) {
        int temp = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (left < n && a[left] > a[index]) {
            index = left;
        }

        if (right < n && a[right] > a[index]) {
            index = right;
        }

        if (temp != index) {
            int element = a[index];
            a[index] = a[temp];
            a[temp] = element;

            heapify(a, n, index);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 10, 15, 2, 13, 5};

        heapSort(a);

        for (int i = 0; i < a.length; i += 1)
            System.out.print(a[i] + " ");
    }
}
