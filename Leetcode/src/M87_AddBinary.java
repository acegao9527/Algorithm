/**
 * Created by wuzhi1234 on 15/7/30.
 */
/*Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".*/
public class M87_AddBinary {
    public String addBinary(String a, String b) {
        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();
        //a,b长度
        int ap = achar.length - 1;
        int bp = bchar.length - 1;
        //进位符
        int carry = 0;
        int k = 0;
        char[] rst = new char[Math.max(ap,bp)+2];

        while(true){
            if (ap<0 && bp<0 &&carry==0){
                break;
            }
            int aint = 0;
            int bint = 0;
            if (ap>=0){
                aint = achar[ap]-'0';
            }
            if (bp>=0){
                bint = bchar[bp]-'0';
            }
            if (aint+bint+carry>1){
                rst[k]=(char)('0' + aint + bint + carry -2);
                carry=1;
            }
            else {
                rst[k]=(char)('0' + aint + bint + carry);
                carry=0;
            }
            k++;
            ap--;
            bp--;
        }
        return new StringBuffer(new String(rst,0,k)).reverse().toString();
    }

    public static void main(String[] args) {
        M87_AddBinary m = new M87_AddBinary();
        String a = m.addBinary("1111","1011");
        System.out.println(a);
    }
}
