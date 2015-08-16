package ExampleSolution.P101_P150;

public class P116_implement_strstr {

	public String strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 == 0){
            return haystack;
        }
        if (len1<len2){
            return null;
        }
        int i1 = 0;
        for (;i1<=len1-len2;i1++) {
            if (haystack.charAt(i1)==needle.charAt(0)){
                int j1 =i1+1;
                while (j1-i1<len2&&haystack.charAt(j1)==needle.charAt(j1-i1)){
                    j1++;
                }
                if (j1-i1==len2){
                    return haystack.substring(i1);
                }
            }
        }
        return null;
    }
}
