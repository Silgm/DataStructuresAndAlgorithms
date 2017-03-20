package src.Algorithm;

import java.util.Arrays;

public class Sort {
    //冒泡排序法
    public static void bubbleSort(int[] a) {
        boolean t = true;
        while (t) {
            t = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    t = true;
                }
            }
        }
    }

    //选择排序法
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int low = i, high = a.length - 1;
            while (low < high) {
                if (a[low] < a[high]) {
                    high--;
                } else {
                    low++;
                }
            }
            int temp = a[low];
            a[low] = a[i];
            a[i] = temp;
        }
    }

    //插入排序法
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i;
            while (j >= 1 && a[j - 1] > temp) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    //希尔排序法
    public static void shellSort(int[] a) {
        int len = a.length / 2;
        while (len > 0) {
            for (int i = len; i < a.length; i++) {
                int value = a[i];
                int pos = i;
                while (pos - len >= 0 && a[pos - len] > value) {
                    a[pos] = a[pos - len];
                    pos -= len;
                }
                a[pos] = value;
            }
            len--;
        }
    }

    //归并排序法
    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int left, int mid, int right) {
        if (left >= right) {
            return;
        }
        int[] x = new int[mid - left + 1];
        int[] y = new int[right - mid];
        for (int i = 0; i < x.length; i++) {
            x[i] = a[left + i];
        }
        for (int i = 0; i < y.length; i++) {
            y[i] = a[mid + 1 + i];
        }
        int i = 0, j = 0, position = left;
        while (i < x.length || j < y.length) {
            if ((j == y.length) || i < x.length && x[i] < y[j]) {
                a[position++] = x[i++];
            } else {
                a[position++] = y[j++];
            }
        }
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            mergeSort(a, left, mid, right);
        }
    }

    //快速排序法
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int letf, int right) {
        if (letf >= right) {
            return;
        }
        int low = letf;
        int high = right;
        int key = a[low];
        while (low < high) {
            for (; low < high && a[high] > key; high--) ;
            a[low] = a[high];
            for (; low < high && a[low] <= key; low++) ;
            a[high] = a[low];
        }
        a[low] = key;
        quickSort(a, letf, low - 1);
        quickSort(a, low + 1, right);
    }

    //堆排序法
    public static void heapSort(int[] a) {
        int flag = a.length;
        while (flag > 1) {
            for (int i = flag / 2 - 1; i > -1; i--) {
                int left = (i + 1) * 2 - 1;
                int right = (i + 1) * 2;
                if (a[i] < a[left]) {
                    int temp = a[left];
                    a[left] = a[i];
                    a[i] = temp;
                }
                if (right < flag && a[i] < a[right]) {
                    int temp = a[right];
                    a[right] = a[i];
                    a[i] = temp;
                }
            }
            int temp = a[flag - 1];
            a[flag - 1] = a[0];
            a[0] = temp;
            flag--;
        }
    }

}
