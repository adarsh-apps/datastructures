package Sorting;

public class CountSort {
    public static void countSort(int[] a) {
        int max = a[0], i;

        for (i = 1; i < a.length; i += 1) {
            if (max < a[i])
                max = a[i];
        }

        int[] elementsCount = new int[max + 1];

        for (i = 0; i < a.length; i += 1) {
            elementsCount[a[i]] += 1;
        }

        int j = 0;
        i = 0;

        while (i <= max) {
            if (elementsCount[i] > 0) {
                a[j] = i;
                elementsCount[i] -= 1;
                j += 1;
            } else {
                i += 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 10, 15, 2, 13, 5};

        countSort(a);

        for (int i = 0; i < a.length; i += 1)
            System.out.print(a[i] + " ");
    }
}

// time complexity o(n)
// consume memory.
