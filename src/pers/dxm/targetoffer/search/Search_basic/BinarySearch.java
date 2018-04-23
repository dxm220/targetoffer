package pers.dxm.targetoffer.search.Search_basic;

/**
 * Created by douxm on 2018\4\9 0009.
 * title:二分查找（循环和递归两种方式）
 */
public class BinarySearch {
    //循环方式实现二分查找
    public int search1(int[] array, int searchNumber) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int middle = (lo + hi) / 2;
            if (array[middle] == searchNumber) {
                return middle;
            } else if (array[middle] < searchNumber) {
                lo = middle + 1;
            } else if (array[middle] > searchNumber) {
                hi = middle - 1;
            }
        }
        return -1;
    }

    //递归方式实现二分查找
    public int search2(int[] array, int searchNumber, int lo, int hi) {
        int middle = (lo + hi) / 2;
        if (array[middle] == searchNumber) {
            return middle;
        } else if (array[middle] < searchNumber) {
            return search2(array, searchNumber, middle + 1, hi);
        } else if (array[middle] > searchNumber) {
            return search2(array, searchNumber, lo, middle - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1, 3, 5, 6, 7, 8, 9, 10, 15};
        System.out.println(binarySearch.search1(array, 6));
        System.out.println("-------------------------------");
        System.out.println(binarySearch.search2(array, 6, 0, 8));
    }
}
