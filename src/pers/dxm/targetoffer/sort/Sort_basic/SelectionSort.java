package pers.dxm.targetoffer.sort.Sort_basic;

/**
 * Created by douxm on 2018\4\9 0009.
 */
public class SelectionSort {
    public void sort(int[] array) {
        int temp;
        int min = 0, index = 0;//记录每次遍历的最小值，最小值的位置索引
        for (int i = 0; i < array.length - 1; i++) {
            min = array[i];
            for (int j = i; j < array.length - 1; j++) {
                if (min > array[j + 1]) {
                    min = array[j + 1];
                    index = j + 1;
                }
            }
            temp = array[i];
            array[i] = min;
            array[index] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = {4, 2, 1, 3, 7, 5, 8, 6, 9};
        selectionSort.sort(array);
        for (int i : array) {
            System.out.print(i + ";");
        }
    }
}
