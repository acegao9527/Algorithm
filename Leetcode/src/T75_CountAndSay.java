/**
 * Created by wuzhi1234 on 15/7/28.
 */
public class T75_CountAndSay {
    String countAndSayForOneString(String input) {
        char tmp = input.charAt(0);
        int  num = 1;
        StringBuilder newString = new StringBuilder("");
        for(int k=1;k<input.length();k++) {
            if(input.charAt(k)==tmp) {
                num++;
                continue;
            }
            //如果当前值与之前的不相等，就将之前的连续几个的读法附加到newString的后面
            newString.append(Integer.toString(num)).append(tmp);
            tmp = input.charAt(k);
            num = 1;
        }
        //循环结束的时候并没有添加最新的数字
        newString.append(Integer.toString(num)).append(tmp);
        return newString.toString();
    }

    public String countAndSay(int n) {
        String result = "1";
        int i = 1;
        while(i<n) {
            result = countAndSayForOneString(result);
            i++;
        }
        return result;
    }
}