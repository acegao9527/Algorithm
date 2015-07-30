/**
 * Created by wuzhi1234 on 15/7/30.
 */
public class J87_AddBinary {
    public String addBinary(String a, String b) {
        //让两个适中保持第一个是长，第二个短
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }

        int pa = a.length()-1;
        int pb = b.length()-1;
        //进位符
        int carries = 0;
        String rst = "";

        while(pb >= 0){
            //求出两位的和加上进位符的数字
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + carries;
            //当下位的数为上面结果模2的值，字符串加法其实就是连接
            rst = String.valueOf(sum % 2) + rst;
            //进位的值为整出2后的结果，2进1，3进1，4进2,貌似没有4进2.。
            carries = sum / 2;
            pa --;
            pb --;
        }
        //当短的已经被遍历完，开始遍历长的

        while(pa >= 0){
            //只需要加自身和进位符的数字
            int sum = (int)(a.charAt(pa) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
        }

        if (carries == 1)
            rst = "1" + rst;
        return rst;
    }
}