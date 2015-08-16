package MySolution;

/**
 * Created by wuzhi1234 on 15/7/27.
 */
public class M101_ZigzagConversion {
    public String convert(String s,int numRows){
        if (s.length()==1 || numRows==1){
            return s;
        }
        int i,end,index=0;
        StringBuffer[] tmp = new StringBuffer[numRows];
        for (i = 0; i <numRows ; i++) {
            tmp[i] = new StringBuffer("");
        }
        while (index<s.length()){
            //向下遍历
            for (i = 0; i < numRows && index<s.length(); i++) {
                tmp[i].append(s.charAt(index++));
            }
            for (end = numRows-2; end>0 && index<s.length(); end--) {
                tmp[end].append(s.charAt(index++));
            }
        }
        StringBuffer result = new StringBuffer("");
        for (i = 0; i <tmp.length ; i++) {
            result = result.append(tmp[i]);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        M101_ZigzagConversion m = new M101_ZigzagConversion();
        String a = "PAYPALISHIRING";
        String b = m.convert(a,3);
        System.out.println("resource:" + a);
        System.out.println("result:" + b);
    }
}
