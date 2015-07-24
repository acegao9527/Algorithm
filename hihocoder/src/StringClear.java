/**
 * Created by wuzhi1234 on 15/7/24.
 */
import java.util.Scanner;

public class StringClear {

    public static int handle(StringBuffer buffer) {
        int count = 0;
        while (true) {
            StringBuffer temp = new StringBuffer();
            int i = 0, j = 1;
            for (; j < buffer.length(); j++) {
                if (buffer.charAt(i) != buffer.charAt(j)) {
                    temp.append(buffer.charAt(i));
                } else {
                    while (j < buffer.length()
                            && buffer.charAt(i) == buffer.charAt(j))
                        j++;
                }
                i = j;
            }
            if (j == buffer.length()) {
                temp.append(buffer.charAt(i));
            }
            if (temp.length() == buffer.length()) {  //跳出总体循环的判断
                count = temp.length();
                break;
            }
            buffer = temp;   //每次筛选完的结果再放进循环里去重新过，直到不在晒了
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            StringBuffer buffer = new StringBuffer(scanner.next());
            int min = buffer.length();
            for (int j = 0; j < buffer.length(); j++) {
                for (char ch = 'A'; ch <= 'C'; ch++) {
                    StringBuffer temp = new StringBuffer(buffer);
                    temp = temp.insert(j, ch);
                    int count = handle(temp);
                    min = min > count ? count : min;
                }
            }
            System.out.println(buffer.length() + 1 - min);
        }
    }
}
