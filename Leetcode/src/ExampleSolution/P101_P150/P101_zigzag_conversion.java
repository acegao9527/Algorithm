package ExampleSolution.P101_P150;

public class P101_zigzag_conversion {

	public String convert(String s, int nRows) {
        if(nRows<=1){
            return s;
        }
        int len = s.length();
        String[] temp = new String[nRows];
        for (int i =0;i<nRows;i++)
            temp[i] = "";
        int size = 2*(nRows-1);
        for(int i=0;i<nRows;i++){
            for (int c=0;c<len;c+=size){
                if(c+i<len)
                    temp[i]+=s.charAt(c+i);
                if(i != 0&&i!=nRows-1&&c+size-i<len)
                    temp[i] += s.charAt(c+size-i);
            }
        }
        String result = "";
        for (int i =0;i<nRows;i++)
            result += temp[i];
        return result;
    }
    public static void main(String[] args) {
        P101_zigzag_conversion t = new P101_zigzag_conversion();
        String a = "PAYPALISHIRING";
        String b = t.convert(a,3);
        System.out.println(b);
    }
}
