public class StrStr {
    public int query(String haystack, String needle) {
        
        if (haystack==null||needle==null) {
            return -1;
        }
        int len1=haystack.length();
        int len2=needle.length();
        if (len2==0) {
            return 0;
        }
        if (len1<len2) {
            return -1;
        }
        char[] char1=haystack.toCharArray();
        char[] char2=needle.toCharArray();
        int found = -1;
        for(int i=0;i<=len1-len2;i++){
            if(char1[i]==char2[0]){
                int k=i;
                for(int j=0;j<len2;j++){
                    if(char1[k]!=char2[j]){
                        break;
                    }
                    k++;
                    if(j==len2-1){
                        return found=k-len2;
                    }
                }
            }
        }
        return found;
    }
    public static void main(String[] args) {
        String a="aaa";
        String b="a";
        StrStr mb = new StrStr();
        int c = mb.query(a,b);
        System.out.println(c);
    }
}