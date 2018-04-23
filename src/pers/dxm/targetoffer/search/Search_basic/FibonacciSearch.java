package pers.dxm.targetoffer.search.Search_basic;

/**
 * Created by douxm on 2018\4\10 0010.
 * title:斐波那契查找
 */
public class FibonacciSearch {
    //斐波那契查找
    public int search(int[] array, int serarchNumber) {
        int lo = 0;
        int hi = array.length - 1;
        int middle = 0;
        int[] f = initFibonacci();//获取斐波那契数列
        int k = 0;//斐波那契数列需要使用的最大下标
        //获取k的值
        while (array.length > f[k] - 1) {
            k++;
        }
        //创建临时数据，数组的长度是f[k]-1,临时数组temp的长度一定大于等于array的长度；temp后面的空位用array最后一位补齐
        int[] temp = new int[f[k] - 1];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        for (int j = array.length; j < f[k] - 1; j++) {
            temp[j] = temp[array.length - 1];
        }
        //构造完长度为斐波那契数的数组后，开始进行查找
        while (lo <= hi) {
            middle = lo + f[k - 1] - 1;
            //假设k初始是13，k-1=8,k-2=5;如果array[middle]大于serarchNumber，应该将8拆成5+3继续找,即拆成k-2和k-3
            //同理如果array[middle]小于serarchNumber，应该去8后面的5部分找，将5拆分成2+3，即去k-3和k-4找
            if (array[middle] > serarchNumber) {
                hi = middle - 1;
                k = k - 1;
            } else if (array[middle] < serarchNumber) {
                lo = middle + 1;
                k = k - 2;
            } else {
                // 如果为真则找到相应的位置
                if (middle <= hi) {
                    return middle;
                } else {
                    // 出现这种情况是查找到补充的元素，而补充的元素与high位置的元素一样
                    return hi;
                }
            }
        }
        return -1;
    }

    //构造一个长度为20的斐波那契数列
    public static int[] initFibonacci() {
        int[] array = new int[20];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < 20; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }

    public static void main(String[] args) {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        int[] array = {1, 5, 15, 22, 25, 31, 39, 42, 47, 49, 59, 68, 88};
        System.out.println(fibonacciSearch.search(array, 22));
    }
}
