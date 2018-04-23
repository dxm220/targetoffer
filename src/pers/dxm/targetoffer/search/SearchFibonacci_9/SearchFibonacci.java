package pers.dxm.targetoffer.search.SearchFibonacci_9;

/**
 * Created by douxm on 2018\4\12 0012.
 * title:寻找斐波那契数列某一项
 */
public class SearchFibonacci {

    //循环方式实现
    public int searchFibonacci1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int number1 = 0;//数列第一项
        int number2 = 1;//数列第二项
        int number3 = 0;//数列下一项
        for (int i = 2; i <= n; i++) {
            //以下操作就是一个指针移动的过程
            number3 = number1 + number2;
            number1 = number2;
            number2 = number3;
        }
        return number3;
    }

    //递归方式实现
    public int searchFibonacci2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return searchFibonacci2(n - 1) + searchFibonacci2(n - 2);
    }

    public static void main(String[] args) {
        SearchFibonacci searchFibonacci = new SearchFibonacci();
        System.out.println(searchFibonacci.searchFibonacci2(7));
    }
}
