package P51_P100;

public class P75_count_and_say {

	public String countAndSay(int n) {
        if (n==0){
            return "";
        }
        int index = 1;
        String result = "1";
        while (index<n){
            String temp = "";
            int times = 1;
            for (int i=1;i<result.length();i++){
                if (result.charAt(i)==result.charAt(i-1)){
                    times++;
                }
                else {
                    temp += times;
                    temp += result.charAt(i-1);
                    times = 1;
                }
            }
            temp += times;
            temp += result.charAt(result.length()-1);
            result = temp;
            index++;
        }
        return result;
    }
}
