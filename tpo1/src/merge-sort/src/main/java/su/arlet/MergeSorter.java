package su.arlet;

import java.util.Arrays;

public class MergeSorter {
    public void sort(int[] a) {
        if (a == null)
            return;

        innerSort(a, a.length);
    }

    private void innerSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = Arrays.copyOfRange(a, 0, mid);
        int[] r = Arrays.copyOfRange(a, mid, n);

        innerSort(l, mid);
        innerSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    private void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j])
                a[k++] = l[i++];
            else
                a[k++] = r[j++];
        }

        while (i < left) a[k++] = l[i++];
        while (j < right) a[k++] = r[j++];
    }
}
