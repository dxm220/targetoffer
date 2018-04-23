package pers.dxm.targetoffer.array.SearchNumberFromTwodimensionalArray_3;

/**
 * Created by douxm on 2018\4\1 0001.
 * title：二维数组中的查找
 * viewpoint：可以将二维数组看作是一个m*n矩阵，利用递归的思想。选取矩阵中右上角的数与target进行比较
 * 如果相等直接结束查找，如果target>右上角数，剔除掉对应列后递归
 * 如果target<右上角数，剔除掉对应行后递归。逐步剔除递归，最终得到true或false
 */
public class SearchNumberFromTwodimensionalArray_3 {

    public boolean find(int target, int[][] array) throws Exception{
        //获取二维数组的行数
        int row = array.length;
        //获取二维数组的列数
        int column = array[0].length;
        //找到当前二维数组右上角的数进行比较,如果target小于右上角的数则递归向左继续寻找；
        //如果target大于右上角的数则则递归向下继续寻找，若找不到则返回false;
        //首先做判空操作，否则程序运行到最后只剩一个元素时会报数组越界
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        if (target < array[0][column - 1]) {
            //构造缩小范围后的新的二维数组
            int[][] newArray = new int[row][column - 1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column - 1; j++) {
                    newArray[i][j] = array[i][j];
                }
            }
            find(target, newArray);
        } else if (target > array[0][column - 1]) {
            //构造缩小范围后的新的二维数组
            int[][] newArray = new int[row - 1][column];
            for (int i = 1; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    newArray[i - 1][j] = array[i][j];
                }
            }
            find(target, newArray);
        } else {
            //这里不能直接return true,因为return的只是当前层级递归的方法，return回去以后还会继续执行上一级递归的程序，以此类推
            //所以说这里如果用return，是达不到直接返回true且程序结束的效果的，必须抛出异常，通过异常的方式强制结束递归的执行
            throw new Exception();
        }
        return false;
    }

    //构造一个二维数组，调用方法进行测试
    public static void main(String[] args) {
        int[][] array = {{1, 2, 8}, {2, 4, 9}, {4, 7, 10}, {6, 8, 11}};
        SearchNumberFromTwodimensionalArray_3 s = new SearchNumberFromTwodimensionalArray_3();
        //调用递归方法时try，然后对递归结果的逻辑代码放在catch中执行
        try {
            System.out.println(s.find(7, array));
        } catch (Exception e) {
            System.out.println(true);
        }
    }

}
