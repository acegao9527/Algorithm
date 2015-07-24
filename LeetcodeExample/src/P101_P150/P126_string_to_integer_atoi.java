package P101_P150;

public class P126_string_to_integer_atoi {

	public int atoi(String str) {
        int value = 0;
        int index = 0;
        boolean negative = false;
        while(index<str.length()&&str.charAt(index)==' '){
            index++;
        }
        if(index>=str.length())
            return 0;
        if (str.charAt(index) =='-'||str.charAt(index) =='+'){
            negative = (str.charAt(index) =='-');
            index++;
        }
        for (;index<str.length();index++){
            if(str.charAt(index) <'0'||str.charAt(index)>'9')
                break;
            int count = str.charAt(index)-'0';
            if (value>Integer.MAX_VALUE/10)
                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            if (value==Integer.MAX_VALUE/10){
                if(negative&&count>=8)
                    return Integer.MIN_VALUE;
                if(!negative&&count>=7)
                    return Integer.MAX_VALUE;
            }
            value = value*10+count;
            
        }
        return negative?-value:value;
    }
}
