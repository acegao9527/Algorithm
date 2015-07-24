package P51_P100;

public class P87_add_binary {

	public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        String result = "";
        boolean inc = false;
        while(lenA>0||lenB>0){
            int value = 0;
            if (lenA>0){
                value += (a.charAt(lenA-1)-'0');
                lenA--;
            }
            if (lenB>0){
                value += (b.charAt(lenB-1)-'0');
                lenB--;
            }
            if(inc){
                value++;
                inc = false;
            }
            if (value>=2){
                inc = true;
                value -=2;
            }
            result = value+result;
        }
        if(inc){
            result = 1+ result;
        }
        return result;
    }
}
