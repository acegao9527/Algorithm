package ExampleSolution.P101_P150;

public class P123_multiply_strings {

	public String multiply(String num1, String num2) {
        if(num1.length()==0||num2.length()==0)
            return null;
        char[] result = new char[num1.length()+num2.length()];
        for(int i=0;i<num1.length()+num2.length();i++)
            result[i] = '0';
        for (int i = num1.length()-1;i>=0;i--){
            int c1 = num1.charAt(i) - '0';
            int carry = 0;
            for (int j=num2.length()-1;j>=0;j--){
                int c2 = num2.charAt(j) - '0';
                int exist = result[i+j+1]-'0';
                int tResult = carry +exist+c1*c2;
                carry = tResult/10;
                tResult %=10;
                result[i+j+1] = (char) ('0'+tResult);
            }
            if (carry>0){
                result[i] = (char) ('0'+carry);
            }
            
        }
        int start = 0;
        while(start<result.length&&result[start]=='0'){
            start++;
        }
        if(start==result.length){
            return "0";
        }
        String resultS = "";
        for (int i=start;i<result.length;i++){
            resultS += result[i];
        }
        return resultS;
    }
}
