/**
 * Created by wuzhi1234 on 15/7/30.
 */
public class T87_AddBinary {

    public static void main(String[] args) {
        String a = "1111";
        String b = "1111";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;     // i指向a的末尾
        int j = b.length() - 1;     // j指向b的末尾
        int c = 0;      // carry 进位，用来标注进位符
        // 先把String转为char数组便于处理
        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();
        // 结果数组，长度为两个字符串中较长的+2
        char[] reschar = new char[Math.max(achar.length, bchar.length)+2];
        int k = 0;      // k指向结果数组的开头

        while(true){
            if(i<0 && j<0 && c==0){
                break;
            }
            //存储从低位到高位取出来的每位数
            int aint = 0;
            int bint = 0;

            if(i >= 0){
                aint = achar[i] - '0';
            }
            if(j >= 0){
                bint = bchar[j] - '0';
            }
            if(aint + bint + c > 1){
                reschar[k] = (char) ('0' + aint + bint + c - 2);
                c = 1;
            }else{
                reschar[k] = (char) ('0' + aint + bint + c);
                c = 0;
            }
            k++;
            i--;
            j--;
        }
        // char数组转string，然后翻转
        return new StringBuffer(new String(reschar, 0, k)).reverse().toString();
    }

}
