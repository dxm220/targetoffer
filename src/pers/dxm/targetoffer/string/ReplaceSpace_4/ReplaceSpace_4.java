package pers.dxm.targetoffer.string.ReplaceSpace_4;

/**
 * Created by douxm on 2018\4\1 0001.
 */
public class ReplaceSpace_4 {

    /**
     *
     */
    public String replaceSpace(StringBuffer str) {
        //首先遍历一遍统计字符串中的空格数
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        //计算替换后字符串的长度，空格变成了%20，相当于替换一个空格需要多出两个字符
        int newLength = str.length() + (count * 2);
        //指定两个指针分别指向新旧字符串的末尾，从后往前遍历，保证最多所有字符只移动一次
        int indexOld = str.length() - 1;//指向旧字符串
        int indexNew = newLength - 1;//指向新字符串
        str.setLength(newLength);//使str的长度扩大到转换成%20之后的长度,防止下标越界
        //循环指针往前移动，遇到空格替换
        for (; indexOld >= 0 && indexOld < newLength; --indexOld) {
            if (str.charAt(indexOld) == ' ') {
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            } else {
                str.setCharAt(indexNew--, str.charAt(indexOld));
            }
        }
        return str.toString();
    }


    /**
     * 借助StringBuffer封装好的append方法进行替换
     * 其实append方法底层的实现是将要拼接的字符合并上原来的字符
     * 复制到一个新的char[]中（即复制到一个新的String串中）
     */
    public String replaceSpace2(StringBuffer str) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                buffer.append('%');
                buffer.append('2');
                buffer.append('0');
            } else {
                buffer.append(str.charAt(i));
            }
        }
        return buffer.toString();
    }
}
