/*面试题：替换空格（假设在原来的字符串上替换，并且保证输入的字符串后面有足够多的内存空间）
题目：请实现一个函数，把字符串中的每个空格替换成“20%”。例如输入“hellow new world!”，则输出“hellow02%new02%world!”。
原因：在网络编程中，如果URL参数中含有特殊字符，如：空格、“#”等，可能导致服务器端无法获得正确的参数值。
我们需要将这些特殊符号转换成服务器识别的字符。转换规则是在“%”后面跟上ASCII码的两位十六进制的表。
比如：空格的ASCII玛是32，即十六进制的0x20，因此空格被替换成“%20”。

时间复杂度为o(n2)不足以拿到offer
考虑时间复杂度为O(n)的解法，搞定offer就靠它了
算法描述如下：
从字符串的后面开始复制和替换，首先准备两个指针，p1和p2，p1指向原始字符串的末尾，p2指向替换后字符串的末尾，
接下来，向前移动指针p1，逐个把它指向的字符复制到p2，碰到一个空格之后，把p1向前移动1格，在p2处插入字符串“20%”，
由于“20%”长度为3，同时也要把p2向前移动3格。直到p1=p2，表明所有空格都已经替换完毕。*/

public class ReplaceBlank {
	private static String testString = "hellow new world!";

	// 计算字符串中包含的空格个数
	public static int getBlankNum(String testString) {
		int count = 0;
		for (int i = 0; i < testString.length(); i++) {
			String tempString = String.valueOf(testString.charAt(i));
			if (tempString.equals(" ")) {
				count++;
			}
		}
		return count;
	}

	// 打印char[]数组
	public static void printArray(char[] testArray) {
		for (char i : testArray) {
			System.out.print(i);
		}
		System.out.println();
	}

	// 将字符串空格转换为20%
	public static void replaceAllBlank(String testString) {

		if (testString == null || testString.length() <= 0) {
			return;
		}
		// 字符数组初始长度
		int length = testString.length();
		// 字符数组增加长度后
		int newLength = newLength = getBlankNum(testString) * 2
				+ testString.length();
		char[] tempArray = new char[newLength];
		System.arraycopy(testString.toCharArray(), 0, tempArray, 0, testString
				.toCharArray().length);
		int indexofOriginal = length - 1;//两个指针
		int indexofNew = newLength - 1;
		System.out.println("未替换空格时的字符串：");
		printArray(tempArray);
		while (indexofOriginal >= 0 && indexofOriginal != indexofNew) {
			if (tempArray[indexofOriginal] == ' ') {
				tempArray[indexofNew--] = '%';
				tempArray[indexofNew--] = '2';
				tempArray[indexofNew--] = '0';
			} else {
				tempArray[indexofNew--] = tempArray[indexofOriginal];
			}
			indexofOriginal--;
		}
		System.out.println("替换空格后的字符串：");
		printArray(tempArray);

	}

	public static void main(String[] args) {
		replaceAllBlank(testString);
	}
}
