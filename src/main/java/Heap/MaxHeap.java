package Heap;

import java.util.ArrayList;

public class MaxHeap {
    public static ArrayList<Integer> heap = new ArrayList<Integer>();

    public static void insert(int element) {
        heap.add(element);
        shiftUp(heap.size() - 1);
    }

    public static void shiftUp(Integer currentIndex) {
        Integer currentElement = heap.get(currentIndex);
        Integer parentIndex = (currentIndex - 1) / 2;

        if (currentElement > heap.get(parentIndex)) {
            heap.set(currentIndex, heap.get(parentIndex));
            heap.set(parentIndex, currentElement);
            shiftUp(parentIndex);
        }
    }

    public static Integer delete() throws Exception {
        if (heap.size() == 0) {
            throw new Exception("under flow");
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        Integer rootElement = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        shiftDown(0);
        return rootElement;
    }

    public static void shiftDown(Integer rootIndex) {
        Integer root = heap.get(rootIndex);
        Integer leftIndex = rootIndex * 2 + 1;
        Integer rightIndex = rootIndex * 2 + 2;

        if (leftIndex < heap.size() && rightIndex < heap.size()) {
            if (heap.get(leftIndex) >= heap.get(rightIndex) && heap.get(leftIndex) > root) {
                heap.set(rootIndex, heap.get(leftIndex));
                heap.set(leftIndex, root);
                shiftDown(leftIndex);
            } else if (heap.get(rightIndex) > heap.get(leftIndex) && heap.get(rightIndex) > root) {
                heap.set(rootIndex, heap.get(rightIndex));
                heap.set(rightIndex, root);
                shiftDown(rightIndex);
            }
        } else if (leftIndex < heap.size()) {
            if (heap.get(leftIndex) > root) {
                heap.set(rootIndex, heap.get(leftIndex));
                heap.set(leftIndex, root);
                shiftDown(leftIndex);
            }
        }
    }

    public static int getTopElement() {
        return heap.get(0);
    }

    public static void main(String[] args) throws Exception {
        int[] a = {10, 30, 50, 60, 25, 15, 35};

        for (int i = 0; i < a.length; i += 1) {
            insert(a[i]);
        }

        for (Integer integer : heap) {
            System.out.print(integer + " ");
        }

        System.out.println();

        for (int i = 0; i < a.length; i += 1) {
            a[i] = delete().intValue();
            System.out.print(a[i] + " ");
        }
    }
}
