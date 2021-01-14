package com.yeyangshu.offer;

/**
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如，输入"We are happy."，则输出"We%20are%20happy."。
 *
 * 举一反三：合并两个数组（字符串），此类题目从后往前复制可以减少移动次数，从而提高效率
 */
public class Code05_ReplaceSpace {

    /**
     * 时间复杂度O(n)
     *
     * @param s 输入的字符串
     * @return 替换空格的字符串
     */
    public static String replaceSpace(String s) {
        if (s == null || "".equals(s)) {
            return "string is blank";
        }
        int originLength = 0;
        int blankCounts = 0;
        int i = 0;
        char[] chars = s.toCharArray();

        // 遍历字符串，统计字符串长度和空格个数
        while (i < s.length()) {
            ++originLength;
            if (chars[i] == ' ') {
                ++blankCounts;
            }
            ++i;
        }

        int newLength = originLength + blankCounts * 2;
        int indexOfOrigin = originLength;
        int indexOfNew = newLength;
        char[] newChars = new char[indexOfNew];
        while (indexOfOrigin > 0 && indexOfNew >= indexOfOrigin) {
            if (chars[--indexOfOrigin] == ' ') {
                newChars[--indexOfNew] = '0';
                newChars[--indexOfNew] = '2';
                newChars[--indexOfNew] = '%';
            } else {
                newChars[--indexOfNew] = chars[indexOfOrigin];
            }
        }
        return new String(newChars);
    }

    public static void main(String[] args) {
        String originStr = "We are happy.";
        System.out.println(replaceSpace(originStr));
    }
}