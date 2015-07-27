/**
 * Created by wuzhi1234 on 15/7/27.
 */
/*
* 例如：The string "PAYPALISHIRING"  的蛇形变化如下：

P        A           H        N
A   P   L    S     I     I   G
Y         I            R

最后要求输出的就是："PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

解题思路：貌似可以通过推公式的方法得出结果，我们这里还是用程序模拟的方法得出结果。
用程序的话，初始化一个column行的字符数组，然后按照规则把原始字符串的每个字符加到对应行上，一直到字符串结尾。
以字符串"PAYPALISHIRING" 为例，  ”PAY  P   ALI  S  HIR I NG“   ，新建字符数组  matrix[3]
然后，matrix[0] = matrix[0] + "P";  matrix[1] = matrix[1] + "A";  matrix[2] = matrix[2] + "Y";
                                                        matrix[1] = matrix[1] + "P";
            matrix[0] = matrix[0] + "A";  matrix[1] = matrix[1] + "L";  matrix[2] = matrix[2] + "I";
                                                        matrix[1] = matrix[1] + "S";
            matrix[0] = matrix[0] + "H";  matrix[1] = matrix[1] + "I";  matrix[2] = matrix[2] + "R";
                                                        matrix[1] = matrix[1] + "I";
            matrix[0] = matrix[0] + "N";  matrix[1] = matrix[1] + "G";

最后输出column的每个字符串：PAHN APLSIIGYIR     ，就得到最后最终结果。
*/
public class T101_ZigzagConversion {
    public String convert(String s, int nRows) {
        if (s.length() == 1 || nRows == 1) {
            return s;
        }
        StringBuffer[] matrix = new StringBuffer[nRows];
        int i = 0, end = nRows - 2, index = 0;
        for (i = 0; i < nRows; i++) {
            matrix[i] = new StringBuffer("");
        }
        while (index < s.length()) {        //向下扩展
            for (i = 0; index < s.length() && i <= (nRows - 1); i++) {
                matrix[i].append(s.charAt(index++));
            }            //斜上扩展，也就是向上
            for (end = nRows - 2; index < s.length() && end > 0; end--) {
                matrix[end].append(s.charAt(index++));
            }
        }
        StringBuffer result = new StringBuffer("");
        for (int a = 0; a < nRows; a++) {
            result.append(matrix[a]);
        }
        System.out.println("result=" + result.toString());
        return result.toString();
    }
}

