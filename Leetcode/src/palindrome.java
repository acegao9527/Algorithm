/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.*/
//我的思路
//1.先判断是否为null或者空
//2.定义两个指针分别指向字符串的首位
//3.逐个遍历比较
public class palindrome {
    public boolean isPalindrome(String s) {
    	if (s==null||s.length()==0) {
    		return true;
    	}
    	int start=0, end=s.length()-1;
    	while(start<end){
    		char ch1 = s.charAt(start);
    		char ch2 = s.charAt(end);
            //碰见大写字符就就直接转换
    		if (ch1>='A'&&ch1<='Z'){
    			ch1=(char)(ch1-'A'+'a');
    		}
            //碰见其他字符，直接增加索引，跳出当前循环
    		else if (!((ch1>='a'&&ch1<='z')||(ch1>='0'&&ch1<='9'))) {
    			start++;
    			continue;//
    		}

    		if (ch2>='A'&&ch2<='Z'){
    			ch2=(char)(ch2-'A'+'a');
    		}
    		else if (!((ch2>='a'&&ch2<='z')||(ch2>='0'&&ch2<='9'))) {
    			end--;
    			continue;
    		}
            //判断是否相等，不相等则直接返回false
    		if (ch1!=ch2) {
    			return false;
    		}
            //相等就继续比较
    		start++;end--;
    	}
    	return true;
    }
    public static void main(String[] args) {
    	String s = "0k.;r0.k;";
    	palindrome a =new palindrome();
    	System.out.println(a.isPalindrome(s));
    }
}